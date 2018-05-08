package logic;

import com.ferrari.finances.dk.rki.*;

public class KundeKredit implements Runnable {
	private String CPR;

	@Override
	public void run() {
		System.out.println(CreditRator.i().rate(CPR));
	}

	public KundeKredit(String CPR) {
		this.CPR = CPR;
	}

}
