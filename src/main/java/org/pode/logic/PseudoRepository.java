package org.pode.logic;

import static org.pode.model.Grade.FOUR;
import static org.pode.model.Grade.ONE;
import static org.pode.model.Grade.ONE_SEVEN;
import static org.pode.model.Grade.THREE_THREE;
import static org.pode.model.Grade.TWO_SEVEN;
import static org.pode.model.Grade.TWO_THREE;
import static org.pode.model.Weight.BA_THESIS;
import static org.pode.model.Weight.THREEFOLD;
import static org.pode.model.Weight.TWOFOLD;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.pode.model.Subject;

public class PseudoRepository {
private static Map<Long, Subject> subjects = new HashMap<>();
	
	public static List<Subject> findAll(){
		return new ArrayList<>(subjects.values());
	}

	public static Subject find(long id){
		return subjects.get(id);
	}
	
	public static Subject add(Subject subject){
		subject = new Subject(subject);
		subjects.put(subject.getId(), subject);
		return subject;
	}
	
	public static void update(Long id, Subject subject){
		subject.setId(id);
		subjects.put(id, subject);
	}
	
	public static Subject delete(Long id){
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
		Subject s9 = new Subject("Bachelorarbeit", BA_THESIS , ONE);
		subjects.put(s9.getId(), s9);
		
	}
}
