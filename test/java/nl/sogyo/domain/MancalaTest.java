package nl.sogyo.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import nl.sogyo.domain.Cup;
import nl.sogyo.domain.Kalaha;
import nl.sogyo.domain.Pitt;

@RunWith(Suite.class)
@SuiteClasses({ CupTest.class, KalahaTest.class, PittTest.class, PlayerTest.class})

public class MancalaTest {


	@Test
	public void gameInitializationTest() {
		
		Cup startingcup = new Pitt(null, 0);

		assertTrue("Kalaha's are in the wrong place", startingcup.getNextCup(6) instanceof Kalaha  &&  startingcup.getNextCup(13) instanceof Kalaha);
		assertNotSame("players initialization failed " , startingcup.getOwner(), startingcup.getNextCup(6).getOwner());
		assertEquals("first and last cup are not correctly connected", startingcup, startingcup.getNextCup(14));

	}
	
}
