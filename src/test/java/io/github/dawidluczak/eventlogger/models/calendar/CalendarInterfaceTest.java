package io.github.dawidluczak.eventlogger.models.calendar;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CalendarInterfaceTest {

@Test
    void countDayInWeakNumberTest() {
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(2008, 2, 12));
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(2008, 0,72));

        Assertions.assertEquals(6, CalendarInterface.countDayInWeakNumber(2019, 1, 2));
        Assertions.assertEquals(6, CalendarInterface.countDayInWeakNumber(2019, 0, 33));

        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(2020, 0, 358));
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(2020, 11, 23));

        Assertions.assertEquals(5, CalendarInterface.countDayInWeakNumber(2030, 0, 333));
        Assertions.assertEquals(5, CalendarInterface.countDayInWeakNumber(2030, 10, 29));

        Assertions.assertEquals(5, CalendarInterface.countDayInWeakNumber(2029,22, 29));
        Assertions.assertEquals(5, CalendarInterface.countDayInWeakNumber(2031, -2, 29));
        Assertions.assertEquals(5, CalendarInterface.countDayInWeakNumber(2031, 11, -366));
        Assertions.assertEquals(5, CalendarInterface.countDayInWeakNumber(2033, -12, -365));
        Assertions.assertEquals(0, CalendarInterface.countDayInWeakNumber(2021, -1, -1));
    }

    @Test
    void implementationTest(){
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(2015, 11, 30));
        Assertions.assertEquals(4, CalendarInterface.countDayInWeakNumber(2016, 0, 0));
        Assertions.assertEquals(5, CalendarInterface.countDayInWeakNumber(2016, 11, 30));
        Assertions.assertEquals(6, CalendarInterface.countDayInWeakNumber(2017, 0, 0));

        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2019, 11, 30));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2020, 0, 0));
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(2020, 11, 30));
        Assertions.assertEquals(4, CalendarInterface.countDayInWeakNumber(2021, 0, 0));

        Assertions.assertEquals(6, CalendarInterface.countDayInWeakNumber(2023, 11, 30));
        Assertions.assertEquals(0, CalendarInterface.countDayInWeakNumber(2024, 0, 0));
        Assertions.assertEquals(1, CalendarInterface.countDayInWeakNumber(2024, 11, 30));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2025, 0, 0));

        Assertions.assertEquals(4, CalendarInterface.countDayInWeakNumber(0,0,0));
        Assertions.assertEquals(3, CalendarInterface.countDayInWeakNumber(-1, 11, 30));
    }

    @Test
    void variationTest(){
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2022, -9, 13));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2022, -8, -17));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2021, 0, 103));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2022, 0, -262));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2021, 3, 13));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2022, 4, -18));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2020, 14, 44));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(2020, 0, 469));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(-5, -10, 739930));
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber(0, 0, 738169));

    }

    @Test
    void changeMonthOnDays() {
        Assertions.assertEquals(212, CalendarInterface.changeMonthOnDays(2010, 7));
        Assertions.assertEquals(31, CalendarInterface.changeMonthOnDays(2019, 1));
        Assertions.assertEquals(335, CalendarInterface.changeMonthOnDays(2020, 11));
        Assertions.assertEquals(90, CalendarInterface.changeMonthOnDays(2021, 3));
        Assertions.assertEquals(304, CalendarInterface.changeMonthOnDays(2030, 10));
        Assertions.assertEquals(396, CalendarInterface.changeMonthOnDays(2031, 13));
        Assertions.assertEquals(762, CalendarInterface.changeMonthOnDays(2031, 25));
    }

    @Test
    void countDayInWeakNumber_StringMethod_Test(){
        Assertions.assertEquals(2, CalendarInterface.countDayInWeakNumber("2022", "-9", "13"));
        Assertions.assertThrows(NumberFormatException.class,
            ()-> CalendarInterface.countDayInWeakNumber("das", "12as", "czx"));
    }
}