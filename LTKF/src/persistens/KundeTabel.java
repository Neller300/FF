package persistens;

public class KundeTabel implements HasAutoKey {
	private int tlfNr;
	private String navn;
	private String efternavn;
	private String cprNr;
	private String adresse;
	private int postnummer;
	private String email;

	public KundeTabel(int tlfNr, String navn, String efternavn, String cprNr, String adresse, int postnummer,
			String email) {
		this.tlfNr = tlfNr;
		this.navn = navn;
		this.efternavn = efternavn;
		this.cprNr = cprNr;
		this.adresse = adresse;
		this.postnummer = postnummer;
		this.email = email;
	}
	
	public KundeTabel() {
		
	}

	public void setTlfNr(int tlfNr) {
		this.tlfNr = tlfNr;
	}

	public void setNavn(String navn) {
		this.navn = navn;
	}

	public void setEfternavn(String efternavn) {
		this.efternavn = efternavn;
	}

	public void setCprNr(String cprNr) {
		this.cprNr = cprNr;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public void setPostnummer(int postnummer) {
		this.postnummer = postnummer;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public void setAutoKey(int key) {
		this.tlfNr = key;
	}

	public int getTlfNr() {
		return tlfNr;
	}

	public String getNavn() {
		return navn;
	}

	public String getEfternavn() {
		return efternavn;
	}
	
	public String getCprNr() {
		return cprNr;
	}

	public String getAdresse() {
		return adresse;
	}


	public int getPostNummer() {
		return postnummer;
	}

	public String getEmail() {
		return email;
	}
	
	@Override
	public String toString() {
		return "[Kunde: TlfNr=" + tlfNr + 
			   ", Navn=" + navn + 
			   ", Efternavn=" + efternavn + 
			   ", cpr_nr=" + cprNr +
			   ", Adresse=" + adresse +  
			   ", Postnummer=" + postnummer + 
			   ", Email=" + email + "]";
	}
}
