package persistens;

public class LaaneformularTabel implements HasAutoKey{
private int formularId;
private int udbetaling;
private int laanLaengde;
private int bilId;
private int tlfNr;
private int saelgerId;

public LaaneformularTabel(int formularId, int udbetaling, int laanlaengde, int bilId, int tlfNr, int saelgerId) {
	this.formularId=formularId;
	this.udbetaling=udbetaling;
	this.laanLaengde=laanlaengde;
	this.bilId=bilId;
	this.tlfNr=tlfNr;
	this.saelgerId=saelgerId;
}

@Override
public void setAutoKey(int key) {
  this.tlfNr = key;
}
}
