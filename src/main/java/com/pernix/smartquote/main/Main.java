package main.java.com.pernix.smartquote.main;

import main.java.com.pernix.smartquote.models.PaymentInfo;
import main.java.com.pernix.smartquote.services.MailService;
import main.java.com.pernix.smartquote.services.MySqlService;
import main.java.com.pernix.smartquote.services.ServiceFactory;
import main.java.com.pernix.smartquote.transformer.TransformerEngine;
import main.java.com.pernix.smartquote.transformer.XMLSerializer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static final String EMAIL_SUBJECT = new String("Su Solicitud ha sido Aceptada");

    public static void main(String[] args) {
        MySqlService mySqlService = new MySqlService();
        HashMap<String, ArrayList<PaymentInfo>> requisitionsRetrieved = mySqlService.getNewPayment();
        MailService mailService = ServiceFactory.getMailService();
        TransformerEngine transformerEngine = new TransformerEngine();
        XMLSerializer xmlSerializer = new XMLSerializer();

        for (Map.Entry<String, ArrayList<PaymentInfo>> paymentInfoListByRequisitionId : paymentRetrieved.entrySet()){
            ArrayList<PaymentInfo> payment = paymentInfoListByRequisitionId.getValue();
            String mailBody = transformerEngine.transformXMLtoHTML(xmlSerializer.serializePayment(payment.get(0)));
            mailService.generateAndSendEmail(getEmailAddressesIntoArray(payment), EMAIL_SUBJECT, mailBody);
            mySqlService.setPaymentNotified(Integer.parseInt(paymentInfoListByPaymentId.getKey()));
        }
    }

    private static  ArrayList<String> getEmailAddressesIntoArray(ArrayList<PaymentInfo> payment) {
        ArrayList<String> emails = new ArrayList<>();
        for (PaymentInfo paymentInfo : payment){
            emails.add(paymentInfo.getEmail());
        }
        return emails;
    }
}
