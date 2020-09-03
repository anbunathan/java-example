package com.digitran.demorest;

import java.util.Arrays;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.apache.catalina.LifecycleListener;

@Path("studentslist")
public class arrayofresources {
	@GET
	@Produces(MediaType.APPLICATION_XML)
	public List<Student> getStudent() {
		System.out.println("getStudent() is called");
		Student student1 = new Student();
		student1.setName("David"); 
		student1.setPoints(60);
		
		Student student2 = new Student();
		student2.setName("Lara"); 
		student2.setPoints(80);		
		
		List<Student> students = Arrays.asList(student1, student2); 
		
		return students;
	}

}
