package io.github.dawidluczak.eventlogger.controller;

import io.github.dawidluczak.eventlogger.model.Timetable;
import io.github.dawidluczak.eventlogger.model.TimetableRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
public class TimetableController {
	private final TimetableRepository repository;
	
	public TimetableController(TimetableRepository repository) {
		this.repository = repository;
	}
	
	
	@GetMapping("/timetables")
	public ResponseEntity<List<Timetable>> readAll(){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@GetMapping("/timetables/{id}")
	public ResponseEntity<Optional<Timetable>> readById(@PathVariable int id){
		if (repository.existsById(id))
			return ResponseEntity.notFound().build();
		return ResponseEntity.ok(repository.findById(id));
	}
	
	
	
	@Transactional
	@RequestMapping(method = RequestMethod.PUT, value = "/timetables/{id}")
	ResponseEntity<?> putTimetable(@PathVariable int id, @RequestBody @Valid Timetable toUpdate) {
		if (repository.existsById(id))
			return ResponseEntity.badRequest().build();
		repository.findById(id).ifPresent(timetable -> {
			try {
				timetable.setNullFields(toUpdate);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		return ResponseEntity.ok(repository.findById(id));
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.PATCH, value = "/timetables/{id}")
	ResponseEntity<?> UpdateTimetable(@PathVariable int id, @RequestBody @Valid Timetable toUpdate) {
		if (repository.existsById(id))
			return ResponseEntity.badRequest().build();
		repository.findById(id).ifPresent(timetable -> {
			try {
				timetable.setFieldsWithNotNull(toUpdate);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		});
		return ResponseEntity.ok(repository.findById(id));
	}
}
