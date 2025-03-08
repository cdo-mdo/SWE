package org.edu.miu.cs.cs425;

import java.time.LocalDate;
import java.time.Period;

public class MortgageCalculator {

	public double computeMaxMortgage(int yearOfBirt, int month, int day, double monthlyIncome, boolean married, double monthlyIncomePartner, String profession) {
		double result=0;
		//calculate age
		LocalDate today = LocalDate.now();                          //Today's date
		LocalDate birthday = LocalDate.of(yearOfBirt, month, day);  //Birth date

		Period p = Period.between(birthday, today);
		int age = p.getYears();
		System.out.println(age);

		if (age < 18) {
			result = 0;
			return result;
		}

		double totalIncome = monthlyIncome;
		if (married) {
			totalIncome = monthlyIncome + monthlyIncomePartner * 0.94;
		}

		if (2000<=totalIncome && totalIncome<3000) {
			if (profession.equals("Developer") || profession.equals("Architect") || profession.equals("Scrum master")) result = 160000;
			if (profession.equals("Tester") || profession.equals("System Administrator") || profession.equals("Technical writer")) result = 120000;
			if (profession.equals("Department head") || profession.equals("Professor") ) result = 220000;
			return result;
		}
		if (3000<=totalIncome && totalIncome<5000) {
			if (profession.equals("Developer") || profession.equals("Architect") || profession.equals("Scrum master")) result = 180000;
			if (profession.equals("Tester") || profession.equals("System Administrator") || profession.equals("Technical writer")) result = 140000;
			if (profession.equals("Department head") || profession.equals("Professor") ) result = 250000;
			return result;
		}
		if (5000<=totalIncome) {
			if (profession.equals("Developer") || profession.equals("Architect") || profession.equals("Scrum master")) result = 220000;
			if (profession.equals("Tester") || profession.equals("System Administrator") || profession.equals("Technical writer")) result = 160000;
			if (profession.equals("Department head") || profession.equals("Professor") ) result = 280000;
			return result;
		}
		return result;
	}

}
