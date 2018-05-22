package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.ferrari.finances.dk.rki.Rating;

import javafx.scene.control.TextField;
import logic.LoanThread;
import persistens.BankData;

class LoanThreadTest {
	private TextField textTest;
	private String CPR;
	
	

	@Test
	void testLoanThreadRatingA() {
		CPR = "0000000000";
		BankData test = new BankData(CPR, 0, null);
		test.setCPR("0000000000");
		test.setKredit(Rating.A);
		test.setRente(5);
		LoanThread t = new LoanThread(test, textTest);
		t.start();
		
		while(true)
		if(!textTest.getText().isEmpty()) {
			assertEquals(5, Double.parseDouble(textTest.getText()) );
			break;
		}
		
		
	}

}
