package tests;

import org.testng.annotations.Test;

public class BookingTests extends TestBase {

    @Test
    public void test(){
        app.getHelperBooking().scrollToBookingForm();

    }


}
