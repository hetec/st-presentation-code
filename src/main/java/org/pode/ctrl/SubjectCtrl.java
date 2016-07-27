package org.pode.ctrl;

import static org.pode.logic.PseudoRepository.add;
import static org.pode.logic.PseudoRepository.delete;
import static org.pode.logic.PseudoRepository.find;
import static org.pode.logic.PseudoRepository.findAll;
import static org.pode.logic.PseudoRepository.update;

import java.util.List;
import java.util.Objects;

import org.pode.logic.GradeCalculator;
import org.pode.model.Result;
import org.pode.model.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
		value="/api/v1",
		produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
		consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
public class SubjectCtrl {
	
	private GradeCalculator calculator;
	
	@Autowired
	public SubjectCtrl(GradeCalculator calculator) {
		this.calculator = calculator;
	}
	
	

	@RequestMapping(value="/subjects", method=RequestMethod.GET)
	public @ResponseBody List<Subject> allSubjects(){
		return findAll();//new ResponseEntity<Collection<Subject>>(findAll(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/subjects/{id}",
			method=RequestMethod.GET,
			produces={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public ResponseEntity<Subject> singleSubject(@PathVariable Long id){
		Subject s = find(id);
		if(Objects.nonNull(s)){
			return new ResponseEntity<Subject>(s, HttpStatus.OK);
		}else{
			return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(value="/subjects", method=RequestMethod.POST)
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject){
		subject = add(subject);
		return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/subjects/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> updateSubject(@PathVariable Long id, @RequestBody Subject subject){
		update(id, subject);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/subjects/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSubject(@PathVariable Long id){
		Subject s = delete(id);
		if(Objects.isNull(s)){
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}else{
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}
	
	@RequestMapping(value="/subjects/averageResult", method=RequestMethod.POST)
	public ResponseEntity<Result> caclulateAverageResult(){
		Result result = calculator.calculateAverageResult(findAll());
		return new ResponseEntity<Result>(result, HttpStatus.CREATED);
	}
}

