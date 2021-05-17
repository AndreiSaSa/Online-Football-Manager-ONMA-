package com.onma.service.user;

import com.onma.model.user.UserModel;
import com.onma.repository.user.UserRepository;
import com.onma.service.base.AbstractServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UserServiceImpl extends AbstractServiceImpl<UserModel> implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {
        return userRepository.getByUsername(username);
    }

    @Override
    public void saveOrUpdate(final UserModel user) {
        if(user.getPassword().isEmpty()) {
            user.setPassword(userRepository.getById(user.getId()).getPassword());
        }
        else {
            user.setPassword(getPasswordEncoder().encode(user.getPassword()));
        }
        userRepository.save(user);
    }

    @Override
    public UserModel login(UserModel loginUser) {
        final UserModel userModel = userRepository.getByUsername(loginUser.getUsername());
        if (userModel == null) {
            throw new EntityNotFoundException("INVALID_CREDENTIALS");
        }

        if (!getPasswordEncoder().matches(loginUser.getPassword(), userModel.getPassword())) {
            throw new EntityNotFoundException("INVALID_CREDENTIALS");
        }

        loginUser.setId(userModel.getId());
        loginUser.setRole(userModel.getRole());

        return loginUser;
    }

    private PasswordEncoder getPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
