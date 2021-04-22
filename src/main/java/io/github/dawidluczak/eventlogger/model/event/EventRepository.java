package io.github.dawidluczak.eventlogger.model.event;

import io.github.dawidluczak.eventlogger.model.calendar.date.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
	List<Event> findAll();
	
	Page<Event> findAll(Pageable page);
	
	List<Event> findByDateYearEqualsOrderByDateMonthAscDateDayAsc(int year);
	
	List<Event> findByDateYearAndDateMonthEqualsOrderByDateDayAsc(int year, int month);
	
	List<Event> findByDateYearAndDateMonthAndDateDayEquals(int year, int month, int day);
	
	List<Event> findAllByDateYearIsBetweenOrderByDateYearAscDateMonthAscDateDayAsc(int year, int year2);
	
	List<Event> findAllByDateIsBetweenOrderByDate(Date date, Date date2);
	
	Optional<Event> findById(int id);
	
	boolean existsById(int id);
	
	boolean existsByDoneIsFalseAndUser_Id(int id);
	
	Event save(Event entity);

}
