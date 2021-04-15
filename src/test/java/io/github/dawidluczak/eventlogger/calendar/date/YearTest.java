package io.github.dawidluczak.eventlogger.calendar.date;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class YearTest {
	static Year year;

	@BeforeAll
	static void yearInit(){
		year = new Year(2021);
	}

	@Test
	void getMonthFromYearsMonthList(){
		Year y1 = new Year(2022);
		Assertions.assertEquals("Pt", year.getMonths()[11].getDays()[30].getShortname());
		Assertions.assertEquals("Sb", y1.getMonths()[0].getDays()[0].getShortname());
	}
}