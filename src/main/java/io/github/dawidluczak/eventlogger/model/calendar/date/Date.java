package io.github.dawidluczak.eventlogger.model.calendar.date;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Date {
	@Column
	private int year, month, day;
	
	
}
