package com.movieWorld.security.registration.email;

public interface EmailSender {

    void send(String to, String email);
}
