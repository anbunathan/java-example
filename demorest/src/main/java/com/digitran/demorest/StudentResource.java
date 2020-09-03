package com.digitran.demorest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("students")
public class StudentResource {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public Student getStudent() {
		System.out.println("getStudent() is called");
		Student student = new Student();
		student.setName("David"); 
		student.setPoints(60);
		return student;
	}

}
