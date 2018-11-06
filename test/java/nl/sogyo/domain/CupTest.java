package nl.sogyo.domain;

import static org.junit.Assert.*;


import org.junit.Test;

import nl.sogyo.domain.Cup;
import nl.sogyo.domain.Pitt;

public class CupTest {

	
	@Test
	public void basicFuntionalityTest() {
		
		Cup startingcup = new Pitt(null, 0);
			
		Cup nonParameter = startingcup.getNextCup(3);
		Cup withParameter = startingcup.getNextCup().getNextCup().getNextCup();
		assertSame("getNextCup(int x) fails", nonParameter, withParameter);
		
	
		
	}
	


	
	
}
