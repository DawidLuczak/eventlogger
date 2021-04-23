package io.github.dawidluczak.eventlogger.model;

import java.util.List;
import java.util.Optional;

public interface TimetableRepository {
	
	List<Timetable> findAll();
	
	Optional<Timetable> findById(int id);
	
	boolean existsById(int id);
	
	Timetable save(Timetable entity);
}
