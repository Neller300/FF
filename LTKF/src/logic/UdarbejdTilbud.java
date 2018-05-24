//Skrevet af Niels Erik
package logic;

public class UdarbejdTilbud {

	public double udregnMåndeligRente(double rente) {
		return ((Math.pow((1.0 + (rente / 100.0)), (1.0 / 12.0))) - 1) * 100.0;
	}

	public double udregnAfdrag(double bilPris, double måndeligRente, int antalMåneder) {
		return (bilPris * (måndeligRente / 100.0)) / (1 - Math.pow(1 + (måndeligRente / 100.0), -1 * antalMåneder));
	}
	
}
