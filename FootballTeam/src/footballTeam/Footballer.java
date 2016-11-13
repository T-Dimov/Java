package footballTeam;

import java.time.*;

class Footballer extends Employee
{
	Role role;
	int matchesThisMonth;
	
	Footballer(String name, int age, LocalDate contrExpDate, Role r, int m) 
	{
		super(name, age, contrExpDate, 10_000);
		role = r;
		matchesThisMonth = m;
	}
	
	@Override
	public String toString()
	{
		return super.toString() + " " + role + " " + Integer.toString(matchesThisMonth);
	}
	
	@Override
	double getSalary()
	{
		return baseSalary + matchesThisMonth * 250;
	}

}
