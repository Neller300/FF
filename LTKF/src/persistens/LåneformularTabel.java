package persistens;

public class LåneformularTabel implements HasAutoKey{
private int formularId;
private int udbetaling;
private int lånLængde;
private int bilId;
private int tlfNr;
private int sælgerId;

public LåneformularTabel(int formularId, int udbetaling, int lånlængde, int bilId, int tlfNr, int sælgerId) {
	this.formularId=formularId;
	this.udbetaling=udbetaling;
	this.lånLængde=lånlængde;
	this.bilId=bilId;
	this.tlfNr=tlfNr;
	this.sælgerId=sælgerId;
}

@Override
public void setAutoKey(int key) {
  this.tlfNr = key;
}
}
