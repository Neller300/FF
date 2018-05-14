package logic;

import com.ferrari.finances.dk.rki.*;

public class KundeKredit implements Runnable {
	private String CPR;

	@Override
	public void run() {
		try {
			if (CPR.length() == 10) {
				System.out.println(CreditRator.i().rate(CPR));
			}
 
			else {
				throw new NumberFormatException();

			}

		} catch (NumberFormatException e) {
			System.out.println("CPR har ikke  den rigtige format, der er kun: " + CPR.length()
					+ " tal i dette CPR nummer, der kræves 10 tal.");
		}
	}

	public KundeKredit(String CPR) {
		this.CPR = CPR;
	}

}
