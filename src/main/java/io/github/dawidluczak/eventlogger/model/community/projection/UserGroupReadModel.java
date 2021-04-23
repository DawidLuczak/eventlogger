package io.github.dawidluczak.eventlogger.model.community.projection;

import io.github.dawidluczak.eventlogger.model.community.UserGroup;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGroupReadModel {
	private String title, description;
	
	public UserGroupReadModel(UserGroup source) {
		this.title = source.getTitle();
		this.description = source.getDescription();
	}
}
