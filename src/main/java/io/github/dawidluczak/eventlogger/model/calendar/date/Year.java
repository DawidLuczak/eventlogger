package io.github.dawidluczak.eventlogger.model.calendar.date;

import io.github.dawidluczak.eventlogger.model.calendar.CalendarInterface;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;


@Getter
@AllArgsConstructor
@EqualsAndHashCode
public class Year {
    private final int number;
    private final Month[] months;

    Year(int number){
        this.number = number;
        this.months = new Month[12];
        createMonths();
    }

    private void createMonths(){
        for (int i = 0; i < months.length; i++){
            months[i] = new Month(i, CalendarInterface.monthsNames[i], CalendarInterface.getMonthSize(number, i), CalendarInterface.countDayInWeakNumber(number, i, 0));
        }
    }


}
