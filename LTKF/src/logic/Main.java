package logic;

import com.ferrari.finances.dk.bank.*;


public class Main {

	public static void main(String[] args) {
		
		

		String cpr = new String("071095151");
		KundeKredit kunde = new KundeKredit(cpr);
		Thread kredit = new Thread(kunde);
		
		try {
			if (cpr.length() == 10) {
				kredit.start();
			} else {
				throw new NumberFormatException();
			}

		} catch (NumberFormatException e) {
			System.out.println("CPR har ikke  den rigtige format, der er kun: " + cpr.length()
					+ " tal i dette CPR nummer, der kræves 10 tal.");
		}
	}

}
