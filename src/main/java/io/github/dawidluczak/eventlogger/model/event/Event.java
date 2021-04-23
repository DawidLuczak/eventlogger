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
	@Column
	private Date startDate;
	@Embedded
	@Column
	private Date endDate;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "event_group_id")
	private EventGroup eventGroup;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	private String description;
	private boolean done;
	private LocalDateTime createdOn;
	
	public Event(String title){
		this.title = title;
	}
	
	public Event(String title, Date startDate, User user, String description){
		this.title = title;
	}
	
	public Event(int year, int month, int day){
		this.startDate = new Date(year, month, day);
	}
	
	public void updateFrom(Event source){
		this.title = source.title;
		this.startDate = source.startDate;
		this.eventGroup = source.eventGroup;
		this.user = source.user;
		this.done = source.done;
		this.description = source.description;
	}
	
	boolean getDone(){
		return done;
	}
	
	public void setNullFields(Event source) throws IllegalAccessException {
		for (int i = 0; i < getClass().getDeclaredFields().length; i++){
			if (getClass().getDeclaredFields()[i].get(this) == null){
				getClass().getDeclaredFields()[i].set(this, getClass().getDeclaredFields()[i].get(source));
			}
		}
	}
	
	public void setFieldsWithNotNull(Event source) throws IllegalAccessException {
		for (int i = 0; i < getClass().getDeclaredFields().length; i++){
			if (getClass().getDeclaredFields()[i].get(source) != null){
				getClass().getDeclaredFields()[i].set(this, getClass().getDeclaredFields()[i].get(source));
			}
		}
	}
}
