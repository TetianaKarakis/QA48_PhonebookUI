package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    //pre-condition login
    @BeforeMethod
    public void precondition(){
        clickOnLoginLink();
        fillRegisterLoginForm (new User().setEmail("tati123@gmail.com").setPassword( "Tati123!"));
        clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
        clickOnAddLink();
        fillContactForm(new Contact()
                .setName("Jane")
                .setLastName( "Black")
                .setPhone( "12345678963")
                .setEmail( "Jane@gmail.com")
                .setAddress( "Rishon")
                .setDescription( "QA"));
        clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(isContactAdded("Jane"));

    }

    @AfterMethod
    public void postCondition(){

        deleteContact();
    }


}
