package nl.sogyo.controller;

import nl.sogyo.domain.Mancala;

public class Client {

	public static void main(String[] args) {
		
		Mancala mancala = new Mancala();
		
		boolean gameEnded = false;
		do {
			mancala.makeMove();
		} while (gameEnded == false);
			
		
	}

}
