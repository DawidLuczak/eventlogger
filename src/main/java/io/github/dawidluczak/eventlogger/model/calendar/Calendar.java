package io.github.dawidluczak.eventlogger.model.calendar;

import io.github.dawidluczak.eventlogger.model.calendar.date.Year;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
public class Calendar {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private final String name;
	private List<Year> yearsList;

	Calendar(String name){
		this.name = name;
		this.yearsList = new ArrayList<>();
	}

}
