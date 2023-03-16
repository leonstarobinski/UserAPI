package com.userapp.example.demo;

import com.userapp.example.demo.Models.User;
import com.userapp.example.demo.Models.UserValidator;
import org.junit.jupiter.api.Test;

import static org.springframework.test.util.AssertionErrors.*;

public class UserTests {
    User validUser = new User("Leon", "Starobinski", "leonstarobinski@gmail.com", "BestPassword123!", "16.09.1994");

    @Test
    public void userCanBeCreated(){
        assertEquals(validUser.getFirstName(), "Leon", "Leon");
    }
    @Test
    public void userValidationsTest(){
        assertTrue(null,UserValidator.validate(validUser));
    }

    @Test
    public void userIsNotValid(){
        User invalidUser = new User("","","","","");
        assertFalse("",UserValidator.validate(invalidUser));
        assertFalse("", UserValidator.validateName(invalidUser.getFirstName()));
        assertFalse("", UserValidator.validateName(invalidUser.getLastName()));
        assertFalse("", UserValidator.validateEmail(invalidUser.getEmail()));
        assertFalse("", UserValidator.validatePassword(invalidUser.getPassword()));
    }
}
