package footballTeam;

import java.time.*;
import java.util.Arrays;

class ManagementSystem
{
	private Employee[] employees;
	private int size;
	private int maximum;
	
	ManagementSystem()
	{
		employees = new Employee[60];
		size = 0;
		maximum = 60;
	}
	
	void addEmployee(Employee employee)
	{
		if (employee.equals(null))
		{
            throw new IllegalArgumentException("Invalid argument");
        } 
		else 
		{
            if (size < maximum) 
            {
            	employees[size] = employee;
            	++size;
            }
            else
            {
                throw new IllegalStateException("Array is full");
            }
		}
	}
	
	void printSorted()
	{
		Arrays.sort(employees, 0, size - 1);
		for (int i = 0; i < size; ++i)
		{
			System.out.println(employees[i]);
		}
	}
	
	void printExpiringContracts(LocalDate targetDate)
	{
		for (int i = 0; i < size; ++i)
		{
			if (employees[i].contractExpirationDate.isBefore(targetDate))
			{
				System.out.println(employees[i]);
			}
		}
	}
}
