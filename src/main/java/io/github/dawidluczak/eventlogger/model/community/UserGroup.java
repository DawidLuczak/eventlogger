package io.github.dawidluczak.eventlogger.model.community;

import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

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
	
	public UserGroup(String title){
		this.title = title;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public Integer getId() {
		return id;
	}
}
