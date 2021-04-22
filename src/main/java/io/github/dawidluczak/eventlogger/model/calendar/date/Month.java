package io.github.dawidluczak.eventlogger.model.calendar.date;


import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@EqualsAndHashCode
@AllArgsConstructor
class Month {
    private final int number;
    private final String name;
    private final Day[] days;

    Month(int number, String name, int size, int firstDayOfMonth){
        this.number = number;
        this.name = name;
        this.days = new Day[size];
        createDays(firstDayOfMonth);
    }

    private void createDays(int firstDayOfMonth){
        for (int i = 0; i < days.length; i++){
            days[i] = new Day(i + 1, firstDayOfMonth);
            firstDayOfMonth++;
            if (firstDayOfMonth % 7 == 0) {
                firstDayOfMonth = 0;
            }
        }
    }



}
