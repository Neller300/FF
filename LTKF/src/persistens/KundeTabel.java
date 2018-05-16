package persistens;

public class KundeTabel implements HasAutoKey {
	private int tlfNr;
	private String navn;
	private String efternavn;
	private String addresse;
	private String byen;
	private int postnummer;
	private String email;

	public KundeTabel(int tlfNr, String navn, String efternavn, String addresse, String byen, int postnummer,
			String email) {
		this.tlfNr = tlfNr;
		this.navn = navn;
		this.efternavn = efternavn;
		this.addresse = addresse;
		this.byen = byen;
		this.postnummer = postnummer;
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

	public String getAddresse() {
		return addresse;
	}

	public String getByen() {
		return byen;
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
			   ", Addresse=" + addresse + 
			   ", By=" + byen + 
			   ", Postnummer=" + postnummer + 
			   ", Email=" + email + "]";
	}
}
