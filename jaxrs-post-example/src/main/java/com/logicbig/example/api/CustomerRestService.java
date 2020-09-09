package com.logicbig.example.api;


import com.logicbig.example.Customer;
import com.logicbig.example.CustomerDataService;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("customers")
public class CustomerRestService {
    private CustomerDataService dataService = CustomerDataService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Customer> getCustomers() {
        return dataService.getCustomerList();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String createCustomer(Customer newCustomer) {
        return dataService.addCustomer(newCustomer);
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") String id) {
        return dataService.getCustomerById(id);
    }
}