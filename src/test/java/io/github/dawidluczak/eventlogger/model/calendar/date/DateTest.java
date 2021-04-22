package io.github.dawidluczak.eventlogger.model.calendar.date;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class DateTest {

	@Test
	void dateCompareToTest(){
		Date d1 = new Date(2021, 4, 22);
		Date d2 = new Date(2021, 5, 22);
		Date d3 = new Date(2021, 4, 23);
		Date d4 = new Date(2022, 4, 22);
		Date d5 = new Date(2022, 2, 22);
		Date d6 = new Date(2020, 4, 22);
		
		Date[] dates = new Date[]{d1,d2,d3,d4,d5,d6};
		Arrays.sort(dates, Date::compareTo);
		
		Assertions.assertEquals(d6, dates[0]);
		Assertions.assertEquals(d1, dates[1]);
		Assertions.assertEquals(d3, dates[2]);
		Assertions.assertEquals(d2, dates[3]);
		Assertions.assertEquals(d5, dates[4]);
		Assertions.assertEquals(d4, dates[5]);
		
		System.out.println(Arrays.toString(dates));
	}
	
}
