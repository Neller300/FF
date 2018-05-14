package logic;

import com.ferrari.finances.dk.bank.*;

public class Main {

	public static void main(String[] args) {

		String cpr = new String("0710951551");
		KundeKredit kunde = new KundeKredit(cpr);
		Thread kredit = new Thread(kunde);
		kredit.start();

	}
}
