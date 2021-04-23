package io.github.dawidluczak.eventlogger.model.community.projection;

import io.github.dawidluczak.eventlogger.model.community.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReadModel {
	private String name;
	
	UserReadModel(User source){
		this.name = source.getName();
	}
}
