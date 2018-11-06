package nl.sogyo.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import nl.sogyo.domain.Cup;
import nl.sogyo.domain.Kalaha;
import nl.sogyo.domain.Pitt;

public class KalahaTest {

	@Test
	public void addStonesTest() {
		Cup startingcup = new Pitt(null, 0);
		((Kalaha) startingcup.getNextCup(6)).addStones(12);
		assertTrue("addStones fails", startingcup.getNextCup(6).getStones() == 12);
	}
	
	@Test
	public void passStonesThroughOwnKalahaTest() {
		Cup startingcup = new Pitt(null, 0);
		System.out.println(" ");
		startingcup.setStones(7);
		startingcup.getNextCup().passStones(7);
		System.out.println(" ");
		
		assertTrue("passing stones does not add one to last cup receiving", startingcup.getNextCup(7).getStones() == 5);
		assertTrue("Kalaha did not receive a stone", startingcup.getNextCup(6).getStones() == 1);
	}

	@Test
	public void passStonesthroughOpponentKalahaTest() {
		Cup startingcup = new Pitt(null, 0);
		startingcup.getNextCup(4).setStones(10);
		((Pitt) startingcup.getNextCup(4)).giveAwayStones();

		assertTrue("passing stones goes on a step too far", startingcup.getNextCup(2).getStones() == 4);
		assertTrue("Opponent Kalaha received a stone", startingcup.getNextCup((13)).getStones() == 0);
	}
	
}
	

