package ru.itis.spingbootdemo.services;

public interface MailsService {

    void sendConfirmEmail(String email, String confirmCode);
}
