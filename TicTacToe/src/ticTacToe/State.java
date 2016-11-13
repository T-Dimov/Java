package ticTacToe;

enum State
{
	IN_PROGRESS(0), X(1), O(2), TIE(3);
	
	private int value;

	State(int numVal)
    {
    	value = numVal;
    }

    int getValue()
    {
        return value;
    }
}
