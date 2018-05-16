package logic;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import persistens.BankData;

public class LoanThread extends Thread {

	private String CPR;
	private Rating kredit;
	private double rente;
	private TextField renteField;
	private double voresRente;
	private String fejlBesked;

	
	//Laver referencer
	public LoanThread(BankData data, TextField renteField) {
		CPR = data.getCPR();
		kredit = data.getRating();
		rente = data.getRente();
		this.renteField = renteField;

	}

	//Starter tråden
	@Override
	public void run() {
		try {
			if (CPR.length()  == 10) {
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
				
		/*
		Hvis udbetaling er mindre end 50% af bilens pris og tilbage betalings periode er over 36 mdr
		if(Låneformular.udbetaling < (BilTabel.pris * 0.5) && Låneformular.lån_længde > 36){
		 	if(kredit==Rating.A)
				voresRente = rente + 3;
			
			if(kredit==Rating.B)
				voresRente = rente + 4;
				
			if(kredit==Rating.C)
				voresRente = rente + 5;
				
			if(kredit==Rating.D)
				try {
				throw new Exception("Kundens kredit værdi er for lav");
			} catch (Exception e) {
				
			}				
				
		//hvis tilbagebetalings perioden er mere end 36 mdr eller hvis udbetalingen er mindre end 50% af bilens pris.
		if(Låneformular.lån_længde > 36 || Låneformular.udbetaling < (Bil.pris * 0.5)){
			if(kredit==Rating.A)
				voresRente = rente + 2;
			
			if(kredit==Rating.B)
				voresRente = rente + 3;
				
			if(kredit==Rating.C)
				voresRente = rente + 4;
			
			if(kredit==Rating.D)
				try {
				throw new Exception("Kundens kredit værdi er for lav");
			} catch (Exception e) {
				
			}
			
		
		*/
		
		//Hvis bilens udbetaling er over 50% og tilbagebetalings perioden er mindre end 36 mdr.
		if(kredit==Rating.A)
			voresRente = rente + 1;
		
		if(kredit==Rating.B)
			voresRente = rente + 2;
		
		if(kredit==Rating.C)
			voresRente = rente + 3;
		
		if(kredit==Rating.D)
			fejlBesked = "Kundens kredit er for lav";
			try {
				throw new Exception("Kundens kredit værdi er for lav");
			} catch (Exception e) {
				
			}
		
		//Kører på GUI Tråd, så den er tilladt til at opdatere GUI.
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				if(kredit==Rating.A || kredit==Rating.B || kredit==Rating.C)
				renteField.setText(String.valueOf(voresRente));
				
				else {
					renteField.setText(fejlBesked);
				}
			}
		});

	}

}
