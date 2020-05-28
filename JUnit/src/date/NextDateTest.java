package date;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

class NextDateTest {
	@Test
	final void equivalenceClassDivision() {
		List<String> actuals = Arrays.asList(
				NextDate.nextDay(2000, 6, 14),
				NextDate.nextDay(1811, 6, 14),
				NextDate.nextDay(2013, 6, 14),
				NextDate.nextDay(2000, 0, 14),
				NextDate.nextDay(2000, 13, 14),
				NextDate.nextDay(2000, 6, 0),
				NextDate.nextDay(2000, 6, 32));
		List<String> expecteds = Arrays.asList(
				"2000.6.15",
				"年错误",
				"年错误",
				"月错误",
				"月错误",
				"日错误",
				"日错误");
		Iterator<String> ita = actuals.iterator();
		Iterator<String> ite = expecteds.iterator();
		
		while (ita.hasNext() && ite.hasNext()) {
			assertEquals(ita.next(), ite.next());
		}
	}
	@Test
	final void boundaryValueDivision() {
		List<String> actuals = Arrays.asList(
				NextDate.nextDay(1811, 6, 14),
				NextDate.nextDay(1812, 6, 14),
				NextDate.nextDay(1813, 6, 14),
				NextDate.nextDay(2011, 6, 14),
				NextDate.nextDay(2012, 6, 14),
				NextDate.nextDay(2013, 6, 14),
				NextDate.nextDay(2000, 0, 14),
				NextDate.nextDay(2000, 1, 14),
				NextDate.nextDay(2000, 2, 14),
				NextDate.nextDay(2000, 11, 14),
				NextDate.nextDay(2000, 12, 14),
				NextDate.nextDay(2000, 13, 14),
				NextDate.nextDay(2000, 6, 0),
				NextDate.nextDay(2000, 6, 1),
				NextDate.nextDay(2000, 6, 2),
				NextDate.nextDay(2000, 6, 29),
				NextDate.nextDay(2000, 6, 30),
				NextDate.nextDay(2000, 6, 31));
		List<String> expecteds = Arrays.asList(
				"年错误",
				"1812.6.15",
				"1813.6.15",
				"2011.6.15",
				"2012.6.15",
				"年错误",
				"月错误",
				"2000.1.15",
				"2000.2.15",
				"2000.11.15",
				"2000.12.15",
				"月错误",
				"日错误",
				"2000.6.2",
				"2000.6.3",
				"2000.6.30",
				"2000.7.1",
				"日错误");
		Iterator<String> ita = actuals.iterator();
		Iterator<String> ite = expecteds.iterator();
		
		while (ita.hasNext() && ite.hasNext()) {
			assertEquals(ita.next(), ite.next());
		}
	}
	@Test
	final void decisionTable() {
		List<String> actuals = Arrays.asList(
				NextDate.nextDay(2000, 6, 14),
				NextDate.nextDay(2000, 6, 28),
				NextDate.nextDay(2000, 6, 29),
				NextDate.nextDay(2000, 6, 30),
				NextDate.nextDay(2000, 6, 31),
				NextDate.nextDay(2000, 7, 14),
				NextDate.nextDay(2000, 7, 28),
				NextDate.nextDay(2000, 7, 29),
				NextDate.nextDay(2000, 7, 30),
				NextDate.nextDay(2000, 7, 31),
				NextDate.nextDay(2000, 12, 14),
				NextDate.nextDay(2000, 12, 28),
				NextDate.nextDay(2000, 12, 29),
				NextDate.nextDay(2000, 12, 30),
				NextDate.nextDay(2000, 12, 31),
				NextDate.nextDay(2000, 2, 14),
				NextDate.nextDay(2000, 2, 28),
				NextDate.nextDay(1999, 2, 28),
				NextDate.nextDay(2000, 2, 29),
				NextDate.nextDay(1999, 2, 29),
				NextDate.nextDay(2000, 2, 30),
				NextDate.nextDay(2000, 2, 31));
		List<String> expecteds = Arrays.asList(
				"2000.6.15",
				"2000.6.29",
				"2000.6.30",
				"2000.7.1",
				"日错误",
				"2000.7.15",
				"2000.7.29",
				"2000.7.30",
				"2000.7.31",
				"2000.8.1",
				"2000.12.15",
				"2000.12.29",
				"2000.12.30",
				"2000.12.31",
				"2001.1.1",
				"2000.2.15",
				"2000.2.29",
				"1999.3.1",
				"2000.3.1",
				"日错误",
				"日错误",
				"日错误");
		Iterator<String> ita = actuals.iterator();
		Iterator<String> ite = expecteds.iterator();
		
		while (ita.hasNext() && ite.hasNext()) {
			assertEquals(ita.next(), ite.next());
		}
	}


}
