package main.java.com.pernix.smartquote.services;

import main.java.com.pernix.smartquote.models.PaymentInfo;
import main.java.com.pernix.smartquote.mysql.connector.MySqlConnector;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import static main.java.com.pernix.smartquote.constants.MySQLConstant.*;

public class MySqlService {

    private static final String SELECT_NEW_PAYMENT =   "SELECT r.id, r.card_number, r.card_account_name, r.amount, r.authorization \n" +
                                                       "FROM payment p \n" +
                                                       "WHERE 1 \n";

    private static final String UPDATE_NEW_PAYMENT = "UPDATE payment SET isnotified_open = b'1', status=1 WHERE id = ";
    private MySqlConnector mySqlConnector;
    private final Logger logger = LoggerFactory.getLogger(MySqlService.class);


    public MySqlService(MySqlConnector mySqlConnector) {
        this.mySqlConnector = mySqlConnector;
    }

    public MySqlService(){
        mySqlConnector =  new MySqlConnector();
    }

    public ResultSet selectNewPayment () {
        Statement statement = null;
        ResultSet selectResult = null;

        try {
            statement = mySqlConnector.getMysqlConnection().createStatement();
            selectResult = statement.executeQuery(SELECT_NEW_PAYMENT);
        } catch (SQLException e) {
            logger.error("SQLException at selectNewPayment in MySqlService " + e.getMessage());
        }
        return selectResult;
    }
    public HashMap<String, ArrayList<PaymentInfo>> getNewPayment() {
        ResultSet selectResult = selectNewPayment();
        HashMap<String, ArrayList<PaymentInfo>>  paymentRetrieved = new HashMap<>();
        try {
            while (selectResult.next()){
                PaymentInfo paymentinfo = getPaymentObjectFromResultSet(selectResult);
                if (!paymentIsInHash(paymentRetrieved, paymentinfo)) {
                    addEmptyListToPaymentHash(paymentRetrieved, paymentinfo);
                }
                addPaymentToList(paymentRetrieved, paymentinfo);
            }
        } catch (SQLException e) {
            logger.error("SQLException at getNewPayment in MySqlService " + e.getMessage());
        }
        return paymentRetrieved;
    }

    private boolean addPaymentToList(HashMap<String, ArrayList<PaymentInfo>> paymentRetrieved, paymentInfo paymentInfo) {
        return paymentRetrieved.get(String.valueOf(paymentInfo.getPayment_id())).add(paymentInfo);
    }

    private boolean paymentIsInHash(HashMap<String, ArrayList<PaymentInfo>> paymentRetrieved, PaymentInfo paymentInfo) {
        return paymentRetrieved.keySet().contains(String.valueOf(paymentInfo.getPayment_id()));
    }

    private void addEmptyListToPaymentHash(HashMap<String, ArrayList<PaymentInfo>> paymentRetrieved, PaymentInfo paymentInfo) {
        paymentRetrieved.put(String.valueOf(paymentInfo.getPayment_id()), new ArrayList<>());
    }

    private PaymentInfo getPaymentObjectFromResultSet(ResultSet resultSet) throws SQLException {
        PaymentInfo payment = new PaymentInfo();

        payment.setPayment_id(resultSet.getInt(PAYMENT_ID));
        payment.setCard_Number(resultSet.getChar(CARD_NUMBER));
        payment.setAmount(resultSet.getDouble(AMOUNT));
        payment.setCard_Number_Name(resultSet.getChar(CARD_NUMBER_NAME));
        payment.setAuthorization(resultSet.getChar(AUTHORIZATION));

        return payment;
    }

    public void setPaymentNotified(int id){
        PreparedStatement statement = null;
        try {
            statement = mySqlConnector.getMysqlConnection().prepareStatement(UPDATE_PAYMENT + id);
            statement.executeUpdate();
        } catch (SQLException e) {
            logger.error("Error at setPaymentNotified in MySqlService " + e.getMessage());
        }
    }
}
