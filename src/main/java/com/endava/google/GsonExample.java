package com.endava.google;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class GsonExample {

    private static final Logger LOGGER = LogManager.getLogger(GsonExample.class);

    public static void main(String[] args) {
        Payment p = new Payment();
        p.setAmount(100.0);
        p.setCurrency("RON");
        p.setCardNumber("2345678987654");
        p.setCustomerName("John Travolta");

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(p);   //serializare
        LOGGER.info( "\n{}", json);

        Payment dP = gson.fromJson(json, Payment.class);  //deserializare
        LOGGER.info(p.equals(dP));  //ceea ce am serializat este egal cu ceea ce am deserializat
        LOGGER.info(dP.getCardNumber());
    }
}
