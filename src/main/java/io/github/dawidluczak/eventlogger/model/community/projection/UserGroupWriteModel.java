package io.github.dawidluczak.eventlogger.model.community.projection;

import io.github.dawidluczak.eventlogger.model.community.UserGroup;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserGroupWriteModel {
	private String title;
	
	
	public UserGroup toUserGroup(){
		return new UserGroup(title);
	}
}
