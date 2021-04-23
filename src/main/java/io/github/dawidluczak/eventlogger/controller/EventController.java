package io.github.dawidluczak.eventlogger.controller;


import io.github.dawidluczak.eventlogger.model.event.Event;
import io.github.dawidluczak.eventlogger.model.event.EventRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
class EventController {
	public static final Logger logger = LoggerFactory.getLogger(EventController.class);
	private final EventRepository repository;
	
	EventController(final EventRepository repository) {
		this.repository = repository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events", params = {"!sort","!page","!size"})
	ResponseEntity<?> readAllEvents(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events")
	ResponseEntity<List<Event>> readAllEvents(Pageable page){
		return ResponseEntity.ok(repository.findAll(page).getContent());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events/{id}")
	ResponseEntity<?> readEventById(@PathVariable int id){
		if (!repository.existsById(id))
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok(repository.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events/y{year}")
	ResponseEntity<List<Event>> readEventsByYear(@PathVariable int year){
		return ResponseEntity.ok(repository.findByStartDateYearEqualsOrderByStartDateMonthAscStartDateDayAsc(year));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events/y{year}/m{month}")
	ResponseEntity<List<Event>> readEventsByYearAndMonth(@PathVariable int year, @PathVariable int month){
		return ResponseEntity.ok(repository.findByStartDateYearAndStartDateMonthEqualsOrderByStartDateDayAsc(year, month));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events/y{year}/m{month}/d{day}")
	ResponseEntity<List<Event>> readEventsByYearAndMonthAndDay(@PathVariable int year, @PathVariable int month, @PathVariable int day){
		return ResponseEntity.ok(repository.findByStartDateYearAndStartDateMonthAndStartDateDayEquals(year, month, day));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/events/y{year}/y{year2}")
	ResponseEntity<List<Event>> searchEventsBetweenYears(@PathVariable int year, @PathVariable int year2){
		return ResponseEntity.ok(repository.findAllByStartDateYearIsBetweenOrderByStartDateYearAscStartDateMonthAscStartDateDayAsc(year, year2));
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/events")
	ResponseEntity<?> addEvent(@RequestBody @Valid Event newEvent) {
		Event currentEvent = repository.save(newEvent);
		return ResponseEntity.created(URI.create("/" + currentEvent)).body(currentEvent);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.PUT, value = "/events/{id}")
	ResponseEntity<?> setEvent(@PathVariable int id, @RequestBody @Valid Event eventSource) {
		if (!repository.existsById(id))
			return ResponseEntity.badRequest().build();
		repository.findById(id).ifPresent(event -> {
			try {
				event.setNullFields(eventSource);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			repository.save(event);
		});
		return ResponseEntity.ok(repository.findById(id));
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.PATCH, value = "/events/{id}")
	ResponseEntity<?> satchEvent(@PathVariable int id, @RequestBody @Valid Event eventSource) {
		if (!repository.existsById(id))
			return ResponseEntity.badRequest().build();
		repository.findById(id).ifPresent(event -> {
			try {
				event.setFieldsWithNotNull(eventSource);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
			repository.save(event);
		});
		return ResponseEntity.ok(repository.findById(id));
	}
}
