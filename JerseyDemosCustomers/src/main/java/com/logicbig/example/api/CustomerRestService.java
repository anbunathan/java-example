package com.logicbig.example.api;


import com.logicbig.example.Customer;
import com.logicbig.example.CustomerDataService;

import javax.ws.rs.*;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import java.io.IOException;
import java.util.List;

@Path("customers")
public class CustomerRestService {
    private CustomerDataService dataService = CustomerDataService.getInstance();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getCustomers() {
    	
    	List<Customer> custlist = dataService.getCustomerList();
    	System.out.println("size of custlist = "+custlist.size());
    	GenericEntity< List< Customer > > entity;
    	entity  = new GenericEntity< List< Customer > >( custlist ) { };
//        return dataService.getCustomerList();
    	return Response.status(201).entity(entity)
				.header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .allow("OPTIONS")
				.build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response createCustomer(Customer newCustomer) {
    	String result = dataService.addCustomer(newCustomer);
    	List<Customer> custlist = dataService.getCustomerList();
    	System.out.println("size of custlist = "+custlist.size());
    	GenericEntity< List< Customer > > entity;
    	entity  = new GenericEntity< List< Customer > >( custlist ) { };
//        return dataService.addCustomer(newCustomer);
    	return Response.status(201).entity(entity)
				.header("Access-Control-Allow-Origin", "*")
			      .header("Access-Control-Allow-Credentials", "true")
			      .header("Access-Control-Allow-Headers",
			        "origin, content-type, accept, authorization")
			      .header("Access-Control-Allow-Methods", 
			        "GET, POST, PUT, DELETE, OPTIONS, HEAD")
			      .allow("OPTIONS")
				.build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer getCustomer(@PathParam("id") String id) {
        return dataService.getCustomerById(id);
    }
    
    
}