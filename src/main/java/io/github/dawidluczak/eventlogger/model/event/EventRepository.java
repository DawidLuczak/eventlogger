package io.github.dawidluczak.eventlogger.model.event;

import io.github.dawidluczak.eventlogger.model.calendar.date.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventRepository {
	List<Event> findAll();
	
	Page<Event> findAll(Pageable page);
	
	List<Event> findByStartDateYearEqualsOrderByStartDateMonthAscStartDateDayAsc(int year);
	
	List<Event> findByStartDateYearAndStartDateMonthEqualsOrderByStartDateDayAsc(int year, int month);
	
	List<Event> findByStartDateYearAndStartDateMonthAndStartDateDayEquals(int year, int month, int day);
	
	List<Event> findAllByStartDateYearIsBetweenOrderByStartDateYearAscStartDateMonthAscStartDateDayAsc(int year, int year2);
	
	List<Event> findAllByStartDateIsBetweenOrderByStartDate(Date date, Date date2);
	
	Optional<Event> findById(int id);
	
	boolean existsById(int id);
	
	boolean existsByEventGroupId(int eventGroupId);
	
	boolean existsByDoneIsFalseAndEventGroupId(int id);
	
	Event save(Event entity);

}
