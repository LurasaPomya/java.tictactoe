package us.jamesmcgrew.java.tictactoe;

import java.util.Scanner;

public class Game {
	
	private static char[][] grid;
	private static TicTacToe game = new TicTacToe();
	
	public static void main(String[] args) {
		
		//Get Scanner object to get input from user.
		Scanner in = new Scanner(System.in);
		
		//Create Game Object.
		
		grid = game.getBoard();
		
		printBoard();
		
		boolean finished = false;
		
		
		while (!finished) {
			//This will test for a winner or draw, and then ask someone to play.
			if (game.checkWin()) {
			   System.out.println("We have a winner! Congrats!");
			   System.exit(0);
			}
			else if (game.checkForFull()) {
			   System.out.println("Appears we have a draw!");
			   System.exit(0);
			}
			else {				
				//Place the mark, subtracting 1 since we want the player to pick 1 - 3
				boolean legitPlace = false;
				
				//Checks if the place is legit
				while (!legitPlace) {
					
					System.out.println(game.getCurrentPlayer() + ", please select row?");
					int selectedRow = in.nextInt();
					System.out.println(game.getCurrentPlayer() + ", please select a column");
					int selectedCol = in.nextInt();
					
					legitPlace = game.placeMark(selectedRow - 1, selectedCol - 1);
					if (!legitPlace) { System.out.println("Invalid Choice, select again!");}
					
					grid = game.getBoard();
					
					//print the board for the player.
					printBoard();
				}
				
				//Change player so other player can go
				game.changePlayer();
			}
		}
		
		in.close();
	}
	
	// Print the current board, I want to make this a GUI eventually.
    public static void printBoard() {
        System.out.println("-------------");
		
        for (int x = 0; x < 3; x++) {
            System.out.print("| ");	//prints the line between the rows
            for (int y = 0; y < 3; y++) {
                System.out.print(grid[x][y] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }
}
