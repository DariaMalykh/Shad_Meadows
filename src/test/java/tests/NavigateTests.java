package tests;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateTests extends TestBase {

    @Test
    public void scrollToSendUsAMassageForm(){
       app.getHelperUser().contactBtnClick();
       Assert.assertTrue(app.getHelperUser().sendUsAMassageFormIsHere());
    }
    @Test
    public void scrollToOurLocationField(){
        app.getHelperUser().locationBtnClick();
        Assert.assertTrue(app.getHelperUser().ourLocationInformationIsHere());
    }
    @Test
    public void scrollToOurRoomsField(){
        app.getHelperUser().roomsBtnClick();
        Assert.assertTrue(app.getHelperUser().ourRoomsFieldIsHere());
    }
    @Test
    public void scrollToCheckAvailabilityForm(){
        app.getHelperUser().bookingBtnClick();
        Assert.assertTrue(app.getHelperUser().availabilityBtnIsHere());
    }
    @Test
    public void scrollToTheEnd(){
        app.getHelperUser().scrollToTheEnd();
        Assert.assertTrue(app.getHelperUser().thisIsFooter());

    }

}
