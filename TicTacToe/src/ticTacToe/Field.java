package ticTacToe;

public class Field
{
	int position;
	Symbol symbol;
	
	Field(int pos)
	{
		position = pos;
		symbol = Symbol.EMPTY;
	}
	
	@Override
	public String toString()
	{
		if(symbol == Symbol.O)
			return "O";
		else if(symbol == Symbol.X)
			return "X";
		else
			return Integer.toString(position);
	}
}
