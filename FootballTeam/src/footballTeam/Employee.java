package footballTeam;

import java.time.*;

abstract class Employee implements Comparable<Employee>
{
	String name;
	int age;
	LocalDate contractExpirationDate;
	int baseSalary;
	
	Employee(String n, int a, LocalDate ced, int sal)
	{
		name = n;
		age = a;
		contractExpirationDate = ced;
		baseSalary = sal;
	}
	
	abstract double getSalary();
	
	@Override
	public String toString()
	{
		return name + " " + Integer.toString(age) + " " + contractExpirationDate.toString(); 
	}
	
	@Override
    public int compareTo(Employee other)
    {
		if (contractExpirationDate != other.contractExpirationDate)
			return contractExpirationDate.compareTo(other.contractExpirationDate);
		else
		{
			return name.compareTo(other.name);
		}
    }
}
