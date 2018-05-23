package persistens;

public class BilTabel implements HasAutoKey {
private int bilId;
private String bilNavn;
private String bilPris;

public BilTabel(int bilId, String bilNavn, String bilPris) {
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

public String getBilPris() {
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

public void setBilPris(String bilPris2) {
	this.bilPris = bilPris2;
}
}
