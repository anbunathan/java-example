package com.logicbig.example.client;

import com.logicbig.example.Customer;

public class ClientUtil {

    public static String createCustomerInJSON(String name, String address, String phoneNumber) {
        return String.format("{\"name\":\"%s\",\"address\":\"%s\",\"phoneNumber\":\"%s\"}",
                             name, address, phoneNumber);

    }

    public static Customer createNewCustomer(String name, String address, String phoneNumber) {
        Customer newCustomer = new Customer();
        newCustomer.setName(name);
        newCustomer.setAddress(address);
        newCustomer.setPhoneNumber(phoneNumber);
        return newCustomer;
    }

}