package io.github.dawidluczak.eventlogger.model.event;


import io.github.dawidluczak.eventlogger.model.community.User;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter(value = AccessLevel.PRIVATE)
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "eventGroup")
	private Set<Event> eventSet;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id")
	private User user;
	
	private boolean done;
	private String description;
	
	
	
	public void updateFrom(EventGroup source){
		this.title = source.title;
		this.description = source.description;
		this.eventSet = source.eventSet;
		this.user = source.user;
		this.done = source.done;
	}
	
}