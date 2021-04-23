package io.github.dawidluczak.eventlogger.model.calendar.date;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class Date implements Comparable<Date> {

	@Column(insertable = false, updatable = false)
	private int year, month, day;
	
	@Override
	public int compareTo(Date o) {
		if (this.year < o.year){
			return -1;
		} else if (this.year > o.year){
			return 1;
		} else {
			if (this.month < o.month){
				return -1;
			} else if (this.month > o.month) {
				return 1;
			} else {
				return Integer.compare(this.day, o.day);
			}
		}
	}
	
	@Override
	public String toString() {
		return year + "-" + month + "-" + day;
	}
}
