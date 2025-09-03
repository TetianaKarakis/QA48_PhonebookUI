package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("tati123@gmail.com").setPassword( "Tati123!"));
        clickOnLoginButton();
        Assert.assertTrue(isSignOutPresent());
    }
    @Test
    public void loginNegativeWithoutEmailTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setPassword("Tati123!"));
        clickOnLoginButton();
        Assert.assertTrue(isAlertDisplayed());
    }
}
