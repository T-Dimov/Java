package todoList;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

public class TODOlist
{
	private static Vector<Task> tasks;
	
	private static void fillTasks()
	{
		tasks = new Vector<Task>(5, 3);
		Task task0 = new Task("task0", "some task", Status.INITIAL, 3, 2016, 10, 31);
		tasks.add(task0);
		Task task1 = new Task("task1", "some task", Status.IN_PROCESS, 1, 2016, 11, 1);
		tasks.add(task1);
		Task task2 = new Task("task2", "some task", Status.DONE, 3, 2016, 10, 28);
		tasks.add(task2);
		Task task3 = new Task("task3", "some task", Status.IN_PROCESS, 2, 2016, 10, 30);
		tasks.add(task3);
		Task task4 = new Task("task4", "some task", Status.INITIAL, 1, 2016, 10, 30);
		tasks.add(task4);
		Task task5 = new Task("task5", "some task", Status.DONE, 5, 2016, 10, 29);
		tasks.add(task5);
		Task task6 = new Task("task6", "some task", Status.INITIAL, 4, 2016, 11, 5);
		tasks.add(task6);
	}
	
	private static int menu(Scanner scanner)
	{
		System.out.println("Изберете опция:\n\n" + 
				"1) Всички задачи подредени по приоритет\n" +
				"2) Задачи със статус IN PROCESS\n" +
				"3) Задачи, които да се завършат в следващите три дни\n" +
				"4) Изход\n");
		System.out.print("Вашият избор (1-4): ");
		
		String input = scanner.nextLine();
		int choice = Integer.parseInt(input);
		if (choice < 1 || choice > 4)
		{
			throw new IllegalArgumentException("Invalid choice!");
		}
		else
		{
			return choice;
		}
	}
	
	private static void printAll()
	{
		for(int i = 0; i < tasks.size(); ++i)
		{
			System.out.println(tasks.get(i).toString() + "\n");
		}
	}
	
	private static void printInProgress()
	{
		for(int i = 0; i < tasks.size(); ++i)
		{
			Task task = tasks.get(i);
			if(task.status == Status.IN_PROCESS)
			{
				System.out.println(task.toString() + "\n");
			}
		}
	}
	
	private static void printUrgent()
	{
		for(int i = 0; i < tasks.size(); ++i)
		{
			Task task = tasks.get(i);
			if(LocalDate.now().plusDays(4).isAfter(task.dueDate) &&
					task.dueDate.plusDays(1).isAfter(LocalDate.now()) &&
					task.status != Status.DONE)
			{
				System.out.println(tasks.get(i).toString() + "\n");
			}
		}
	}
	
	public static void main(String[] args)
	{
		fillTasks();
		Collections.sort(tasks);
		Scanner scanner = new Scanner(System.in);
		
		int choice = 1;
		while(choice != 4)
		{
			try
			{
				choice = menu(scanner);
				switch(choice)
				{
				case 1:
					printAll();
					break;
					
				case 2:
					printInProgress();
					break;
					
				case 3:
					printUrgent();
					break;
				}
			}
			catch (IllegalArgumentException ex)
			{
				System.err.println(ex.getMessage());
			}
		}
	}

}
