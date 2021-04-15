package io.github.dawidluczak.eventlogger.models.community;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface UsersRepository extends JpaRepository<User, Long> {

	@Override
	void deleteById(Long aLong);

	@Override
	void delete(User user);
}
