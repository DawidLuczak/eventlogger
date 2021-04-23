package io.github.dawidluczak.eventlogger.model.projection;

import io.github.dawidluczak.eventlogger.model.Timetable;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TimetableReadModel {
	private String title;
	
	TimetableReadModel(Timetable source){
		this.title = source.getTitle();
	}
}
