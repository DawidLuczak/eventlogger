package io.github.dawidluczak.eventlogger.adapter;

import io.github.dawidluczak.eventlogger.model.community.User;
import io.github.dawidluczak.eventlogger.model.community.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserSqlRepository extends UserRepository, JpaRepository<User, Integer> {


}
