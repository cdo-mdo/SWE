import static org.junit.Assert.*;
import org.junit.Test;

import org.edu.miu.cs.cs425.MortgageCalculator;

import java.time.LocalDate;


public class MortgageTest {

	@Test
	public void testUnder18() {
		LocalDate time17YearsAgo = LocalDate.now().minusYears(17).minusMonths(11);
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgageSingle(time17YearsAgo, 3000, "Architect");
		assertEquals(0, result, 0.001);
	}

	@Test
	public void testOver18SingleArchitect() {
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgageSingle(LocalDate.of(1967, 5, 2), 3000, "Architect");
	    assertEquals(180000, result, 0.001);
	}

	@Test
	public void test2() {
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgageSingle(LocalDate.of(2001, 5, 2), 3000, "Architect");
	    assertEquals(180000, result, 0.001);
	}

	@Test
	public void test3() {
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgageMarried(LocalDate.of(1977, 12, 2), 4000, 2000, "Developer");
	    assertEquals(220000, result, 0.001);
	}

	@Test
	public void test4() {
		MortgageCalculator mc = new MortgageCalculator();
		double result = mc.computeMaxMortgageMarried(LocalDate.of(1954, 5, 12), 5500, 0, "Professor");
	    assertEquals(280000, result, 0.001);
	}

}
