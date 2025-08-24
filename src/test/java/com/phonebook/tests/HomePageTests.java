package com.phonebook.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HomePageTests extends TestBase{


    @Test
    public void isHomeComponentPresentTest(){
        //driver.findElement(By.cssSelector("div:nth-child(2)>div>div>h1"));
        //System.out.println("Home Component " + isHomeComponentPresent());
        Assert.assertTrue(isElementPresent(By.xpath("//button[.='Sing Out']")));
    }


}
