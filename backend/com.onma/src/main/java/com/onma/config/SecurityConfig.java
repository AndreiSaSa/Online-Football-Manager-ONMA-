package com.onma.config;

import com.onma.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private UserService userService;

    @Autowired
    public SecurityConfig(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests()
                .antMatchers("/**").permitAll()

                .antMatchers("/*/login").permitAll()
                .antMatchers(HttpMethod.POST, "/user/register").permitAll()

                // basic operations on users

                .antMatchers(HttpMethod.POST, "/role").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/role").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/role/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/role/{id}").hasRole("ADMIN")

                .antMatchers(HttpMethod.POST, "/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/user").hasRole("ADMIN")
                .antMatchers(HttpMethod.GET, "/user/{id}").hasRole("ADMIN")
                .antMatchers(HttpMethod.DELETE, "/user/{id}").hasRole("ADMIN")

                // crud on entities for masters and admins

                .antMatchers(HttpMethod.POST, "/competition").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.GET, "/competition").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.GET, "/competition/{id}").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.DELETE, "/competition/{id}").hasAnyRole("ADMIN", "MASTER")

                .antMatchers(HttpMethod.POST, "/match").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.GET, "/match").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.GET, "/match/{id}").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.DELETE, "/match/{id}").hasAnyRole("ADMIN", "MASTER")

                .antMatchers(HttpMethod.POST, "/player").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.GET, "/player").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.GET, "/player/{id}").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.DELETE, "/player/{id}").hasAnyRole("ADMIN", "MASTER")

                .antMatchers(HttpMethod.POST, "/team").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.GET, "/team").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.GET, "/team/{id}").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.DELETE, "/team/{id}").hasAnyRole("ADMIN", "MASTER")

                // crud on tactics for users

                .antMatchers(HttpMethod.POST, "/tactic").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/tactic").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/tactic/{id}").hasRole("USER")
                .antMatchers(HttpMethod.DELETE, "/tactic/{id}").hasRole("USER")

                // unique flows

                .antMatchers(HttpMethod.POST, "/team/{id}/select").hasRole("USER")

                .antMatchers(HttpMethod.POST, "/player/{id}/buy").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/player/{id}/pitch-position").hasRole("USER")
                .antMatchers(HttpMethod.POST, "/player/{id}/transfer-list").hasRole("USER")
                .antMatchers(HttpMethod.GET, "/player/market").hasRole("USER")

                .antMatchers(HttpMethod.POST, "/competition/{id}/advance-match-day").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.POST, "/competition/generate-random").hasAnyRole("ADMIN", "MASTER")
                .antMatchers(HttpMethod.POST, "/competition/generate-equal").hasAnyRole("ADMIN", "MASTER")



                .anyRequest().authenticated()
                .and()
                .formLogin().disable()
                .httpBasic();
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
    }

    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public UserService getUserService() {
        return userService;
    }
}