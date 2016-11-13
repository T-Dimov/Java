package ticTacToe;

class Board
{
	Field[][] field;
	int size;
	int area;
	int fieldToConstruct;
	
	Board()
	{
		size = 3;
		ctorHelper();
	}
	
	Board(int n)
	{
		size = n;
		ctorHelper();
	}
	
	@Override
	public String toString()
	{
		String output = new String("");
		
		for(int i = 0; i <  size - 1; ++i)
		{
			for(int j = 0; j <  size - 1; ++j)
			{
				output = output.concat(" ").concat(field[i][j].toString()).concat(" |");
			}
			output = output.concat(" ").concat(field[i][size - 1].toString()).concat(" \n");
			for(int j = 0; j <  size - 1; ++j)
			{
				output = output.concat("---|");				
			}
			output = output.concat("---\n");
		}
		
		for(int j = 0; j <  size - 1; ++j)
		{
			output = output.concat(" ").concat(field[size - 1][j].toString()).concat(" |");				
		}
		output = output.concat(" ").concat(field[size - 1][size - 1].toString()).concat(" ");
		
		return output;
	}
	
	boolean validMove(int pos)
	{
		return (pos > 0) && (pos <= size * size) && 
				(field[(pos - 1) / size][(pos - 1) % size].symbol == Symbol.EMPTY) &&
				(field[(pos - 1) / size][(pos - 1) % size].position == pos);
	}
	
	void takeMove(int pos, Symbol sym)
	{
		field[(pos - 1) / size][(pos - 1) % size].symbol = sym;
	}
	
	private void ctorHelper()
	{
		fieldToConstruct = 1;
		area = size * size;
		field = new Field[size][size];
		for (int i = 0; i < size; i++)
		{
			for (int j = 0; j < size; j++)
			{
				field[i][j] = new Field(i * size + j + 1);
			}
		}
	}
}
