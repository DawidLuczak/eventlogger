package io.github.dawidluczak.eventlogger.community;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    static User user;

    @BeforeAll
    static void userInit(){
        user = new User("Dawid Luczak");
        Assertions.assertNotNull(user);
    }




}