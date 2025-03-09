import static org.junit.Assert.*;
import org.junit.Test;

import org.edu.miu.cs.cs425.MortgageCalculator;

import java.time.LocalDate;


public class MortgageTest {

	private final MortgageCalculator mc = new MortgageCalculator();

	private static final LocalDate OVER_18_BIRTHDATE = LocalDate.now().minusYears(19); // Ensure over 18

	@Test
	public void testOver18SingleArchitect_LowIncome() {
		assertEquals(160000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 2500, "Architect"), 0.001);
	}

	@Test
	public void testOver18SingleArchitect_MediumIncome() {
		assertEquals(180000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 3500, "Architect"), 0.001);
	}

	@Test
	public void testOver18SingleArchitect_HighIncome() {
		assertEquals(220000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 6000, "Architect"), 0.001);
	}

	@Test
	public void testOver18SingleTester_LowIncome() {
		assertEquals(120000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 2500, "Tester"), 0.001);
	}

	@Test
	public void testOver18SingleTester_MediumIncome() {
		assertEquals(140000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 3500, "Tester"), 0.001);
	}

	@Test
	public void testOver18SingleTester_HighIncome() {
		assertEquals(160000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 6000, "Tester"), 0.001);
	}

	@Test
	public void testOver18SingleDepartmentHead_LowIncome() {
		assertEquals(220000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 2500, "Department head"), 0.001);
	}

	@Test
	public void testOver18SingleDepartmentHead_MediumIncome() {
		assertEquals(250000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 3500, "Department head"), 0.001);
	}

	@Test
	public void testOver18SingleDepartmentHead_HighIncome() {
		assertEquals(280000, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 6000, "Department head"), 0.001);
	}

	@Test
	public void testOver18SingleUnknownProfession() {
		assertEquals(0, mc.computeMaxMortgageSingle(OVER_18_BIRTHDATE, 4000, "Unknown"), 0.001);
	}

	@Test
	public void testOver18EdgeCase_Exactly18YearsOld() {
		LocalDate exactly18YearsOld = LocalDate.now().minusYears(18);
		assertEquals(180000, mc.computeMaxMortgageSingle(exactly18YearsOld, 4000, "Developer"), 0.001);
	}

	@Test
	public void testUnder18_RejectMortgage() {
		LocalDate under18 = LocalDate.now().minusYears(17).minusMonths(11);
		assertEquals(0, mc.computeMaxMortgageSingle(under18, 4000, "Developer"), 0.001);
	}

}
