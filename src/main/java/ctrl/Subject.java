package ctrl;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class Subject {
	
	private static AtomicLong COUNTER = new AtomicLong(0);

	private Long id;
	
	private String name;
	
	private Weight weight;
	
	private Grade grade;

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
		this.weight = weight;
		this.grade = grade;
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

	public Weight getWeight() {
		return weight;
	}

	public void setWeight(Weight weight) {
		this.weight = weight;
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}
	
}
