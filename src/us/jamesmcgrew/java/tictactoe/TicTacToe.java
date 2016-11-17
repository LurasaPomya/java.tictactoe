package us.jamesmcgrew.java.games.tictactoe;

public class TicTacToe {

    private char[][] grid; 
    private char curPlayer;
			
    public TicTacToe() {
        grid = new char[3][3];
        curPlayer = 'x';
        resetBoard();
    }
	
    //Reset the board
    public void resetBoard() {
		curPlayer = 'x';
        // Loop through rows
        for (int x = 0; x < 3; x++) {
			
            // Loop through columns
            for (int y = 0; y < 3; y++) {
                grid[x][y] = '-';
            }
        }
    }
    
    public char[][] getBoard() {
    	return grid;
    }
	
    //Checks if the grid is full
    public boolean checkForFull() {
        boolean full = true;
		
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (grid[x][y] == '-') {
                    full = false;
                }
            }
        }
		
        return full;
    }
	
	
    //Checks to see if someone has won
    public boolean checkWin() {
        return (checkRowWin() || checkColWin() || checkDiagWin());
    }
	
	
    // Loop through rows for win
    private boolean checkRowWin() {
        for (int x = 0; x < 3; x++) {
            if (checkRowCol(grid[x][0], grid[x][1], grid[x][2]) == true) {
                return true;
            }
        }
        return false;
    }
	
	
    // Loop through columns for win.
    private boolean checkColWin() {
        for (int y = 0; y < 3; y++) {
            if (checkRowCol(grid[0][y], grid[1][y], grid[2][y]) == true) {
                return true;
            }
        }
        return false;
    }
	
	
    // Check the two diagonals to see if either is a win. Return true if either wins.
    private boolean checkDiagWin() {
        return ((checkRowCol(grid[0][0], grid[1][1], grid[2][2]) == true) || (checkRowCol(grid[0][2], grid[1][1], grid[2][0]) == true));
    }
	
	
    // Check to see if all three values are the same (and not empty) indicating a win.
    private boolean checkRowCol(char c1, char c2, char c3) {
        return ((c1 != '-') && (c1 == c2) && (c2 == c3));
    }
	
	
    // Change player marks back and forth.
    public void changePlayer() {
        if (curPlayer == 'x') {
            curPlayer = 'o';
        }
        else {
            curPlayer = 'x';
        }
    }
	
	
    // Places a mark at the cell specified by row and col with the mark of the current player.
    public boolean placeMark(int row, int col) {
		
        // Make sure that row and column are in bounds of the board.
        if ((row >= 0) && (row < 3)) {
            if ((col >= 0) && (col < 3)) {
                if (grid[row][col] == '-') {
                    grid[row][col] = curPlayer;
                    return true;
                }
            }
        }
		
        return false;
    }
    
    public char getCurrentPlayer() {
    	return curPlayer;
    }
}