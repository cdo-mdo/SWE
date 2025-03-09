package org.edu.miu.cs.cs425;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;

public class MortgageCalculator {

	private static final int AGE_TO_APPLY_MORTGAGE = 18;

	private static final double INCOME_LOW = 2000;
	private static final double INCOME_MEDIUM = 3000;
	private static final double INCOME_HIGH = 5000;
	private static final Map<String, double[]> MORTGAGE_RANGES = new HashMap<>();

	static {
		MORTGAGE_RANGES.put("Developer", new double[] {160000, 180000, 220000});
		MORTGAGE_RANGES.put("Architect", new double[] {160000, 180000, 220000});
		MORTGAGE_RANGES.put("Scrum master", new double[] {160000, 180000, 220000});
		MORTGAGE_RANGES.put("Tester", new double[] {120000, 140000, 160000});
		MORTGAGE_RANGES.put("System Administrator", new double[] {120000, 140000, 160000});
		MORTGAGE_RANGES.put("Technical writer", new double[] {120000, 140000, 160000});
		MORTGAGE_RANGES.put("Department head", new double[] {220000, 250000, 280000});
		MORTGAGE_RANGES.put("Professor", new double[] {220000, 250000, 280000});
	}

	public double computeMaxMortgageSingle(LocalDate birthDate, double monthlyIncome, String profession) {
		if (ChronoUnit.YEARS.between(birthDate, LocalDate.now()) < AGE_TO_APPLY_MORTGAGE) {
			return 0;
		}

		return computeMaxMortgage(monthlyIncome, profession);
	}

	public double computeMaxMortgageMarried(LocalDate birthDate, double monthlyIncome, double monthlyIncomePartner, String profession) {
		if (ChronoUnit.YEARS.between(birthDate, LocalDate.now()) < AGE_TO_APPLY_MORTGAGE) {
			return 0;
		}

 		double totalIncome = monthlyIncome + monthlyIncomePartner * 0.94;
		return computeMaxMortgage(totalIncome, profession);
	}

	private double computeMaxMortgage(double monthlyIncome, String profession) {
		if (!MORTGAGE_RANGES.containsKey(profession)) {
			return 0; // Default case if profession is not recognized
		}

		int incomeBracket = getIncomeBracket(monthlyIncome);
		return MORTGAGE_RANGES.get(profession)[incomeBracket];
	}

	private int getIncomeBracket(double monthlyIncome) {
		if (monthlyIncome >= INCOME_HIGH) return 2;  // High income
		if (monthlyIncome >= INCOME_MEDIUM) return 1; // Medium income
		if (monthlyIncome >= INCOME_LOW) return 0;  // Low income
		return -1;  // Income below threshold
	}
}
