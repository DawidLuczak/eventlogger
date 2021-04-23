package io.github.dawidluczak.eventlogger.logic;

import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import io.github.dawidluczak.eventlogger.model.event.EventGroupRepository;
import io.github.dawidluczak.eventlogger.model.event.EventRepository;
import io.github.dawidluczak.eventlogger.model.event.projection.EventGroupReadModel;
import io.github.dawidluczak.eventlogger.model.event.projection.EventGroupWriteModel;
import org.springframework.stereotype.Service;
import org.springframework.web.context.annotation.RequestScope;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequestScope
public class EventGroupService {
	private final EventGroupRepository repository;
	private final EventRepository eventRepository;
	
	EventGroupService(final EventGroupRepository repository, final EventRepository eventRepository) {
		this.repository = repository;
		this.eventRepository = eventRepository;
	}
	
	public EventGroupReadModel createGroup(EventGroupWriteModel source) {
		EventGroup result = repository.save(source.toEventGroup());
		return new EventGroupReadModel(result);
	}
	
	public List<EventGroupReadModel> readAll() {
		return repository.findAll().stream()
							 .map(EventGroupReadModel::new)
							 .collect(Collectors.toList());
	}
	
	public void toggleGroup(int groupId){
		if (eventRepository.existsByDoneIsFalseAndEventGroupId(groupId)){
			throw new IllegalStateException("Undone events in group.");
		}
		EventGroup result = repository.findById(groupId)
														.orElseThrow(() -> new IllegalArgumentException("Event group with given id not found"));
		result.setDone(!result.isDone());
	}
}
