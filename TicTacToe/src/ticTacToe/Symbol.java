package ticTacToe;

enum Symbol
{
	EMPTY(0), X(1), O(2);
	
	private int value;

	Symbol(int numVal)
    {
    	value = numVal;
    }

    int getValue()
    {
        return value;
    }
}
