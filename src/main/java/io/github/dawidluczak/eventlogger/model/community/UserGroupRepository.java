package io.github.dawidluczak.eventlogger.model.community;

import java.util.List;
import java.util.Optional;

public interface UserGroupRepository {
	List<UserGroup> findAll();
	
	Optional<UserGroup> findById(int id);
	
	UserGroup save(UserGroup entity);
}
