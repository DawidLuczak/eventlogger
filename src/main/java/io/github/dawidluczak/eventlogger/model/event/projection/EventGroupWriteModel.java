package io.github.dawidluczak.eventlogger.model.event.projection;


import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class EventGroupWriteModel {
	private String title;
	private Set<EventWriteModel> events;
	
	public EventGroup toEventGroup(){
		var result = new EventGroup();
		result.setTitle(title);
		result.setEventSet(
				events.stream()
						.map(EventWriteModel::toEvent)
						.collect(Collectors.toSet()));
		return result;
	}
}
