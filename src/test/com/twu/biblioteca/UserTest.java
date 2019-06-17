package com.twu.biblioteca;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class UserTest {

    private String reference = "123-4567";
    private String name = "Jade Corcoran";
    private String password = "Password123";
    private User user;

    @Before
    public void setUp(){
        user = new User(reference, name, password);
    }


    @Test
    public void canGetUserReferenceNumber() {
        //given - Setup
        //when - I call getReferenceNumber
        String result = user.getReference();
        //then - the correct reference number is returned
        assertThat(result, is("123-4567"));
    }

    @Test
    public void canGetUserName() {
        //given - setUp
        //when - I call get User Name
        String result = user.getName();
        //then - the correct name is returned
        assertThat(result, is("Jade Corcoran"));
    }

    @Test
    public void canGetUserPassword() {
        //given - setUp
        //when - I call get User Name
        String result = user.getPassword();
        //then - the correct name is returned
        assertThat(result, is("Password123"));
    }


}
