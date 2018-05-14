package logic;


public class Main {

	public static void main(String[] args) {

		String cpr = new String("0710951551");
		KundeKredit kunde = new KundeKredit(cpr);
		BankRente rente = new BankRente();
		Thread kredit = new Thread(kunde);
		Thread bank = new Thread(rente);
		kredit.start();
		bank.start();
		
		

	}
}
