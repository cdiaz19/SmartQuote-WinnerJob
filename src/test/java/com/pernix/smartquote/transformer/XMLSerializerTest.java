package test.java.com.pernix.smartquote.transformer;

import main.java.com.pernix.smartquote.models.PaymentInfo;
import main.java.com.pernix.smartquote.transformer.XMLSerializer;
import org.junit.Assert;
import org.junit.Test;
import java.util.Calendar;

public class XMLSerializerTest {

    XMLSerializer xmlSerializer;

    @Test
    public void testSerializePayment(){
        PaymentInfo payment = new PaymentInfo(123456, "ClientePrueba", "************1234", 30000.0);
        xmlSerializer = new XMLSerializer();
        String result = xmlSerializer.serializePayment(payment);
        Assert.assertNotEquals("", result);
    }
}
