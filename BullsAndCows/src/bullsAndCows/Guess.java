package bullsAndCows;

import java.util.ArrayList;

abstract class Guess<T>
{
	protected ArrayList<T> symbols;
	protected int guessLength;
	protected String alphabet;
	
	Guess(int n)
	{
		guessLength = n;
		symbols = new ArrayList<T>();
		generateRandom();
	}
	
	Result match(ArrayList<T> guess)
	{
		int bulls = 0;
		int cows = 0;
		
		for (int i = 0; i < guess.size(); i++)
		{
			if (symbols.contains(guess.get(i)))
			{
				if (symbols.get(i).equals(guess.get(i)))
				{
					++bulls;
				}
				else
				{
					++cows;
				}
			}
		}
		
		return new Result(bulls, cows);
	}
	
	boolean validInput(String input)
	{
		if (input.length() != guessLength)
		{
			return false;
		}
		
		for (int i = 0; i < guessLength; ++i)
		{
			if (alphabet.indexOf(input.charAt(i)) == -1)
			{
				return false;
			}
		}
		
		return true;
	}
	
	abstract void generateRandom();
}
