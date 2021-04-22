package io.github.dawidluczak.eventlogger.adapter;

import io.github.dawidluczak.eventlogger.model.event.Event;
import io.github.dawidluczak.eventlogger.model.event.EventRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EventSqlRepository extends EventRepository, JpaRepository<Event, Integer> {
	

	
}
