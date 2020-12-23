package com.company;

public class Email {

    private final String subject;
    private final String corpus;
    private final String recipient;


    public Email(String recipient, String subject, String text) {
        this.recipient = recipient;
        this.subject = subject;
        this.corpus = text;
    }


    public String getSubject() {
        return subject;
    }

    public String getCorpus() {
        return corpus;
    }

    public String getRecipient() {
        return recipient;
    }
}
