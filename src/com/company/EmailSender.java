package com.company;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import java.util.Properties;

public class EmailSender {


    private final String myAccountEmail;
    private final String myPassword;


    public EmailSender(String myAccountEmail, String myPassword) {
        this.myAccountEmail = myAccountEmail;
        this.myPassword = myPassword;
    }


    public void sendMail(Email email) {
        Properties properties = new Properties();

        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", "smtp.gmail.com");
        properties.put("mail.smtp.port", "587");

        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(myAccountEmail, myPassword);
            }
        });

        Message message = prepareMessage(session, email);

        try {
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

    }

    private Message prepareMessage(Session session, Email email) {
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            //message.setRecipient(Message.RecipientType.CC, new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(email.getRecipient()));
            message.setSubject(email.getSubject());
            message.setText(email.getCorpus());
            return message;
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return null;
    }


}
