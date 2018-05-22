package logic;

import javafx.collections.ObservableList;
import javafx.scene.control.TextField;
import persistens.BankData;
import persistens.Datalag;
import persistens.KundeTabel;

public class FFController {
		
	public FFController() {
		Datalag.i().openConnection();
	}
	
	public KundeTabel getKunde(int tlfNr) {
		KundeTabel kunde = Datalag.i().findKunde(tlfNr);
		if(kunde.getNavn() == null) {
			System.out.println("Kunden eksistere ikke i databasen");
			return null;
		}
		else
		return kunde;
		
	}
	
	public void getRente(TextField cpr, TextField rente) {
		BankData data = new BankData(cpr.getText(), 0, null);
		LoanThread t = new LoanThread(data, rente);
		t.start();
	}
	
	public String getByen(int tlfNr) {
		 return Datalag.i().getByen(tlfNr);		
	}
	
	public ObservableList<String> getAlleBiler(){
		return Datalag.i().getAlleBiler();
	}

}
