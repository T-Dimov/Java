package ticTacToe;

import java.util.Scanner;
import java.util.Vector;

public class TicTacToe
{
	private static Vector<Player> players;
	static Scanner scanner;
	
	public static void main(String[] args)
	{
		System.out.println("Wellcome to TicTacToe!");
		players = new Vector<Player>(2, 2);
		scanner = new Scanner(System.in);
		int boardSize;

		System.out.println("Please enter board size (2 or lower to quit game):");
		String input = scanner.nextLine();
		boardSize = Integer.parseInt(input);
		while (boardSize > 2)
		{
			System.out.println("Please enter Player1's name: ");
			String name0 = scanner.nextLine();
			Player player0 = selectPlayer(name0);
			
			System.out.println("Please enter Player2's name: ");
			String name1 = scanner.nextLine();
			Player player1 = selectPlayer(name1);
			
			Game game = new Game(player0, player1, boardSize);
			game.play();
			
			System.out.println("Please enter board size (2 or lower to quit game):");
			input = scanner.nextLine();
			boardSize = Integer.parseInt(input);
		}
		
		System.out.println("\nScores:");
		for(int i = 0; i < players.size(); ++i)
		{
			Player player = players.get(i);
			System.out.println(player.name + ": " + Integer.toString(player.score));
		}
		
		scanner.close();
	}
	
	private static int playerExists(String name)
	{
		for(int i = 0; i < players.size(); ++i)
		{
			if(players.get(i).name.equals(name))
			{
				return i;
			}
		}
		return -1;
	}
	
	private static Player selectPlayer(String name)
	{
		Player player;
		int playerIndex = playerExists(name);
		if(playerIndex > -1)
		{
			player = players.get(playerIndex);
		}
		else
		{
			player = new Player(name);
			players.add(player);
		}
		return player;
	}
}
