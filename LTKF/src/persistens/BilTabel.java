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

public String toString() {
	return "[Bil: BilId=" + bilId + 
		   ", Bilnavn=" + bilNavn + 
		   ", Bilpris=" + bilPris + "]";
}
}
