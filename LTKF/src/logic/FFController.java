//Skrevet af Niels Erik og Patrick
package logic;

import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import persistens.BankData;
import persistens.BilTabel;
import persistens.Datalag;
import persistens.KundeTabel;
import persistens.LåneformularTabel;

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
	
	public void getRente(TextField tlf, TextField rente) {
		KundeTabel kunde = Datalag.i().findKunde(Integer.parseInt(tlf.getText()));
		BankData data = new BankData(kunde.getCprNr(), 0, null);
		LoanThread t = new LoanThread(data, rente, tlf);
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
	
	public void opretKunde(int tlfNr, String navn, String efternavn, String cprNr, String adresse, int postnummer, String email) {
		Datalag.i().opretKunde(tlfNr, navn, efternavn, cprNr, adresse, postnummer, email);
	}
	
	public void opretLåneformular(int udbetaling, int længde, double lånbeløb, int bilid, int tlf, int sælger ) {
		Datalag.i().opretLåneformular(udbetaling, længde, lånbeløb, bilid, tlf, sælger);
		
	}
	
	public LåneformularTabel getFormular(int tlf) {
		return Datalag.i().getLåneformular(tlf);
	}
	
	public double udregnMånedligRente(double rente) {
		UdarbejdTilbud t = new UdarbejdTilbud();
		return t.udregnMånedligRente(rente);
	}
	
	public double udregnAfdrag(double bilPris, double måndeligRente, int antalMåneder) {
		UdarbejdTilbud t = new UdarbejdTilbud();
		return t.udregnAfdrag(bilPris, måndeligRente, antalMåneder);
	}
	
	public String bilNavnFraLåneFormular(int bilId) {
		return Datalag.i().bilNavnFraLåneFormular(bilId);
	}
	
	public double bilPrisFraLåneFormular(int tlf) {
		return Datalag.i().bilPrisFraLåneFormular(tlf);
	}

}
