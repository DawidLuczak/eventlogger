package io.github.dawidluczak.eventlogger.model.event.projection;

import io.github.dawidluczak.eventlogger.model.calendar.date.Date;
import io.github.dawidluczak.eventlogger.model.community.User;
import io.github.dawidluczak.eventlogger.model.event.Event;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventWriteModel {
	private Date date;
	private String title, description;
	private User user;
	
	public Event toEvent(){
		return new Event(title, date, user, description);
	}
}
