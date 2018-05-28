//Skrevet af Patrick
package persistens;

public class Tilbud implements HasAutoKey {
	private int tilbudId;
	private double rente;
	private boolean godkendt;
	private int formularId;

	public Tilbud(int tilbudId, double rente, boolean godkendt, int formularId) {
		this.tilbudId=tilbudId;
		this.rente=rente;
		this.godkendt=godkendt;
		this.formularId=formularId;

	}
	
	public Tilbud() {
		
	}

	@Override
	public void setAutoKey(int key) {
		this.tilbudId=key;
		
	}

	public int getTilbudId() {
		return tilbudId;
	}

	public void setTilbudId(int tilbudId) {
		this.tilbudId = tilbudId;
	}

	public double getRente() {
		return rente;
	}

	public void setRente(double rente) {
		this.rente = rente;
	}

	public boolean isGodkendt() {
		return godkendt;
	}

	public void setGodkendt(boolean godkendt) {
		this.godkendt = godkendt;
	}

	public int getFormularId() {
		return formularId;
	}

	public void setFormularId(int formularId) {
		this.formularId = formularId;
	}

	
	

}
