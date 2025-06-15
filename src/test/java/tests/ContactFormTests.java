package tests;

import models.User;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class ContactFormTests extends TestBase{


    @Test
    public void contactFormSuccessfullySubmittedAllFields(){
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
        softAssert.assertEquals("Thanks for getting in touch "+user.getName()+"!",
                app.getHelperUser()
                        .getElementText(By.xpath("//h3[contains(text(),'Thanks for getting in touch')]")));
        softAssert.assertEquals(user.getSubject(),app.getHelperUser()
                .getElementText(By.xpath("//p[text()='" + user.getSubject() + "']")));
        softAssert.assertAll();
    }
}
