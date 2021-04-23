package io.github.dawidluczak.eventlogger.model.event.projection;

import io.github.dawidluczak.eventlogger.model.calendar.date.Date;
import io.github.dawidluczak.eventlogger.model.community.User;
import io.github.dawidluczak.eventlogger.model.event.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventReadModel {
	private String title;
	private Date date;
	private User user;
	
	EventReadModel(Event source) {
		this.title = source.getTitle();
		this.date = source.getStartDate();
		this.user = source.getUser();
	}
}
