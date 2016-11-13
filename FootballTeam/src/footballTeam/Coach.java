package footballTeam;

import java.time.*;

class Coach extends Employee
{
	CoachSeniority seniority;
	int titlesInCarier;
	
	Coach(String name, int age, LocalDate contrExpDate, CoachSeniority sen, int tic)
	{
		super(name, age, contrExpDate, 8_000);
		seniority = sen;
		titlesInCarier = tic;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " " + seniority + " " + Integer.toString(titlesInCarier);
	}
	
	@Override
	double getSalary()
	{
		return titlesInCarier > 5 ? baseSalary + 5_000 : baseSalary;
	}

}
