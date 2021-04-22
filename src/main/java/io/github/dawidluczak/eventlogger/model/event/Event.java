package io.github.dawidluczak.eventlogger.model.event;


import io.github.dawidluczak.eventlogger.model.calendar.date.Date;
import io.github.dawidluczak.eventlogger.model.community.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "events")
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Tittle must not be empty.")
	private String title;
	@Embedded
	private Date date;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_group_id")
	private EventGroup eventGroup;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	private boolean done;
	private String description;
	private LocalDateTime createdOn;
	
	public Event(String title){
		this.title = title;
	}
	
	public Event(int year, int month, int day){
		this.date = new Date(year, month, day);
	}
	
	public void updateFrom(Event source){
		this.title = source.title;
		this.date = source.date;
		this.eventGroup = source.eventGroup;
		this.user = source.user;
		this.done = source.done;
		this.description = source.description;
	}
}
