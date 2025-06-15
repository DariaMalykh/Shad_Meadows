package tests;

import org.checkerframework.checker.units.qual.A;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigateTests extends TestBase {

    @Test
    public void scrollToSendUsAMassageForm(){
       app.getHelperNavigate().contactBtnClick();
       Assert.assertTrue(app.getHelperNavigate().sendUsAMassageFormIsHere());
    }
    @Test
    public void scrollToOurLocationField(){
        app.getHelperNavigate().locationBtnClick();
        Assert.assertTrue(app.getHelperNavigate().ourLocationInformationIsHere());
    }
    @Test
    public void scrollToOurRoomsField(){
        app.getHelperNavigate().roomsBtnClick();
        Assert.assertTrue(app.getHelperNavigate().ourRoomsFieldIsHere());
    }
    @Test
    public void scrollToCheckAvailabilityForm(){
        app.getHelperNavigate().bookingBtnClick();
        Assert.assertTrue(app.getHelperNavigate().availabilityBtnIsHere());
    }
    @Test
    public void scrollToTheEnd(){
        app.getHelperNavigate().scrollToFooter();
        Assert.assertTrue(app.getHelperNavigate().isFooterVisible());
    }

}
