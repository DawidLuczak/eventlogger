package io.github.dawidluczak.eventlogger.controllers;


import io.github.dawidluczak.eventlogger.models.community.UsersRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.awt.print.Pageable;

//HATEOAS

@RepositoryRestController
class UsersController {
	public static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	private final UsersRepository usersRepository;

	UsersController(final UsersRepository repository){
		usersRepository = repository;
	}

	@GetMapping( value = "/users", params = {"!sort","!page","!size"})
	ResponseEntity<?> readAllUsers(){
		logger.warn("Watch out user.");
		return ResponseEntity.ok(usersRepository.findAll());
	}

	@GetMapping( value = "/users")
	ResponseEntity<?> readAllUsers(Pageable pageable){
		logger.info("Hello users.");
		return ResponseEntity.ok(usersRepository.findAll());
	}

}
