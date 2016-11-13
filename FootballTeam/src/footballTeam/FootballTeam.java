package footballTeam;

import java.time.*;

public class FootballTeam
{
	static ManagementSystem mngSys;
	
	private static void fillArray()
	{
		//LocalDate exp;
		try
		{
			LocalDate exp = LocalDate.of(2016, 11, 11);
			Footballer ronaldinho = new Footballer("Ronaldinho", 33, exp, Role.STRIKER, 3);
			mngSys.addEmployee(ronaldinho);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch (IllegalStateException e)
		{
			System.err.println(e.getMessage());
		}
		catch (NullPointerException e)
		{
			System.err.println(e.getMessage());
		}
		
		try
		{	
			LocalDate exp = LocalDate.of(2016, 12, 31);
			Coach someCoach = new Coach("Old Man", 60, exp, CoachSeniority.SENIOR, 6);
			mngSys.addEmployee(someCoach);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch (IllegalStateException e)
		{
			System.err.println(e.getMessage());
		}
		
		try
		{	
			LocalDate exp = LocalDate.of(2016, 12, 1);
			AuxiliaryPersonel someGan = new AuxiliaryPersonel("Some Guy", 50, exp, "Ganitor", 4);
			mngSys.addEmployee(someGan);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch (IllegalStateException e)
		{
			System.err.println(e.getMessage());
		}
		
		try
		{	
			LocalDate exp = LocalDate.of(2016, 12, 15);
			Footballer messi = new Footballer("Messi", 35, exp, Role.STRIKER, 4);
			mngSys.addEmployee(messi);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch (IllegalStateException e)
		{
			System.err.println(e.getMessage());
		}
		
		try
		{	
			LocalDate exp = LocalDate.of(2017, 1, 16);
			Coach someCoach = new Coach("Someone", 40, exp, CoachSeniority.ASSISTANT, 1);
			mngSys.addEmployee(someCoach);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch (IllegalStateException e)
		{
			System.err.println(e.getMessage());
		}
		
		try
		{	
			LocalDate exp = LocalDate.of(2016, 12, 21);
			AuxiliaryPersonel someMas = new AuxiliaryPersonel("Other Guy", 50, exp, "Maseusse", 10);
			mngSys.addEmployee(someMas);
		}
		catch (IllegalArgumentException e)
		{
			System.err.println(e.getMessage());
		}
		catch (IllegalStateException e)
		{
			System.err.println(e.getMessage());
		}
	}
	
	public static void main(String[] args)
	{
		mngSys = new ManagementSystem();
		fillArray();
		LocalDate expire = LocalDate.of(2016, 12, 16);
		mngSys.printSorted();
		mngSys.printExpiringContracts(expire);
	}

}
