package bullsAndCows;

import java.util.Random;

class Numbers extends Guess<Integer>
{
	Numbers(int n)
	{
		super(n);
		alphabet = "0123456789";
	}
	
	@Override
	void generateRandom()
	{
		Random random = new Random();
		for (int i = 0; i < guessLength;)
		{
			int rand = random.nextInt(10);
			if (!symbols.contains(rand))
			{
				symbols.add(rand);
				++i;
			}
		}
	}
}
