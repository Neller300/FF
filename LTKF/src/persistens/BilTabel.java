package persistens;

public class BilTabel implements HasAutoKey {
private int bilId;
private String bilNavn;
private int bilPris;

public BilTabel(int bilId, String bilNavn, int bilPris) {
	this.bilId=bilId;
	this.bilNavn=bilNavn;
	this.bilPris=bilPris; 
}

public BilTabel() {
	
}

@Override
public void setAutoKey(int key) {
  this.bilId = key;
}

public int getBilId() {
	return bilId;
}

public String getBilNavn() {
	return bilNavn;
}

public int getBilPris() {
	return bilPris;
}

@Override
public String toString() {
	return "[Bil: BilId=" + bilId + 
		   ", Bilnavn=" + bilNavn + 
		   ", Bilpris=" + bilPris + "]";
}

public void setBilId(int bilId) {
	this.bilId = bilId;
}

public void setBilNavn(String bilNavn) {
	this.bilNavn = bilNavn;
}

public void setBilPris(int bilPris) {
	this.bilPris = bilPris;
}
}
