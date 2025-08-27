package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTests extends TestBase{

    @Test(enabled = false)
    public void newUserRegistrationPositiveTest(){
        int i = (int)((System.currentTimeMillis()/1000)%3600);
        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "margo9"+i+"@gmail.com");
        //Enter Password
        type(By.name("password"), "Aa12345!");
        //click on Registration button
        click(By.name("registration"));
        //verify SignOut is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }

    @Test
    public void existedUserRegistrationNegativeTest(){
        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "margo9@gmail.com");
        //Enter Password
        type(By.name("password"), "Aa12345!");
        //click on Registration button
        click(By.name("registration"));
        //verify alert is displayed
        Assert.assertTrue(isAlertDisplayed());


    }

}
