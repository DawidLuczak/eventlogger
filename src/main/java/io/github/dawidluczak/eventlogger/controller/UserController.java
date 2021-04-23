package io.github.dawidluczak.eventlogger.controller;


import io.github.dawidluczak.eventlogger.model.community.User;
import io.github.dawidluczak.eventlogger.model.community.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.awt.print.Pageable;
import java.net.URI;
import java.util.List;
import java.util.Optional;
//HATEOAS

@RestController
class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	private final UserRepository repository;

	UserController(final UserRepository repository){
		this.repository = repository;
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users", params = {"!sort","!page","!size"})
	ResponseEntity<List<User>> readAllUsers(){
		return ResponseEntity.ok(repository.findAll());
	}

	@RequestMapping(method = RequestMethod.GET, value = "/users")
	ResponseEntity<List<User>> readAllUsers(Pageable page){
		return ResponseEntity.ok(repository.findAll());
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/{id}")
	ResponseEntity<Optional<User>> readUserById(@PathVariable int id){
		if (!repository.existsById(id)){
			return ResponseEntity.badRequest().build();
		}
		return ResponseEntity.ok().body(repository.findById(id));
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/users/name={name}")
	ResponseEntity<Optional<User>> readUserByName(@PathVariable String name){
		if (!repository.existsByName(name))
			return ResponseEntity.badRequest().build();
		return ResponseEntity.ok().body(repository.findByName(name));
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.POST, value = "/users")
	ResponseEntity<?> addUser(@RequestBody @Valid User newUser){
		return ResponseEntity.created(URI.create("/id=" + repository.save(newUser))).body(newUser);
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.PUT, value = "/users/{id}")
	ResponseEntity<?> updateNotNullUser(@PathVariable int id, @RequestBody @Valid User toUpdate){
		if (repository.existsById(id))
			repository.findById(id).ifPresent(user -> {
				try {
					user.setNullFields(toUpdate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				repository.save(user);});
		return ResponseEntity.ok().build();
	}
	
	@Transactional
	@RequestMapping(method = RequestMethod.PATCH, value = "/users/{id}")
	ResponseEntity<?> updateUser(@PathVariable int id, @RequestBody @Valid User toUpdate){
		if (repository.existsById(id))
			repository.findById(id).ifPresent(user -> {
				try {
					user.setFieldsWithNotNull(toUpdate);
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
				repository.save(user);});
		return ResponseEntity.ok().build();
	}
}
