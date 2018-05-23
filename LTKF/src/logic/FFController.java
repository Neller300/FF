package logic;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import persistens.BankData;
import persistens.BilTabel;
import persistens.Datalag;
import persistens.KundeTabel;

public class FFController {
	
	KundeTabel kunde;
	
		
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
	
	public void getRente(TextField tlf, TextField rente) {
		KundeTabel kunde = Datalag.i().findKunde(Integer.parseInt(tlf.getText()));
		BankData data = new BankData(kunde.getCprNr(), 0, null);
		LoanThread t = new LoanThread(data, rente);
		t.start();
	}
	
	public String getByen(int tlfNr) {
		 return Datalag.i().getByen(tlfNr);		
	}
	
	public String getBilPris(ComboBox<BilTabel> biltype3) {
		try {
			System.out.println();
		 return Datalag.i().getBilPris(biltype3.getSelectionModel().getSelectedIndex());
		}
		catch(ArrayIndexOutOfBoundsException | NullPointerException e) {
			return null; 
		}
	}
	
	public ObservableList<BilTabel> getAlleBiler(){
		return Datalag.i().getAlleBiler();
	}

}
