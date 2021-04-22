package io.github.dawidluczak.eventlogger.model.calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalendarInterfaceTest {
    
    @Test
    void implementationTest(){
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(2015, 11, 31));
        Assertions.assertEquals(4, CalendarInterface.countDayInWeakNumber(2016, 1, 1));
        Assertions.assertEquals(5, CalendarInterface.countDayInWeakNumber(2016, 11, 31));
        Assertions.assertEquals(6, CalendarInterface.countDayInWeakNumber(2017, 1, 1));

        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2019, 11, 31));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2020, 1, 1));
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(2020, 11, 31));
        Assertions.assertEquals(4, CalendarInterface.countDayInWeakNumber(2021, 1, 1));

        Assertions.assertEquals(6, CalendarInterface.countDayInWeakNumber(2023, 11, 31));
        Assertions.assertEquals(0, CalendarInterface.countDayInWeakNumber(2024, 1, 1));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2024, 11, 31));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2025, 1, 1));

        Assertions.assertEquals(4, CalendarInterface.countDayInWeakNumber(0,1,1));
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(-1, 11, 31));
    }

    @Test
    void variationTest(){
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2022, -9, 13));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2022, -8, -17));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2021, 0, 103));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2022, 0, -262));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2021, 3, 13));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2022, 4, -18));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2020, 14, 44));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2020, 0, 469));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(-5, -10, 739930));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(0, 0, 738169));

    }

    @Test
    void changeMonthOnDays() {
        Assertions.assertEquals(212, CalendarInterface.changeMonthOnDays(2010, 7));
        Assertions.assertEquals(31, CalendarInterface.changeMonthOnDays(2019, 1));
        Assertions.assertEquals(335, CalendarInterface.changeMonthOnDays(2020, 11));
        Assertions.assertEquals(90, CalendarInterface.changeMonthOnDays(2021, 3));
        Assertions.assertEquals(304, CalendarInterface.changeMonthOnDays(2030, 10));

    }

    @Test
    void countDayInWeakNumber_StringMethod_Test(){
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber("2022", "-9", "14"));
        Assertions.assertThrows(NumberFormatException.class,
            ()-> CalendarInterface.countDayInWeakNumber("das", "12as", "czx"));
    }
}