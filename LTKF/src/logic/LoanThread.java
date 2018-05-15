package logic;

import com.ferrari.finances.dk.bank.InterestRate;
import com.ferrari.finances.dk.rki.CreditRator;
import com.ferrari.finances.dk.rki.Rating;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import persistens.BankData;

public class LoanThread extends Thread {

	private String CPR;
	private Rating kredit;
	private double rente;
	private TextField renteField;
	private double voresRente;

	public LoanThread(BankData data, TextField renteField) {
		CPR = data.getCPR();
		kredit = data.getRating();
		rente = data.getRente();
		this.renteField = renteField;

	}

	@Override
	public void run() {
		try {
			if (CPR.length()  == 10) {
				kredit = CreditRator.i().rate(CPR);
			}

			else {
				throw new NumberFormatException();

			}

		} catch (NumberFormatException e) {
			System.out.println("CPR har ikke  den rigtige format, der er kun: " + CPR.length()
					+ " tal i dette CPR nummer, der kræves 10 tal.");
		}

		

		/*
		 * Vi arbejder kun med kunder, der har kreditværdighed A, B eller C, og som ikke
		 * tidligere har forvoldt problemer.  Som udgangspunkt benyttes bankens
		 * rentesats plus et tillæg, der fastsættes ud fra kundens kreditværdighed: o
		 * Hvis kundens kreditværdighed er A, bruges bankens rentesats +1 procentpoint.
		 * o Hvis kundens kreditværdighed er B, bruges bankens rentesats +2
		 * procentpoint. o Hvis kundens kreditværdighed er C, bruges bankens rentesats
		 * +3 procentpoint.  Hvis udbetalingen er under 50 % tillægges +1 procentpoint.
		 *  Hvis tilbagebetalingen planlægges over mere end 3 år tillægges + 1 procentpoint.
		 */
		rente = InterestRate.i().todaysRate();
		
		if(kredit==Rating.A)
			rente = rente + 1;
		
		if(kredit==Rating.B)
			rente = rente + 2;
		
		if(kredit==Rating.C)
			rente = rente + 3;
		
		if(kredit==Rating.D)
			try {
				throw new Exception("Kundens kredit værdi er for lav");
			} catch (Exception e) {
				
			}
		
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				renteField.setText(String.valueOf(rente));
			}
		});

	}

}
