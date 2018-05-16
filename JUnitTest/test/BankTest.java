package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import com.ferrari.finances.dk.bank.developertools.*;
import com.ferrari.finances.dk.bank.*;


class BankTest {

	@Test
	void testBank() {
		InterestRate interest = InterestRateTestTool.newInterestRateMock(7.0);
		assertEquals(7.0, interest.todaysRate());
	}
	

	
	

}
