package org.pode.logic;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.pode.model.Result;
import org.pode.model.Subject;
import org.springframework.stereotype.Component;

@Component
public class GradeCalculator {

	public Result calculateAverageResult(Collection<Subject> subjects){
		
		double result = 0.0;
		double sum = 0;
		int count = 0;
		
		for(Subject subject : subjects){
			sum += subject.getGrade() * subject.getWeight();
			count += subject.getWeight();
		}
		
		result = sum / count;
		
		List<String> subjectNames = subjects.stream().map(s -> s.getName()).collect(Collectors.toList());
		
		return new Result(subjectNames, count, result);
		
	}
	
}
