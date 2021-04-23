package io.github.dawidluczak.eventlogger.model.projection;

import io.github.dawidluczak.eventlogger.model.Timetable;
import io.github.dawidluczak.eventlogger.model.community.UserGroup;
import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class TimetableWriteModel {
	private String title;
	private UserGroup userGroup;
	private Set<EventGroup> eventGroup;
	
	public Timetable toTimetable(){
		return new Timetable(title, eventGroup);
	}
}
