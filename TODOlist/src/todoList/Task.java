package todoList;

import java.time.LocalDate;

class Task implements Comparable<Task>
{
	private String title;
	private String description;
	Status status;
	private int priority;
	LocalDate dueDate;
	
	Task(String t, String desc, Status stat, int prio, int year, int month, int day)
	{
		title = t;
		description = desc;
		status = stat;
		priority = prio;
		dueDate = LocalDate.of(year, month, day);
	}
	
	@Override
    public int compareTo(Task otherTask)
	{
		return this.priority - otherTask.priority;
    }
	
	@Override
	public String toString()
	{
		return title + "\n" + status.toString() + "\n" + 
				Integer.toString(priority) + "\n" + dueDate.toString();
	}
}
