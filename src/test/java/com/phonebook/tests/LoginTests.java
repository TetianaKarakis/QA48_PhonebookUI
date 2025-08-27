package com.phonebook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest(){

        //click on Login link
        click(By.cssSelector("[href='/login']"));
        //enter Email
        type(By.name("email"), "margo9@gmail.com");
        //Enter Password
        type(By.name("password"), "Aa12345!");
        //click on Login button
        click(By.name("login"));
        //verify SignOut is displayed
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sign Out']")));
    }
}
