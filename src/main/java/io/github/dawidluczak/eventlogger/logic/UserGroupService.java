package io.github.dawidluczak.eventlogger.logic;

import io.github.dawidluczak.eventlogger.model.community.UserGroup;
import io.github.dawidluczak.eventlogger.model.community.UserGroupRepository;
import io.github.dawidluczak.eventlogger.model.community.UserRepository;
import io.github.dawidluczak.eventlogger.model.community.projection.UserGroupReadModel;
import io.github.dawidluczak.eventlogger.model.community.projection.UserGroupWriteModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserGroupService {
	private final UserGroupRepository repository;
	private final UserRepository userRepository;
	
	UserGroupService(final UserGroupRepository repository, final UserRepository userRepository){
		this.repository = repository;
		this.userRepository = userRepository;
	}

	public List<UserGroupReadModel> readAll(){
		return repository.findAll().stream()
							 .map(UserGroupReadModel::new)
							 .collect(Collectors.toList());
	}
	
	public UserGroup save(final UserGroup toSave){
		return repository.save(toSave);
	}
	
	public UserGroupReadModel createGroup(final UserGroupWriteModel source) {
		UserGroup result = repository.save(source.toUserGroup());
		return new UserGroupReadModel(result);
	}
	
	

}
