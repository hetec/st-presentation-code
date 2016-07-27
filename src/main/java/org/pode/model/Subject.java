package org.pode.model;

import java.util.concurrent.atomic.AtomicLong;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Subject {
	
	private static AtomicLong COUNTER = new AtomicLong(0);

	private Long id;
	
	private String name;
	
	private int weight;
	
	private double grade;

	public Subject(){}
	
	public Subject(Subject subject) {
		this.id = COUNTER.incrementAndGet();
		this.name = subject.getName();
		this.weight = subject.getWeight();
		this.grade = subject.getGrade();
	}
	
	public Subject(String name, Weight weight, Grade grade) {
		this.id = COUNTER.incrementAndGet();
		this.name = name;
		this.weight = weight.getValue();
		this.grade = grade.getValue();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight.getValue();
	}

	public double getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade.getValue();
	}
	
}
