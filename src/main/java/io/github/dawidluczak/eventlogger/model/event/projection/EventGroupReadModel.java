package io.github.dawidluczak.eventlogger.model.event.projection;

import io.github.dawidluczak.eventlogger.model.calendar.date.Date;
import io.github.dawidluczak.eventlogger.model.community.User;
import io.github.dawidluczak.eventlogger.model.event.Event;
import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class EventGroupReadModel {
	private String title;
	private Date startingDate, endingDate;
	private User user;
	private Set<EventReadModel> events;
	
	public EventGroupReadModel(EventGroup source){
		this.title = source.getTitle();
		this.user = source.getUser();
		source.getEventSet().stream()
				.map(Event::getStartDate)
				.min(Date::compareTo)
				.ifPresent(date -> startingDate = date);
		source.getEventSet().stream()
				.map(Event::getEndDate)
				.max(Date::compareTo)
				.ifPresent(date -> endingDate = date);
		this.events = source.getEventSet().stream()
				.map(EventReadModel::new)
				.collect(Collectors.toSet());
	}
	
	
}
