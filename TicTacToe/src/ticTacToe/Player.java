package ticTacToe;

class Player
{
	String name;
	int score;
	
	Player(String _name)
	{
		name = _name;
		score = 0;
	}
	
	void addVictory()
	{
		++score;
	}
}
