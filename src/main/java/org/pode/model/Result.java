package org.pode.model;

import java.util.Collection;
import java.util.List;

public class Result {

	private Collection<String> consideredSubjects;
	
	private int ofHundered;
	
	private double finalGrade;

	public Result(Collection<String> consideredSubjects, int ofHundred, double finalGrade) {
		super();
		this.consideredSubjects = consideredSubjects;
		this.ofHundered = ofHundred;
		this.finalGrade = finalGrade;
	}

	public Collection<String> getConsideredSubjects() {
		return consideredSubjects;
	}

	public void setConsideredSubjects(Collection<String> consideredSubjects) {
		this.consideredSubjects = consideredSubjects;
	}

	public int getOfHundered() {
		return ofHundered;
	}

	public void setOfHundered(int ofHundered) {
		this.ofHundered = ofHundered;
	}

	public double getFinalGrade() {
		return finalGrade;
	}

	public void setFinalGrade(double finalGrade) {
		this.finalGrade = finalGrade;
	}
	
	
	
}
