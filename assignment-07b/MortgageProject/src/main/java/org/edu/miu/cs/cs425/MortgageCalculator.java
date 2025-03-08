package org.edu.miu.cs.cs425;

import java.time.LocalDate;
import java.time.Period;

public class MortgageCalculator {

	public double computeMaxMortgageSingle(int yearOfBirt, int month, int day, double monthlyIncome, String profession) {
		if (ageOf(yearOfBirt, month, day) < 18) {
			return 0;
		}

		return computeMaxMortgage(monthlyIncome, profession);
	}

	public double computeMaxMortgageMarried(int yearOfBirt, int month, int day, double monthlyIncome, double monthlyIncomePartner, String profession) {
		if (ageOf(yearOfBirt, month, day) < 18) {
			return 0;
		}

 		double totalIncome = monthlyIncome + monthlyIncomePartner * 0.94;

		return computeMaxMortgage(totalIncome, profession);
	}

	private int ageOf(int yearOfBirt, int month, int day) {
		//calculate age
		LocalDate today = LocalDate.now();                          //Today's date
		LocalDate birthday = LocalDate.of(yearOfBirt, month, day);  //Birth date

		Period p = Period.between(birthday, today);
		int age = p.getYears();
		System.out.println(age);

		return age;
	}

	private double computeMaxMortgage(double monthlyIncome, String profession) {
		double result=0;

		if (2000<=monthlyIncome && monthlyIncome<3000) {
			if (profession.equals("Developer") || profession.equals("Architect") || profession.equals("Scrum master")) result = 160000;
			if (profession.equals("Tester") || profession.equals("System Administrator") || profession.equals("Technical writer")) result = 120000;
			if (profession.equals("Department head") || profession.equals("Professor") ) result = 220000;
			return result;
		}
		if (3000<=monthlyIncome && monthlyIncome<5000) {
			if (profession.equals("Developer") || profession.equals("Architect") || profession.equals("Scrum master")) result = 180000;
			if (profession.equals("Tester") || profession.equals("System Administrator") || profession.equals("Technical writer")) result = 140000;
			if (profession.equals("Department head") || profession.equals("Professor") ) result = 250000;
			return result;
		}
		if (5000<=monthlyIncome) {
			if (profession.equals("Developer") || profession.equals("Architect") || profession.equals("Scrum master")) result = 220000;
			if (profession.equals("Tester") || profession.equals("System Administrator") || profession.equals("Technical writer")) result = 160000;
			if (profession.equals("Department head") || profession.equals("Professor") ) result = 280000;
			return result;
		}
		return result;
	}

}
