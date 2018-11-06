package nl.sogyo.domain;
import static org.junit.Assert.*;
import org.junit.Test;
import nl.sogyo.domain.Cup;
import nl.sogyo.domain.Pitt;

public class PlayerTest {
	
	@Test
	public void swithTurnTest() {	
		
		Cup startingcup = new Pitt(null, 0);
		
		boolean pl1Before = startingcup.getOwner().getHasTurn();
		boolean pl2Before = startingcup.getNextCup(9).getOwner().getHasTurn();
		startingcup.getOwner().switchTurns(0);
		boolean pl1After = startingcup.getOwner().getHasTurn();
		boolean pl2After = startingcup.getNextCup(9).getOwner().getHasTurn();
		
		assertSame("switch turn does not work", pl1Before , pl2After);
		assertSame("switch turn does not work", pl2Before , pl1After);
	}
	
	@Test
	public void getPlayerTakingTurnTest() {
		
		Cup startingcup = new Pitt(null, 0);
		
		Player playerTakingTurn = startingcup.getOwner().getPlayerTakingTurn();
		Player playerTakingTurn2 = startingcup.getNextCup(8).getOwner().getPlayerTakingTurn();
		assertTrue("playerTakingTurn is not working properly", playerTakingTurn == startingcup.getOwner() 
				&&  playerTakingTurn2 == startingcup.getOwner());
		
		
	}
	
}
