//Skrevet af Niels Erik og Jonas
package logic;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

import javafx.application.Platform;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import persistens.BankData;


public class LoanThread extends Thread {

	private String CPR;
	private Rating kredit;
	private double rente;
	private TextField renteField;
	private double voresRente;
	private String fejlBesked;
	private TextField tlfnr;
	

	
	//Laver referencer
	public LoanThread(BankData data, TextField renteField, TextField tlfnr) {  
		CPR = data.getCPR();
		kredit = data.getRating();
		rente = data.getRente();
		this.renteField = renteField;
		this.tlfnr = tlfnr;
	}

	//Starter tråden
	@Override
	public void run() {
		FFController controller = new FFController();
		try {
			if (CPR.length()  == 10) {
				kredit = CreditRator.i().rate(CPR);
			}

			else {
				throw new NumberFormatException();

			}

		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("CPR har den forkerte format");
			alert.setHeaderText(null);
			alert.setContentText("CPR har ikke  den rigtige format, der er kun: " + CPR.length()
			+ " tal i dette CPR nummer, der kræves 10 tal.");

			alert.showAndWait();
			/*
			System.out.println("CPR har ikke  den rigtige format, der er kun: " + CPR.length()
					+ " tal i dette CPR nummer, der kræves 10 tal.");
			*/
		}

		rente = InterestRate.i().todaysRate();
				
		
		if(kredit==Rating.A)
			voresRente = rente + 1;
		
		else if(kredit==Rating.B)
			voresRente = rente + 2;
		
		else if(kredit==Rating.C)
			voresRente = rente + 3;
		
		else if(kredit==Rating.D)
			fejlBesked = "Kundens kredit er for lav";
			try {
				throw new Exception("Kundens kredit værdi er for lav");
			} catch (Exception e) {
				
			}
			
		if(controller.getFormular(Integer.parseInt(tlfnr.getText())).getLånLængde() >36){
			voresRente += 1 ;
		}
			
		
		  if(controller.getFormular(Integer.parseInt(tlfnr.getText())).getUdbetaling() < (controller.bilPrisFraLåneFormular(Integer.parseInt(tlfnr.getText())) * 0.5)){
		  voresRente+= 1;
		  }
		 
			
			
		
		//Kører på GUI Tråd, så den er tilladt til at opdatere GUI.
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
//				DecimalFormat formattere = new DecimalFormat("#.##");
				 
				if(kredit==Rating.A || kredit==Rating.B || kredit==Rating.C)
					renteField.setText(String.valueOf(voresRente));
				
				else {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Information Dialog");
					alert.setHeaderText(null);
					alert.setContentText(fejlBesked);

					alert.showAndWait();
				}
			}
		});

	}

}
