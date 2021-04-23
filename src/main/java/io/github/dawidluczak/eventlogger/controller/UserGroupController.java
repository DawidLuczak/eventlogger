package io.github.dawidluczak.eventlogger.controller;

import io.github.dawidluczak.eventlogger.model.community.UserGroup;
import io.github.dawidluczak.eventlogger.model.community.UserGroupRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
public class UserGroupController {
	private final UserGroupRepository userGroupRepository;
	
	UserGroupController(final UserGroupRepository userGroupRepository){
		this.userGroupRepository = userGroupRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user_groups")
	ResponseEntity<List<UserGroup>> readAllUserGroups(){
		return ResponseEntity.ok(userGroupRepository.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/user_groups/{id}")
	ResponseEntity<Optional<UserGroup>> readUserGroupById(@PathVariable int id){
		return ResponseEntity.ok(userGroupRepository.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/user_groups")
	ResponseEntity<UserGroup> createUserGroup(@RequestBody @Valid UserGroup newUserGroup){
		UserGroup currentEventGroup = userGroupRepository.save(newUserGroup);
		return ResponseEntity.created(URI.create("/" + currentEventGroup)).body(currentEventGroup);
	}
	
	
}
