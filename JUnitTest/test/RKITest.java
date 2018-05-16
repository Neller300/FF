package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

class RKITest {

	@Test
	void testRatingA() {
		assertEquals(Rating.A, CreditRator.i().rate( "0000000000"));
		
	}
	
	@Test
	void testRatingB(){
		assertEquals(Rating.B, CreditRator.i().rate( "0000000001"));
	}
	
	@Test
	void testRatingC(){
		assertEquals(Rating.C, CreditRator.i().rate( "0000000002"));
	}
	
	@Test
	void testRatingD(){
		assertEquals(Rating.D, CreditRator.i().rate( "0000000003"));
	}

}
