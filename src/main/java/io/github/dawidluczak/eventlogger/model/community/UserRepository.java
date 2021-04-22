package io.github.dawidluczak.eventlogger.model.community;

import org.springframework.data.domain.*;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
	List<User> findAll();
	
	Optional<User> findById(int id);
	
	Page<User> findAll(Pageable page);
	
	Optional<User> findByName(String name);
	
	boolean existsById(int id);
	
	boolean existsByName(String name);
	
	User save(User entity);
	
}
