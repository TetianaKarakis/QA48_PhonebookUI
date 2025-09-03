package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
       // int i = (int)((System.currentTimeMillis()/1000)%3600);
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("tati123@gmail.com").setPassword( "Tati123!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isSignOutPresent());
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("tati123@gmail.com").setPassword( "Tati123!"));
        clickOnRegistrationButton();
        Assert.assertTrue(isAlertDisplayed());


    }

}
