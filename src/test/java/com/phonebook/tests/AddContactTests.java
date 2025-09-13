package com.phonebook.tests;

import com.phonebook.data.ContactData;
import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddContactTests extends TestBase{

    //pre-condition login
    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail("tati123@gmail.com").setPassword( "Tati123!"));
        app.getUser().clickOnLoginButton();
    }

    @Test
    public void addContactPositiveTest(){
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName(ContactData.NAME)
                .setLastName( ContactData.LASTNAME)
                .setPhone( ContactData.PHONE)
                .setEmail(ContactData.EMAIL)
                .setAddress(ContactData.ADDRESS)
                .setDescription( ContactData.DESCRIPTION));
        app.getContact().clickOnSaveButton();
        //verify contact is added
        Assert.assertTrue(app.getContact().isContactAdded("Jane"));

    }

    @AfterMethod
    public void postCondition(){

        app.getContact().deleteContact();
    }


}
