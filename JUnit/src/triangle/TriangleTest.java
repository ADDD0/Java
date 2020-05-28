package triangle;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

class TriangleTest {
	@Test
	final void statementCoverage() {
		List<String> expecteds = Arrays.asList(
				"非三角形",
				"等边三角形",
				"一般三角形",
				"等腰三角形");
		List<String> actuals = Arrays.asList(
				Triangle.type(0, 0, 0),
				Triangle.type(3, 3, 3),
				Triangle.type(3, 4, 5),
				Triangle.type(3, 3, 4));
		Iterator<String> ite = expecteds.iterator();
		Iterator<String> ita = actuals.iterator();

		while (ite.hasNext() && ita.hasNext()) {
			assertEquals(ite.next(), ita.next());
		}
	}
	
	@Test
	final void pathCoverage() {
		List<String> expecteds = Arrays.asList(
				"非三角形",
				"等边三角形",
				"一般三角形",
				"等腰三角形");
		List<String> actuals = Arrays.asList(
				Triangle.type(0, 0, 0),
				Triangle.type(3, 3, 3),
				Triangle.type(3, 4, 5),
				Triangle.type(3, 3, 4));
		Iterator<String> ite = expecteds.iterator();
		Iterator<String> ita = actuals.iterator();

		while (ite.hasNext() && ita.hasNext()) {
			assertEquals(ite.next(), ita.next());
		}
	}
	
	@Test
	final void judgementCoverage() {
		List<String> expecteds = Arrays.asList(
				"非三角形",
				"等边三角形",
				"一般三角形",
				"等腰三角形");
		List<String> actuals = Arrays.asList(
				Triangle.type(0, 0, 0),
				Triangle.type(3, 3, 3),
				Triangle.type(3, 4, 5),
				Triangle.type(3, 3, 4));
		Iterator<String> ite = expecteds.iterator();
		Iterator<String> ita = actuals.iterator();

		while (ite.hasNext() && ita.hasNext()) {
			assertEquals(ite.next(), ita.next());
		}
	}
	
	@Test
	final void conditionCoverage() {
		List<String> expecteds = Arrays.asList(
				"一般三角形",
				"非三角形");
		List<String> actuals = Arrays.asList(
				Triangle.type(3, 4, 5),
				Triangle.type(0, 0, 0));
		Iterator<String> ite = expecteds.iterator();
		Iterator<String> ita = actuals.iterator();

		while (ite.hasNext() && ita.hasNext()) {
			assertEquals(ite.next(), ita.next());
		}
	}
	
	@Test
	final void judgementAndConditionCoverage() {
		List<String> expecteds = Arrays.asList(
				"非三角形",
				"等边三角形",
				"一般三角形",
				"等腰三角形");
		List<String> actuals = Arrays.asList(
				Triangle.type(0, 0, 0),
				Triangle.type(3, 3, 3),
				Triangle.type(3, 4, 5),
				Triangle.type(3, 3, 4));
		Iterator<String> ite = expecteds.iterator();
		Iterator<String> ita = actuals.iterator();

		while (ite.hasNext() && ita.hasNext()) {
			assertEquals(ite.next(), ita.next());
		}
	}
	
	@Test
	final void conditionalCombinationCoverage() {
		List<String> expecteds = Arrays.asList(
				"一般三角形",
				"非三角形",
				"非三角形",
				"非三角形",
				"非三角形",
				"非三角形",
				"非三角形",
				"非三角形",
				"等边三角形",
				"等腰三角形");
		List<String> actuals = Arrays.asList(
				Triangle.type(3, 4, 5),
				Triangle.type(9, 3, 4),
				Triangle.type(3, 9, 4),
				Triangle.type(3, 3, 0),
				Triangle.type(3, 4, 9),
				Triangle.type(3, 0, 3),
				Triangle.type(0, 3, 3),
				Triangle.type(0, 0, 0),
				Triangle.type(3, 3, 3),
				Triangle.type(3, 3, 4));
		Iterator<String> ite = expecteds.iterator();
		Iterator<String> ita = actuals.iterator();

		while (ite.hasNext() && ita.hasNext()) {
			assertEquals(ite.next(), ita.next());
		}
	}
}
