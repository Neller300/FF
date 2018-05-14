package logic;

import com.ferrari.finances.dk.bank.*;

public class BankRente implements Runnable {

	@Override
	public void run() {

			System.out.println(InterestRate.i().todaysRate());
	}
}
