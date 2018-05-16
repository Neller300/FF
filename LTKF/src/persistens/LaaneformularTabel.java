package persistens;

public class LaaneformularTabel implements HasAutoKey{
private int formularId;
private int udbetaling;
private int lånLængde;
private int bilId;
private int tlfNr;
private int sælgerId;

public LaaneformularTabel(int formularId, int udbetaling, int laanlaengde, int bilId, int tlfNr, int saelgerId) {
	this.formularId=formularId;
	this.udbetaling=udbetaling;
	this.lånLængde=laanlaengde;
	this.bilId=bilId;
	this.tlfNr=tlfNr;
	this.sælgerId=saelgerId;
}

@Override
public void setAutoKey(int key) {
  this.tlfNr = key;
}
}
