package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ContactFormTests extends TestBase{
    @BeforeMethod
    public void precondition(){
        app.getHelperUser().click(By.xpath("//span[contains(text(), 'Shady Meadows')]"));
    }

    @Test
    public void contactFormSuccessfullySubmitted(){
        User user = User.builder().name("Daria")
                .email("d@gmail.com")
                .phone("89127896765")
                .subject("Problems")
                .message("Houston we have problems!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(app.getHelperUser().contactFormSuccessfullySubmitted());
        softAssert.assertTrue(app.getHelperUser().isMessagePresent("Thanks for getting in touch "+user.getName()+"!"));
        softAssert.assertEquals(user.getSubject(),app.getHelperUser()
                .getElementText(By.xpath("//p[text()='" + user.getSubject() + "']")));
        softAssert.assertAll();
    }
    @Test
    public void contactFormIsBlank(){
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser()
                .allMessageIsHere
                        ("Message must be between 20 and 2000 characters." +
                                "Subject may not be blank" +
                                "Name may not be blank" +
                                "Subject must be between 5 and 100 characters." +
                                "Message may not be blank" +
                                "Email may not be blank" +
                                "Phone must be between 11 and 21 characters." +
                                "Phone may not be blank"));
    }
    @Test
    public void contactFormBlankName(){
        User user = User.builder().name("")
                .email("d@gmail.com")
                .phone("89127896765")
                .subject("Problems")
                .message("Houston we have problems!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Name may not be blank"));
        Assert.assertTrue(app.getHelperUser().allMessageIsHere("Name may not be blank"));
    }
    @Test
    public void contactFormBlankEmail(){
        User user = User.builder().name("Daria")
                .email("")
                .phone("89127896765")
                .subject("Problems")
                .message("Houston we have problems!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Email may not be blank"));
        Assert.assertTrue(app.getHelperUser().allMessageIsHere("Email may not be blank"));

    }
    @Test
    public void contactFormBlankPhone(){
        User user = User.builder().name("Daria")
                .email("d@gmail.com")
                .phone("")
                .subject("Problems")
                .message("Houston we have problems!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().allMessageIsHere("Phone may not be blank" +
                "Phone must be between 11 and 21 characters."));

    }
    @Test
    public void contactFormBlankSubject(){
        User user = User.builder().name("Daria")
                .email("d@gmail.com")
                .phone("89127896765")
                .subject("")
                .message("Houston we have problems!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().allMessageIsHere("Subject may not be blank" +
                "Subject must be between 5 and 100 characters."));

    }
    @Test
    public void contactFormBlankMessage(){
        User user = User.builder().name("Daria")
                .email("d@gmail.com")
                .phone("89127896765")
                .subject("Problems")
                .message("")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().allMessageIsHere("Message must be between 20 and 2000 characters." +
                "Message may not be blank"));

    }
    @Test
    public void contactFormWrongEmail(){
        User user = User.builder().name("Daria")
                .email("dgmail.com")
                .phone("89127896765")
                .subject("Problems")
                .message("Houston we have problems!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("must be a well-formed email address"));

    }
    @Test
    public void contactFormWrongSubject(){
        User user = User.builder().name("Daria")
                .email("d@gmail.com")
                .phone("89127896765")
                .subject("Prob")
                .message("Houston we have problems!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Subject must be between 5 and 100 characters."));

    }
    @Test
    public void contactFormWrongPhone(){
        User user = User.builder().name("Daria")
                .email("d@gmail.com")
                .phone("891")
                .subject("Problems")
                .message("Houston we have problems!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Phone must be between 11 and 21 characters."));

    }
    @Test
    public void contactFormWrongMessage(){
        User user = User.builder().name("Daria")
                .email("d@gmail.com")
                .phone("89127896765")
                .subject("Problems")
                .message("Houston!")
                .build();
        app.getHelperUser().scrollToMessageField();
        app.getHelperUser().fillSendAsMessageForm(user);
        app.getHelperUser().clickSubmitBtn();
        app.getHelperUser().scrollToAlertField();
        Assert.assertTrue(app.getHelperUser().allMessageIsHere("Message must be between 20 and 2000 characters."));

    }

    }

