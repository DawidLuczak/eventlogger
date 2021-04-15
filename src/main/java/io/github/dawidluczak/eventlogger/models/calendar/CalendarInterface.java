package io.github.dawidluczak.eventlogger.models.calendar;

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
        if (month > 11){
            year += ((int)(month/12));
            month %= 12;
        } else if (month < 0) {
            year -= (1 + ((int)(month/12)));
            month = 12 + (month % 12);
        }

        int firstDay = 2;
        int dif = Math.abs(2020 - year);

        if (month > 0)
            firstDay += changeMonthOnDays(year, month);

        if (year < 2020) {
            firstDay -= ((((int) (dif / 4)) * 5) + (dif % 4));
        } else if (year > 2020){
            firstDay += ((((int)(dif / 4)) * 5) + (dif % 4)) + 1;
            if (dif % 4 == 0)
                firstDay--;
        }

        if (-firstDay > day)
            return 7 + ((firstDay + day) % 7);
        else
            return (firstDay + day) % 7;
    }

    static int changeMonthOnDays(int year, int month){
        int days = 0, i, j, y;

        if (month < 0)
            y = -1;
        else
            y = 1;

        while (month > 11){
            if (year % 4 == 0)
                days += 366;
            else
                days += 365;
            month -= 12;
            year += y;
        }

        if (month < 0) {
            i = 12 + month;
            j = 12;
        } else {
            i = 0;
            j = month;
        }

        if (year % 4 == 0 && i < 1 && j > 1)
            days++;

        for (; i < j; i++)
            days += monthsSizes[i];

        return days;
    }

}
