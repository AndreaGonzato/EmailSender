package com.company;

public class Main {

    public static void main(String[] args) {
        String password = ""; // set the password of xxx@gmail.com
        String gmailAccount = ""; // xxx@gmail.com
        String recipient = ""; // abc@def.com
        EmailSender emailSender = new EmailSender(gmailAccount, password);
        Email email = new Email(recipient, "important subject", "text of the email");
        emailSender.sendMail(email);
    }
}
