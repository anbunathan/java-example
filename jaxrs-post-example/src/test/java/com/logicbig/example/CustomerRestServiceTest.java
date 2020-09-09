package com.logicbig.example;


import com.logicbig.example.api.CustomerRestService;
import com.logicbig.example.client.ClientUtil;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.test.JerseyTest;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;

public class CustomerRestServiceTest extends JerseyTest {

    @Override
    protected Application configure() {
        return new ResourceConfig(CustomerRestService.class);
    }

    @Test
    public void customerRestServiceRawTest() {
        String joe = ClientUtil.createCustomerInJSON("Joe", "435 West Dr, Peejay", "555-456-9877");
        String response = target("customers").request()
                  .post(Entity.entity(joe, MediaType.APPLICATION_JSON),
                        String.class);
        System.out.println(response);
    }

    @Test
    public void customerRestServiceTest() {
        Customer newCustomer = new Customer();
        newCustomer.setName("Jake Mae");
        newCustomer.setAddress("342, Snake Dr, GreenLake");
        newCustomer.setPhoneNumber("444-333-4564");
        String response = target("customers")
                  .request(MediaType.APPLICATION_JSON)
                  .accept(MediaType.TEXT_PLAIN_TYPE)
                  //this time we are calling post to make a HTTP POST call
                  .post(Entity.json(newCustomer), String.class);


        System.out.println(response);
    }
}