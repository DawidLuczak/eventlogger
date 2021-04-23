package io.github.dawidluczak.eventlogger.model.community;

import io.github.dawidluczak.eventlogger.model.Timetable;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "USER_GROUPS")
public class UserGroup {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@NotBlank(message = "Group title must not be empty")
	private String title;
	private String description;
	@OneToMany(mappedBy = "userGroup")
	private Set<User> userSet;
	@OneToOne
	@JoinColumn(name = "timetable_id")
	private Timetable timetable;
	
	public UserGroup(String title){
		this.title = title;
	}
	
	public UserGroup(Timetable timetable, Set<User> users){
		this.title = timetable.getTitle();
		this.description = timetable.getDescription();
		this.userSet = users;
		this.timetable = timetable;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setNullFields(User source) throws IllegalAccessException {
		for (int i = 0; i < getClass().getDeclaredFields().length; i++){
			if (getClass().getDeclaredFields()[i].get(this) == null){
				getClass().getDeclaredFields()[i].set(this, getClass().getDeclaredFields()[i].get(source));
			}
		}
	}
	
	public void setFieldsWithNotNull(User source) throws IllegalAccessException {
		for (int i = 0; i < getClass().getDeclaredFields().length; i++){
			if (getClass().getDeclaredFields()[i].get(source) != null){
				getClass().getDeclaredFields()[i].set(this, getClass().getDeclaredFields()[i].get(source));
			}
		}
	}
}
