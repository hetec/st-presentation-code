package ctrl;

import java.lang.reflect.Array;
import static ctrl.Weight.*;
import static ctrl.Grade.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

import javax.net.ssl.HttpsURLConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(
		value="/api/v1",
		produces=MediaType.APPLICATION_JSON_VALUE)
public class SubjectCtrl {
	
	private GradeCalculator calculator;
	
	@Autowired
	public SubjectCtrl(GradeCalculator calculator) {
		this.calculator = calculator;
	}
	
	private static Map<Long, Subject> subjects = new HashMap<>();
	
	private static Subject find(long id){
		return subjects.get(id);
	}
	
	private static Subject add(Subject subject){
		subject = new Subject(subject);
		subjects.put(subject.getId(), subject);
		return subject;
	}
	
	private static void update(Long id, Subject subject){
		subject.setId(id);
		subjects.put(id, subject);
	}
	
	private static Subject delete(Long id){
		return subjects.remove(id);
	}
	
	static {
		Subject s1 = new Subject("Serverseritge Technologien", THREEFOLD , ONE_SEVEN);
		subjects.put(s1.getId(), s1);
		Subject s2 = new Subject("Audio- und Videoverarbeitung", THREEFOLD , THREE_THREE);
		subjects.put(s2.getId(), s2);
		Subject s3 = new Subject("Rechnerprogrammierung und WebTechnologien", THREEFOLD , ONE);
		subjects.put(s3.getId(), s3);
		Subject s4 = new Subject("Volks- und Betriebswirtschaftslehre"
				+ " und wissenschaftliches Arbeiten", TWOFOLD , TWO_SEVEN);
		subjects.put(s4.getId(), s4);
		Subject s5 = new Subject("Betriebssysteme", THREEFOLD , FOUR);
		subjects.put(s5.getId(), s5);
		Subject s6 = new Subject("Investitionen, Finanzierung "
				+ "und Unternehmensführung", TWOFOLD , THREE_THREE);
		subjects.put(s6.getId(), s6);
		Subject s7 = new Subject("Digitaltechnik und Rechnerarchitektur", THREEFOLD , TWO_THREE);
		subjects.put(s7.getId(), s7);
		Subject s8 = new Subject("Fachenglisch und "
				+ "Kommunikationstechniken", TWOFOLD , THREE_THREE);
		subjects.put(s8.getId(), s8);
		Subject s9 = new Subject("Bachelorarbeit", BA_THESIS , TWO_THREE);
		subjects.put(s9.getId(), s9);
		
	}

	@RequestMapping(value="/subjects", method=RequestMethod.GET)
	public ResponseEntity<Collection<Subject>> allSubjects(){
		return new ResponseEntity<Collection<Subject>>(subjects.values(), HttpStatus.OK);
	}
	
	@RequestMapping(value="/subjects/{id}", method=RequestMethod.GET)
	public ResponseEntity<Subject> singleSubject(@PathVariable Long id){
		Subject s = find(id);
		if(Objects.nonNull(s)){
			return new ResponseEntity<Subject>(s, HttpStatus.OK);
		}else{
			return new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
		}	
	}
	
	@RequestMapping(value="/subjects", method=RequestMethod.POST, consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Subject> addSubject(@RequestBody Subject subject){
		subject = add(subject);
		return new ResponseEntity<Subject>(subject, HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/subjects/{id}", method=RequestMethod.PUT, consumes=MediaType.APPLICATION_JSON_VALUE)
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
		Result result = calculator.calculateAverageResult(subjects.values());
		return new ResponseEntity<Result>(result, HttpStatus.CREATED);
	}
}

