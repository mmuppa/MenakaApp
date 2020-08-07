package edu.tacoma.uw.mmuppa.menakaapp;

import org.junit.Test;

import edu.tacoma.uw.mmuppa.menakaapp.authenticate.model.User;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void testUserEmailNull() {
        try {
            new User(null, true);
            fail("Cannot set null on email");
        } catch(IllegalArgumentException e) {

        }
    }

    @Test
    public void testUserEmailLengthLT6() {
        try {
            new User("mmuppa", true);
            fail("Cannot be less than 6 characters");
        } catch(IllegalArgumentException e) {

        }
    }

    @Test
    public void testUserEmailContainsAt() {
        try {
            new User("mmuppa", true);
            fail("Cannot be less than 6 characters");
        } catch(IllegalArgumentException e) {

        }
    }

    @Test
    public void testUserEmailValid() {
        try {
            new User("mmuppa@uw.edu", true);
        } catch(IllegalArgumentException e) {

        }
    }
}
