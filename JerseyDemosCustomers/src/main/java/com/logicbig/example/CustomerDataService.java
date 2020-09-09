package com.logicbig.example;

import java.util.ArrayList;
import java.util.List;

public class CustomerDataService {
    private List<Customer> customerList = new ArrayList<>();

    private static CustomerDataService ourInstance = new CustomerDataService();

    public static CustomerDataService getInstance() {
        return ourInstance;
    }

    public String addCustomer(Customer customer) {
        String newId = Integer.toString(customerList.size() + 1);
        customer.setId(newId);
        customerList.add(customer);
        return newId;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }


    public Customer getCustomerById(String id) {
        for (Customer customer : customerList) {
            if (customer.getId().equals(id)) {
                return customer;
            }
        }

        return null;
    }


}