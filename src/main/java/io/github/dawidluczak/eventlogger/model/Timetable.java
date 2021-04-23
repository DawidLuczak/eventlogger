package io.github.dawidluczak.eventlogger.model;

import io.github.dawidluczak.eventlogger.model.community.UserGroup;
import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;
import java.util.stream.Collectors;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "timetable")
public class Timetable {
	
	@Id @Getter
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Integer id;
	@NotBlank @Getter
	private String title;
	@Getter
	private String description;
	@OneToMany(mappedBy = "timetable")
	private Set<EventGroup> eventGroups;
	@OneToOne(mappedBy = "timetable")
	private UserGroup userGroup;
	
	public Timetable(String title) {
		this.title = title;
		}
	
	
	public Timetable(String title, Set<EventGroup> eventGroups) {
		this.title = title;
		this.eventGroups = eventGroups;
		this.userGroup = new UserGroup(this, eventGroups.stream().map(EventGroup::getUser).collect(Collectors.toSet()));
	}
	
	public void setNullFields(Timetable source) throws IllegalAccessException {
		for (int i = 0; i < getClass().getDeclaredFields().length; i++){
			if (getClass().getDeclaredFields()[i].get(this) == null){
				getClass().getDeclaredFields()[i].set(this, getClass().getDeclaredFields()[i].get(source));
			}
		}
	}
	
	public void setFieldsWithNotNull(Timetable source) throws IllegalAccessException {
		for (int i = 0; i < getClass().getDeclaredFields().length; i++){
			if (getClass().getDeclaredFields()[i].get(source) != null){
				getClass().getDeclaredFields()[i].set(this, getClass().getDeclaredFields()[i].get(source));
			}
		}
	}
	
}
