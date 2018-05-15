package logic;

public class Tilbud {
	private String Navn;
	private String Efternavn;
	private String Addresse;
	private int tlf;
	private String CPR;
	private String By;
	private double VoresRente;

	public Tilbud(String Navn, String Efternavn, String Addresse, int tlf, String CPR, String By, double VoresRente ) {
		this.Navn = Navn;
		this.Efternavn = Efternavn;
		this.Addresse = Addresse;
		this.tlf = tlf;
		this.CPR = CPR;
		this.By = By;
		this.VoresRente = VoresRente;
		

	}

	public String getNavn() {
		return Navn;
	}

	public void setNavn(String navn) {
		Navn = navn;
	}

	public String getEfternavn() {
		return Efternavn;
	}

	public void setEfternavn(String efternavn) {
		Efternavn = efternavn;
	}

	public String getAddresse() {
		return Addresse;
	}

	public void setAddresse(String addresse) {
		Addresse = addresse;
	}

	public int getTlf() {
		return tlf;
	}

	public void setTlf(int tlf) {
		this.tlf = tlf;
	}

	public String getCPR() {
		return CPR;
	}

	public void setCPR(String cPR) {
		CPR = cPR;
	}

	public String getBy() {
		return By;
	}

	public void setBy(String by) {
		By = by;
	}
	
	public double getVoresRente() {
		return VoresRente;
	}


	public void setVoresRente(double voresRente) {
		VoresRente = voresRente;
	}

}
