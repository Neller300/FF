package persistens;

public class LaaneformularTabel implements HasAutoKey{
private int formularId;
private int udbetaling;
private int l�nL�ngde;
private int bilId;
private int tlfNr;
private int s�lgerId;

public LaaneformularTabel(int formularId, int udbetaling, int laanlaengde, int bilId, int tlfNr, int saelgerId) {
	this.formularId=formularId;
	this.udbetaling=udbetaling;
	this.l�nL�ngde=laanlaengde;
	this.bilId=bilId;
	this.tlfNr=tlfNr;
	this.s�lgerId=saelgerId;
}

@Override
public void setAutoKey(int key) {
  this.tlfNr = key;
}
}
