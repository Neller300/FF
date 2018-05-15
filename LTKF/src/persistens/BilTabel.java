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

}
