package bullsAndCows;

import java.util.Scanner;

public class BullsAndCows
{
	static Game game;
	
	public static void main(String[] args)
	{
		Scanner scanner = new Scanner(System.in);
		
		boolean validChoice = false;
		int choice;
		int length;
		do
		{
			System.out.print("Въведете типа на символите (цифри - 1, латински букви - 2): ");
			choice = Integer.parseInt(scanner.nextLine());
			switch (choice)
			{
			case 1:
				length = getLength(scanner, 10);
				game = new Game(length, choice);
				validChoice = true;
				break;
			case 2:
				length = getLength(scanner, 52);
				game = new Game(length, choice);
				validChoice = true;
				break;
			default:
				System.err.println("Невалиден избор!");
			}
		} while(!validChoice);
		
		game.play(scanner);
		
		scanner.close();
	}

	private static int getLength(Scanner scanner, int maxLength)
	{
		int length;
		do
		{
			System.out.print("Въведете дължината на вашето предположение: ");
			length = Integer.parseInt(scanner.nextLine());
		} while( length < 1 || length > maxLength);
		
		return length;
	}
}
