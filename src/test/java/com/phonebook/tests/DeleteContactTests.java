package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    //precondition
    //login
    //add

    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm(new User().setEmail("tati123@gmail.com").setPassword( "Tati123!"));
        clickOnLoginButton();

        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Jane")
                .setLastName( "Black")
                .setPhone( "12345678963")
                .setEmail( "Jane@gmail.com")
                .setAddress( "Rishon")
                .setDescription( "QA"));
        clickOnSaveButton();
    }

    @Test
    public void deleteContactTest(){
        int sizeBefore = sizeOfContacts();
        deleteContact();
        pause(1000);
        int sizeAfter = sizeOfContacts();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }





}
