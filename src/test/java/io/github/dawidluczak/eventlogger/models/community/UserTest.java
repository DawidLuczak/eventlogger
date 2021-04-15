package io.github.dawidluczak.eventlogger.models.community;

import io.github.dawidluczak.eventlogger.models.community.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;

class UserTest {
    static User user;

    @BeforeAll
    static void userInit(){
        user = new User("Dawid Luczak");
        Assertions.assertNotNull(user);
    }




}