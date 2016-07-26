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
		Subject s1 = new Subject("Serverseritge Technologien", ONEFOLD , ONE_SEVEN);
		subjects.put(s1.getId(), s1);
		Subject s2 = new Subject("Audio- und Videoverarbeitung", Weight.TWOFOLD , THREE_THREE);
		subjects.put(s2.getId(), s2);
		
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
}

