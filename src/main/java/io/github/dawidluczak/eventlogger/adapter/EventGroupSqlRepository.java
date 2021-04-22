package io.github.dawidluczak.eventlogger.adapter;

import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import io.github.dawidluczak.eventlogger.model.event.EventGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


interface EventGroupSqlRepository extends EventGroupRepository, JpaRepository<EventGroup, Integer> {
	
	@Override
	@Query("from EventGroup eg join fetch eg.eventSet")
	List<EventGroup> findAll();
	
}
