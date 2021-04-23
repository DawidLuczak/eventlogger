package io.github.dawidluczak.eventlogger.model.community;

import io.github.dawidluczak.eventlogger.model.event.Event;
import io.github.dawidluczak.eventlogger.model.event.EventGroup;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Setter
@Getter
@EqualsAndHashCode
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotBlank(message = "Name must not be empty.")
    private String name;
    private String description;
    private String phoneNumber;
    private String email;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_group_id")
    private UserGroup userGroup;
    @OneToMany(mappedBy = "user")
    private Set<EventGroup> eventGroup;
    @OneToMany(mappedBy = "user")
    private Set<Event> eventSet;
    
    public User(String name) {
        this.name = name;
    }
    
    public User(String name, String description, String phoneNumber, String email) {
        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    public void updateFrom(User source) {
        this.name = source.name;
        this.description = source.description;
        this.phoneNumber = source.phoneNumber;
        this.email = source.email;
        this.userGroup = source.userGroup;
        this.eventGroup = source.eventGroup;
        this.eventSet = source.eventSet;
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
    
    @Override
    public String toString() {
        return "" + id;
    }
}
