package io.github.dawidluczak.eventlogger.adapter;

import io.github.dawidluczak.eventlogger.model.Timetable;
import io.github.dawidluczak.eventlogger.model.TimetableRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimetableSQLRepository extends TimetableRepository, JpaRepository<Timetable, Integer> {


}
