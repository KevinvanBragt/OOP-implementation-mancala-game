package nl.sogyo.domain;

import static org.junit.Assert.*;
import org.junit.*;
import nl.sogyo.domain.Cup;
import nl.sogyo.domain.Pitt;

public class PittTest {
	@Test
	public void giveToKalahaTest() {
		Cup startingcup = new Pitt(null, 0);
		startingcup.setStones(7);
		((Pitt) startingcup).giveToKalaha(startingcup.getOwner());
		assertTrue("giveTokalaha fails", startingcup.getNextCup(6).getStones() == 7);
	}

	@Test
	public void giveToKalahaOpponentTest() {
		Cup startingcup = new Pitt(null, 0);
		startingcup.setStones(7);
		((Pitt) startingcup).giveToKalaha(startingcup.getOwner().getOpponent());
		assertTrue("giveTokalahaOther fails", startingcup.getNextCup(13).getStones() == 7);
	}

	@Test
	public void passStonesTest() {
		Cup startingcup = new Pitt(null, 0);
		int x = startingcup.getNextCup(1).getStones();
		startingcup.getNextCup(2).passStones(x);
		assertTrue("passing stones does not add one", startingcup.getNextCup(2).getStones() == 5);
		assertTrue("passing stones does not add one to last cup receiving", startingcup.getNextCup(5).getStones() == 5);
		assertTrue("passing stones goes on a step too far", startingcup.getNextCup((6)).getStones() == 0);
	}

	@Test
	public void stealTest() {
		Pitt startingcup = new Pitt(null, 0);
		((Pitt) startingcup.getNextCup(4)).giveAwayStones();
		((Pitt) startingcup).getOwner().switchTurns(0);
		startingcup.giveAwayStones();

		assertTrue("Kalaha did not receive all stones", startingcup.getNextCup(6).getStones() == 7);
		assertTrue("one of the cups is not cleared properly",
				startingcup.getNextCup(4).getStones() == 0 && startingcup.getNextCup(8).getStones() == 0);
	}


	

}
