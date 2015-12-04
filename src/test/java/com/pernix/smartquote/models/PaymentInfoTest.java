package test.java.com.pernix.smartquote.models;

import main.java.com.pernix.smartquote.models.PaymentInfoTest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;
import java.util.Date;

public class PaymentInfoTest {

    private PaymentInfoTest paymentInfo;

    @Test
    public void testCreatePaymentInfo(){
        paymentInfo = new PaymentInfo(123456, "ClientePrueba", "************1234", 30000.0);
        Assert.assertNotNull(paymentInfo);
    }

    @Test
    public void testGetsFromPaymentInfo(){
        Date currentDate = Calendar.getInstance().getTime();
        paymentInfo = new PaymentInfo(123456, "ClientePrueba", "************1234", 30000.0 );
        Assert.assertEquals(123456, paymentInfo.getAuthorization());
        Assert.assertEquals("ClientePrueba", paymentInfo.getCard_account_name());
        Assert.assertEquals("************1234", paymentInfo.getCard_number());
        Assert.assertTrue(30000.0 == paymentInfo.getAmount());
    }
}
