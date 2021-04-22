package io.github.dawidluczak.eventlogger.controller;

import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import io.github.dawidluczak.eventlogger.model.event.EventGroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class EventGroupController {
	
	private final EventGroupRepository eventGroupRepository;
	
	EventGroupController(final EventGroupRepository eventGroupRepository){
		this.eventGroupRepository = eventGroupRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/event_groups")
	ResponseEntity<List<EventGroup>> readAllEventGroups(){
		return ResponseEntity.ok(eventGroupRepository.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/event_groups/{id}")
	ResponseEntity<Optional<EventGroup>> readEventGroupById(@PathVariable int id){
		return ResponseEntity.ok(eventGroupRepository.findById(id));
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/event_groups")
	ResponseEntity<EventGroup> createEventGroup(@RequestBody @Valid EventGroup newEventGroup){
		eventGroupRepository.save(newEventGroup);
		return ResponseEntity.created(URI.create("/" + newEventGroup)).body(newEventGroup);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.PATCH, value = "/event_groups/{id}")
	ResponseEntity<EventGroup> updateEventGroup(@PathVariable int id, @RequestBody @Valid EventGroup toUpdate){
		if (!eventGroupRepository.existsById(id))
			return ResponseEntity.badRequest().build();
		eventGroupRepository.findById(id).ifPresent(eventGroup -> eventGroup.updateFrom(toUpdate));
		return ResponseEntity.ok(eventGroupRepository.findById(id).get());
	}
}
