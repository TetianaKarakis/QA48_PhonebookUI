package com.phonebook.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    //pre-condition login
    @BeforeMethod
    public void precondition(){
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("tati123@gmail.com").setPassword( "Tati123!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Jane")
                .setLastName( "Black")
                .setPhone( "12345678963")
                .setEmail( "Jane@gmail.com")
                .setAddress( "Rishon")
                .setDescription( "QA"));
        app.getContact().clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(app.getContact().isContactAdded("Jane"));

    }

    @AfterMethod
    public void postCondition(){

        app.getContact().deleteContact();
    }


}
