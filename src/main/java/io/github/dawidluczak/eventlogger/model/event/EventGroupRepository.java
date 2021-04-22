package io.github.dawidluczak.eventlogger.model.event;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface EventGroupRepository {
	List<EventGroup> findAll();
	
	Optional<EventGroup> findById(Integer id);
	
	EventGroup save(EventGroup entity);
	
	boolean existsById(int id);
}
