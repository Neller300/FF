package persistens;

public class L�neformularTabel implements HasAutoKey{
private int formularId;
private int udbetaling;
private int l�nL�ngde;
private int bilId;
private int tlfNr;
private int s�lgerId;

public L�neformularTabel(int formularId, int udbetaling, int l�nl�ngde, int bilId, int tlfNr, int s�lgerId) {
	this.formularId=formularId;
	this.udbetaling=udbetaling;
	this.l�nL�ngde=l�nl�ngde;
	this.bilId=bilId;
	this.tlfNr=tlfNr;
	this.s�lgerId=s�lgerId;
}

@Override
public void setAutoKey(int key) {
  this.tlfNr = key;
}
}
