package com.onma.service.player.observer;

import com.onma.model.user.UserModel;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import javax.mail.*;
import javax.mail.internet.*;
import java.util.Properties;

public class MailObserver extends Observer {

    public MailObserver(final Subject subject) {
        this.subject = subject;
        this.subject.attach(this);
    }

    @Override
    public void update() {
        final Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String to = ((UserModel) authentication.getPrincipal()).getEmail();

        // Add sender
        String from = "";
        final String username = ""; //your Gmail username
        final String password = ""; //your Gmail password

        String host = "smtp.gmail.com";

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "587");

        // Get the Session object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {
            // Create a default MimeMessage object
            Message message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.setRecipients(Message.RecipientType.TO,
                    InternetAddress.parse(to));

            // Set Subject
            message.setSubject("ONMA Transfer Update");

            // Put the content of your message
            message.setText(subject.getMessage());

            // Send message
            Transport.send(message);
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
