package io.github.dawidluczak.eventlogger.adapter;

import io.github.dawidluczak.eventlogger.model.event.Event;
import io.github.dawidluczak.eventlogger.model.event.EventRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventSQLRepository extends EventRepository, JpaRepository<Event, Integer> {
	

}
