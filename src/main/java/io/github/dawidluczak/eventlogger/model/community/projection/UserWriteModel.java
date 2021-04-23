package io.github.dawidluczak.eventlogger.model.community.projection;

import io.github.dawidluczak.eventlogger.model.community.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserWriteModel {
	private String name, description, phoneNumber, email;
	
	public User toUser(){
		return new User(name, description, phoneNumber, email);
	}
}
