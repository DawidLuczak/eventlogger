package io.github.dawidluczak.eventlogger.adapter;

import io.github.dawidluczak.eventlogger.model.community.UserGroup;
import io.github.dawidluczak.eventlogger.model.community.UserGroupRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserGroupSQLRepository extends UserGroupRepository, JpaRepository<UserGroup, Integer> {
	
	@Override
	@Query("from UserGroup ug join fetch ug.userSet")
	List<UserGroup> findAll();
}
