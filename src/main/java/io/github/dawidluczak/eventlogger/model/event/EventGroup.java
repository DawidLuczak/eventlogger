package io.github.dawidluczak.eventlogger.model.event;


import io.github.dawidluczak.eventlogger.model.Timetable;
import io.github.dawidluczak.eventlogger.model.community.User;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "EVENT_GROUPS")
public class EventGroup {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotNull
	private String title;
	private boolean done;
	private String description;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventGroup")
	private Set<Event> eventSet;
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	@ManyToOne
	@JoinColumn(name = "timetable_id")
	private Timetable timetable;
	
	public EventGroup(Timetable timetable, User user){
		this.title = timetable.getTitle();
		this.user = user;
	}
	
	public void updateFrom(EventGroup source){
		this.title = source.title;
		this.description = source.description;
		this.eventSet = source.eventSet;
		this.user = source.user;
		this.done = source.done;
	}
	
	public void setNullFields(EventGroup source) throws IllegalAccessException {
		for (int i = 0; i < getClass().getDeclaredFields().length; i++){
			if (getClass().getDeclaredFields()[i].get(this) == null){
				getClass().getDeclaredFields()[i].set(this, getClass().getDeclaredFields()[i].get(source));
			}
		}
	}
	
	public void setFieldsWithNotNull(EventGroup source) throws IllegalAccessException {
		for (int i = 0; i < getClass().getDeclaredFields().length; i++){
			if (getClass().getDeclaredFields()[i].get(source) != null){
				getClass().getDeclaredFields()[i].set(this, getClass().getDeclaredFields()[i].get(source));
			}
		}
	}
	
}