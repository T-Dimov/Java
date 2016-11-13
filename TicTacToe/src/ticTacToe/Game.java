package ticTacToe;

class Game
{
	Board board;
	Player[] players;
	Symbol[] symbols;
	Player currentPlayer;
	int currentIndex;
	int moveCount;
	State state;
	
	Game(Player player0, Player player1)
	{
		board = new Board();
		ctorHelper(player0, player1);
	}
	
	Game(Player player0, Player player1, int boardSize)
	{
		board = new Board(boardSize);
		ctorHelper(player0, player1);
	}
	
	void play()
	{
		while(state == State.IN_PROGRESS)
		{
			System.out.println("\n" + board + "\n");
			System.out.println("Player " + symbols[currentIndex] + 
				", please enter your move (1-" + (board.area) +
				")> ");
			String input = TicTacToe.scanner.nextLine();
			int position = Integer.parseInt(input);
			if (board.validMove(position))
			{
				board.takeMove(position, symbols[currentIndex]);
				++moveCount;
				updateState(position);
				currentIndex = 1 - currentIndex;
				currentPlayer = players[currentIndex];
			}
			else
			{
				System.err.println("Invalid move!\n");
			}
			
		}
		System.out.println("\n" + board + "\n");
		
		if(state == State.X)
		{
			System.out.println("Player X wins!\n");
			players[0].addVictory();
		}
		else if(state == State.O)
		{
			System.out.println("Player O wins!\n");
			players[1].addVictory();
		}
		else
		{
			System.out.println("The game is tied!\n");
		}
	}
	
	private void ctorHelper(Player player0, Player player1)
	{
		state = State.IN_PROGRESS;
		players = new Player[2];
		players[0] = player0;
		players[1] = player1;
		symbols = new Symbol[2];
		symbols[0] = Symbol.X;
		symbols[1] = Symbol.O;
		currentIndex = 0;
		currentPlayer = players[currentIndex];
		moveCount = 0;
	}
	
	private void updateState(int pos)
	{
		int x = (pos - 1) / board.size;
		int y = (pos - 1) % board.size;
		
		for(int i = 0; i < board.size; ++i)
		{
    		if(board.field[x][i].symbol != symbols[currentIndex])
    			break;
    		if(i == board.size - 1)
    		{
    			state = State.values()[symbols[currentIndex].getValue()];
    		}
    	}
		
		for(int i = 0; i < board.size ; ++i)
		{
    		if(board.field[i][y].symbol != symbols[currentIndex])
    			break;
    		if(i == board.size -1)
    		{
    			state = State.values()[symbols[currentIndex].getValue()];
    		}
    	}

    	if(x == y)
    	{
    		for(int i = 0; i < board.size ; ++i)
    		{
    			if(board.field[i][i].symbol != symbols[currentIndex])
    				break;
    			if(i == board.size -1)
    			{
    				state = State.values()[symbols[currentIndex].getValue()];
    			}
    		}
    	}

    	for(int i = 0; i < board.size; ++i)
    	{
    		if(board.field[i][(board.size -1) - i].symbol != symbols[currentIndex])
    			break;
    		if(i == board.size -1)
    		{
    			state = State.values()[symbols[currentIndex].getValue()];
    		}
    	}

    	if(moveCount == (board.area - 1))
    	{
    		state = State.TIE;
    	}
	}
}
