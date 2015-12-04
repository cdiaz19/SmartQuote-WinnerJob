package main.java.com.pernix.smartquote.models;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@XmlRootElement
public class PaymentInfo {

    private char card_number;
    private double amount;
    private char card_account_name;
    private char authorization;

    public PaymentInfo() {
    }

    public PaymentInfo(char authorization, char card_account_name, char card_number, double amount) {
        this.authorization = authorization;
        this.card_account_name = card_account_name;
        this.card_number = card_number;
        this.amount = amount;
    }


    }

    public double getCard_Number() { return card_number; }

    @XmlElement
    public void setCard_Number(int card_number) {
        this.card_number = card_number;
    }

    public double getAmount() {
        return base_amount;
    }

    @XmlElement
    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Date getCard_account_name() {
        return card_account_name;
    }

    @XmlElement
    public void setCard_account_name(char card_account_name) { this.card_account_name = card_account_name; }

    public String getAuthorization() {
        return authorization;
    }

    @XmlElement
    public void setAuthorization(char authorization) {
        this.authorization = authorization;
    }

}
