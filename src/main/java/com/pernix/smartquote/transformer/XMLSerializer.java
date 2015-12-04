package main.java.com.pernix.smartquote.transformer;

import main.java.com.pernix.smartquote.models.PaymentInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;


public class XMLSerializer {

    private final Logger logger = LoggerFactory.getLogger(TransformerEngine.class);

    public String serializePayment(PaymentInfo payment){
        StringWriter stringWriter = new StringWriter();
        Marshaller jaxbMarshaller = null;
        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(PaymentInfo.class);
            jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.marshal(payment, stringWriter);

        } catch (JAXBException e) {
            logger.error("JAXBException at serializePayment in XMLSerializer " + e.getMessage());
        }
        return stringWriter.toString();
    }
}
