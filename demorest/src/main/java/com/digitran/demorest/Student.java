package com.digitran.demorest;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Student {
	String Name;
	int points;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		this.Name = name;
	}
	public int getPoints() {
		return points;
	}
	public void setPoints(int points) {
		this.points = points;
	}

}
