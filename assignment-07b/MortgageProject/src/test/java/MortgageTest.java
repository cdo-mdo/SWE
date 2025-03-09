import static org.junit.Assert.*;
import org.junit.Test;

import org.edu.miu.cs.cs425.MortgageCalculator;

import java.time.LocalDate;


public class MortgageTest {

	private final MortgageCalculator mc = new MortgageCalculator();

	private static final LocalDate OVER_18_BIRTHDATE = LocalDate.now().minusYears(19); //
	private static final LocalDate UNDER_18_BIRTHDATE = LocalDate.now().minusYears(17).minusMonths(11); // Under 18 case// Ensure over 18

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

	@Test
	public void testMarriedArchitect_LowIncome() {
		assertEquals(180000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 2500, 1000, "Architect"), 0.001);
	}

	@Test
	public void testMarriedArchitect_MediumIncome() {
		assertEquals(220000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 3500, 2000, "Architect"), 0.001);
	}

	@Test
	public void testMarriedArchitect_HighIncome() {
		assertEquals(220000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 6000, 3000, "Architect"), 0.001);
	}

	@Test
	public void testMarriedTester_LowIncome() {
		assertEquals(140000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 2500, 1000, "Tester"), 0.001);
	}

	@Test
	public void testMarriedTester_MediumIncome() {
		assertEquals(160000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 3500, 2000, "Tester"), 0.001);
	}

	@Test
	public void testMarriedTester_HighIncome() {
		assertEquals(160000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 6000, 3000, "Tester"), 0.001);
	}

	@Test
	public void testMarriedDepartmentHead_LowIncome() {
		assertEquals(250000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 2500, 1000, "Department head"), 0.001);
	}

	@Test
	public void testMarriedDepartmentHead_MediumIncome() {
		assertEquals(280000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 3500, 2000, "Department head"), 0.001);
	}

	@Test
	public void testMarriedDepartmentHead_HighIncome() {
		assertEquals(280000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 6000, 3000, "Department head"), 0.001);
	}

	@Test
	public void testMarriedUnknownProfession() {
		assertEquals(0, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 4000, 2000, "Unknown"), 0.001);
	}

	@Test
	public void testMarriedUnder18_RejectMortgage() {
		assertEquals(0, mc.computeMaxMortgageMarried(UNDER_18_BIRTHDATE, 4000, 2000, "Developer"), 0.001);
	}

	@Test
	public void testMarriedExactly18YearsOld() {
		LocalDate exactly18YearsOld = LocalDate.now().minusYears(18);
		assertEquals(220000, mc.computeMaxMortgageMarried(exactly18YearsOld, 4000, 2000, "Developer"), 0.001);
	}

	@Test
	public void testMarriedWithPartnerIncomeAffectingBracket() {
		assertEquals(180000, mc.computeMaxMortgageMarried(OVER_18_BIRTHDATE, 2000, 2000, "Developer"), 0.001);
	}
}
