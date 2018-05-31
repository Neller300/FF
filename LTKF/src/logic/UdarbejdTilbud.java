//Skrevet af Niels Erik
package logic;

public class UdarbejdTilbud {

	public double udregnMånedligRente(double rente) {
		return ((Math.pow((1.0 + (rente / 100.0)), (1.0 / 12.0))) - 1) * 100.0;
	}

	public double udregnAfdrag(double lånBeløb, double månedligRente, int antalMåneder) {
		return (lånBeløb * (månedligRente / 100.0)) / (1 - Math.pow(1 + (månedligRente / 100.0), -1 * antalMåneder));
	}
	
}
