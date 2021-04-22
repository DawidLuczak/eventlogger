package io.github.dawidluczak.eventlogger.model.calendar;

public interface CalendarInterface {
    String[][] daysNames = {{"Poniedziałek", "Wtorek", "Środa", "Czwartek", "Piątek", "Sobota", "Niedziela"},
            {"Pn", "Wt", "Śr", "Cz", "Pt", "Sb", "Nd"}};
    String[] monthsNames = {"Styczeń", "Luty", "Marzec", "Kwiecień", "Maj", "Czerwiec",
            "Lipiec", "Sierpień", "Wrzesień", "Październik", "Listopad", "Grudzień"};
    int[] monthsSizes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static int getMonthSize(int year, int month){
        if (month == 1)
            if (year % 4 == 0)
                return monthsSizes[month] + 1;
        return monthsSizes[month];

    }

    static int countDayInWeakNumber(String year, String month, String day) throws NumberFormatException {
        int y, m, d;
        y = Integer.parseInt(year);
        m = Integer.parseInt(month);
        d = Integer.parseInt(day);
        return countDayInWeakNumber(y, m , d);
    }

    static int countDayInWeakNumber(int year, int month, int day){
        int firstDay = 2;
        
        if (month > 11){
            year += ((int)(month / 12));
            month = month % 12;
        } else if (month < 0) {
            year -= (1 + ((int)((month) / 12)));
            month = 12 + ((month) % 12);
        }
        firstDay += changeMonthOnDays(year, month);
    
        int dif = Math.abs(2020 - year);
    
        if (year < 2020) {
            firstDay -= ((((int) (dif / 4)) * 5) + (dif % 4));
        } else if (year > 2020){
            firstDay += ((((int)(dif / 4)) * 5) + (dif % 4)) + 1;
            if (dif % 4 == 0)
                firstDay--;
        }

        if (-firstDay > (day - 1))
            return 7 + ((firstDay + (day-1)) % 7);
        else
            return (firstDay + (day-1)) % 7;
    }

    static int changeMonthOnDays(int year, int month){
        int days = 0;
        if (month > 0)
            for (int i = 0; i < month; i++)
                days += CalendarInterface.getMonthSize(year, i);
        else if (month < 0)
            for (int i = 12 + month; i < 12; i++)
                days += CalendarInterface.getMonthSize(year, i);
        return days;
    }

}
