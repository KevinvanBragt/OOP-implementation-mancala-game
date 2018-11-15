package nl.sogyo.domain;

import java.util.Scanner;

public class Mancala {

	/** facade **/
	
	public Cup startingcup;

	public Mancala() {
		this.startingcup = new Pitt(null, 0);
	}

	/** console methods**/
	
	public int takeMove() {
		Scanner takeMove = new Scanner(System.in);
		int move = takeMove.nextInt();
		return move;
	}

	public void printPlayerTurn() {
		if (startingcup.getOwner().getHasTurn()) {
			System.out.println(startingcup.getOwner().getName() + " it is your turn!");
		}
		else {
			System.out.println(startingcup.getOwner().getOpponent().getName() + " it is your turn!");
		}
	}
	
	public void makeMove() {
		printPlayerTurn();
		startingcup.getOwner().getHasTurn();
		drawMancala(startingcup);
		
		int move;
		do {
			move = takeMove();
		} while (validMove(move) == false);
		
		//taking player moves
		((Pitt) startingcup.getNextCup(move-1)).giveAwayStones();
	}

	public static void drawMancala(Cup startingCup) {
		
		System.out.println("\nK 13 12  11  10   9   8 <     Player2 ");
		System.out.println("-------------------------");
		for (int x = 12; x > 6; x--) {
			System.out.print( "  " + startingCup.getNextCup(x).getStones() + " ");
		}
		System.out.println(" \n" + startingCup.getNextCup(13).getStones()+ "                       " + startingCup.getNextCup(6).getStones());
		for (int x = 0; x <= 5; x++) {
			System.out.print( "  " + startingCup.getNextCup(x).getStones()+ " ");
		}
		System.out.println("\n-------------------------");
		System.out.println("\n> 1   2   3   4   5   6 K     Player1 ");
	}

	/** MVC methods **/
	
	public void makeMoveFacade(int selectedCup, Cup startingCup ) {

		if (validMove(selectedCup)) {
			((Pitt) startingcup.getNextCup(selectedCup-1)).giveAwayStones();
		}
		
	}

	public boolean validMove(int move) {
		if ((startingcup.getNextCup(move - 1).getStones() != 0) && (!(startingcup.getNextCup(move-1) instanceof Kalaha)) && (startingcup.getNextCup(move - 1).getOwner().getHasTurn() == true)) {
			return true;
		} else {
			return false;
		}
	}

	public int[] getGameState() {
		int[] gameState = new int[15];
		
		for (int x=0; x<14; x++) {
			gameState[x] = this.startingcup.getNextCup(x).getStones();
		}
		if (this.startingcup.getOwner().getHasTurn()) {	gameState[14] = 1;}
		else { gameState[14] = 0;}	
		
		return gameState;
	}
	
}
