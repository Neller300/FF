package persistens;

import com.ferrari.finances.dk.rki.*;

public class BankData {
	
	private String CPR;
	private double rente;
	private Rating kredit;
	
	public BankData(String CPR, double rente, Rating kredit) {
		this.rente = rente;
		this.kredit = kredit;
		this.CPR = CPR;
	}
	
	public void setKredit(Rating kredit ) {
		this.kredit = kredit;
	}
	
	public void setRente(double rente) {
		this.rente = rente;
	}
	
	public double getRente() {
		return rente;
	}
	
	public Rating getRating() {
		return kredit;
	}
	
	public void setCPR(String CPR) {
		this.CPR = CPR;
	}
	
	public String getCPR() {
		return CPR;
	}
	
	
@Override
public String toString() {
	return "Renten idag er: " + getRente() + "og kundeds kredit er: " + kredit  ;
}

}

