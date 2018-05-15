package logic;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import persistens.BankData;
import view.MainMenu;

public class LoanThread extends Thread {
	
	private String CPR;
	private Rating kredit;
	private double rente;
	private TextField renteField;
	private double voresRente;
	
	public LoanThread(BankData data, TextField renteField ) {
		CPR = data.getCPR();
		kredit = data.getRating();
		rente = data.getRente();
		this.renteField = renteField;
		
	}
	
	@Override
	public void run() {
		try {
			if (CPR.length() == 10) {
				kredit = CreditRator.i().rate(CPR);
			}
 
			else {
				throw new NumberFormatException();

			}

		} catch (NumberFormatException e) {
			System.out.println("CPR har ikke  den rigtige format, der er kun: " + CPR.length()
					+ " tal i dette CPR nummer, der kræves 10 tal.");
		}
		
		
			rente = InterestRate.i().todaysRate();
			
			
			
			Platform.runLater(new Runnable() {
	            @Override 
	            public void run() {
	               renteField.setText(String.valueOf(rente));
	            }
	        });
			
			
		
	}
	
	
	

}
