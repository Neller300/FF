//Skrevet af Niels Erik og Patrick
package persistens;

public class LåneformularTabel implements HasAutoKey{
private int formularId;
private int udbetaling;
private int lånLængde;
private int bilId;
private int tlfNr;
private int sælgerId;
private int lånBeløb;

public LåneformularTabel(int formularId, int udbetaling, int lånlængde, int lånbeløb, int bilId, int tlfNr, int sælgerId) {
	this.formularId=formularId;
	this.udbetaling=udbetaling;
	this.lånLængde=lånlængde;
	this.lånBeløb=lånbeløb;
	this.bilId=bilId;
	this.tlfNr=tlfNr;
	this.sælgerId=sælgerId;
}

public LåneformularTabel() {
	
}

@Override
public void setAutoKey(int key) {
  this.formularId = key;
}

public int getFormularId() {
	return formularId;
}

public int getUdbetaling() {
	return udbetaling;
}

public int getLånLængde() {
	return lånLængde;
}

public int getBilId() {
	return bilId;
}

public int getTlfNr() {
	return tlfNr;
}

public int getSælgerId() { 
	return sælgerId;
}

public int getLånBeløb() {
	return lånBeløb;
}

public void setFormularId(int formularId) {
	this.formularId = formularId;
}

public void setUdbetaling(int udbetaling) {
	this.udbetaling = udbetaling;
}

public void setLånLængde(int lånLængde) {
	this.lånLængde = lånLængde;
}

public void setBilId(int bilId) {
	this.bilId = bilId;
}

public void setTlfNr(int tlfNr) {
	this.tlfNr = tlfNr;
}

public void setSælgerId(int sælgerId) {
	this.sælgerId = sælgerId;
}

public void setLånBeløb(int lånBeløb) {
	this.lånBeløb = lånBeløb;
}

@Override
public String toString() {
	return "[Låneformular: FormularId=" + formularId + 
		   ", Udbetaling=" + udbetaling + 
		   ", Lånlængde=" + lånLængde + 
		   ", Bilid=" + bilId + 
		   ", TlfNr=" + tlfNr + 
		   ", Sælgerid=" + sælgerId + "]";
}
}
