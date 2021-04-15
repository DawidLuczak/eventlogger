package io.github.dawidluczak.eventlogger.calendar.date;

import io.github.dawidluczak.eventlogger.calendar.CalendarInterface;
import lombok.Getter;

@Getter
public class Day {
    private final int number, dayInWeakNumber;
    private final String name, shortname;

    Day(int number, int dayInWeakNumber){
        this.number = number;
        this.dayInWeakNumber = dayInWeakNumber;
        this.name = CalendarInterface.daysNames[0][dayInWeakNumber];
        this.shortname = CalendarInterface.daysNames[1][dayInWeakNumber];
    }
}
