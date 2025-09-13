package com.phonebook.tests;

import com.phonebook.data.UserData;
import com.phonebook.models.Contact;
import com.phonebook.models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DeleteContactTests extends TestBase{
    //precondition
    //login
    //add

    @BeforeMethod
    public void precondition(){
        if (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getUser().clickOnLoginLink();
        app.getUser().fillRegisterLoginForm(new User().setEmail(UserData.EMAIL).setPassword( UserData.PASSWORD));
        app.getUser().clickOnLoginButton();
        app.getContact().clickOnAddLink();
        app.getContact().fillContactForm(new Contact()
                .setName("Tati")
                .setLastName( "kar")
                .setPhone( "12345678963")
                .setEmail( "tati123@gmail.com")
                .setAddress( "BatYam")
                .setDescription( "QA"));
        app.getContact().clickOnSaveButton();
    }

    @Test
    public void deleteContactTest(){
        int sizeBefore = app.getContactCount();
        app.getContact().deleteContact();
        app.getContact().pause(1000);
        int sizeAfter = app.getContactCount();
        Assert.assertEquals(sizeAfter,sizeBefore-1);
    }





}
