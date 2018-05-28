//Skrevet af Niels Erik og Patrick
package persistens;

import java.sql.*;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;


public class Datalag {
	private Connection connection;
	private static Datalag inst = null;

	public static Datalag i() {
		if (inst == null)
			inst = new Datalag();

		return inst;

	}

	public void openConnection() {
		try {
			System.out.println("Loading JDBC Driver...");

			// DriverManager.registerDriver(new
			// com.microsoft.sqlserver.jdbc.SQLServerDriver());

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

			System.out.println("JDBC Driver loaded");
		} catch (ClassNotFoundException e) {
			System.out.println("Failed to load JDBC Driver!");

			// e.printStackTrace();

			// if loading driver failed, then it is no use to continue program => terminate
			System.exit(1);
		}

		// String databaseName = "master";
		String databaseName = "FerraiFinansesDB";

		String connectionString = "jdbc:sqlserver://localhost:1433;" + "instanceName=SQLEXPRESS;" + "databaseName="
				+ databaseName + ";" + "integratedSecurity=true;";

		try {
			connection = DriverManager.getConnection(connectionString);
			if (connection != null)
				System.out.println("Forbindelse til database er oprettet");
			else
				System.out.println("Database blev ikke fundet");

		} catch (SQLException e) {

			System.out.println("Kunne ikke oprette forbindelse til database");
			System.exit(1);
		}
	}

	public ObservableList<BilTabel> getAlleBiler() {
		ArrayList<BilTabel> biler = new ArrayList<BilTabel>();

		try {
			String kk = "SELECT * FROM bil;";
			System.out.println(kk);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(kk);
			ObservableList<BilTabel> observableBil = null;

			while (resultSet.next()) {
				BilTabel bil = new BilTabel();
				int bilid = resultSet.getInt("bil_id");
				String bilnavn = resultSet.getString("bil_navn");
				String bilPris = resultSet.getString("bil_pris");
				bil.setBilId(bilid);
				bil.setBilNavn(bilnavn);
				bil.setBilPris(bilPris);
				biler.add(bil);
				observableBil = FXCollections.observableArrayList(biler);

			}
			return observableBil;
		} catch (SQLException e) {
			return null;
		}

	}

	public int getTlfnr(int tlfNr) {
		try {
			String kk = "SELECT tlf_nr FROM kunde WHERE tlf_nr=" + tlfNr + ";";
			System.out.println(kk);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(kk);

			if (resultSet.next()) {
				int tlfnr = resultSet.getInt("tlf_nr");
				statement.close();
				return tlfnr;

			}

			else
				return 0;
		} catch (SQLException e) {
			return 0;
		}
	}

	public KundeTabel findKunde(int tlfNr) {
		KundeTabel kunde = new KundeTabel();
		try {
			String kk = "SELECT * FROM kunde WHERE tlf_nr=" + tlfNr + ";";
			System.out.println(kk);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(kk);

			if (resultSet.next()) {
				int tlfnr = resultSet.getInt("tlf_nr");
				String navn = resultSet.getString("navn");
				String efternavn = resultSet.getString("efternavn");
				String cpr = resultSet.getString("cpr_nr");
				String adresse = resultSet.getString("adresse");
				int postnr = resultSet.getInt("post_nummer");
				String email = resultSet.getString("email");

				kunde.setTlfNr(tlfnr);
				kunde.setNavn(navn);
				kunde.setEfternavn(efternavn);
				kunde.setCprNr(cpr);
				kunde.setAdresse(adresse);
				kunde.setPostnummer(postnr);
				kunde.setEmail(email);

				System.out.println(kunde);
				return kunde;

			}

			else
			kunde.setTlfNr(0);
			kunde.setNavn("");
			kunde.setEfternavn("");
			kunde.setCprNr("");
			kunde.setAdresse("");
			kunde.setPostnummer(0);
			kunde.setEmail("");
				return kunde;
		} catch (SQLException e) {
			return null;
		}
	}

	public String getByen(int tlfNr) {
		try {
			String k = "SELECT byen FROM postnummer JOIN kunde ON postnummer.nr=kunde.post_nummer WHERE tlf_nr=" + tlfNr
					+ ";";
			System.out.println(k);

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(k);

			if (resultSet.next()) {
				String byen = resultSet.getString("byen");
				statement.close();
				return byen;

			}

			else
				return null;
		} catch (SQLException e) {
			return null;
		}
	}

	public String getBilPris(int index) {
		ArrayList<String> finalBilPris = new ArrayList<String>();
		try {
			String k = "SELECT bil_pris FROM bil;";
			System.out.println(k);
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(k);
			
			
			while(resultSet.next()) {
				String bilPris = resultSet.getString("bil_pris");
				statement.close();
				finalBilPris.add(bilPris);
				return finalBilPris.get(index); 
				
			}
			return null;	
			
			}
			catch(SQLException e) {
				return null;
			}
	}

	public void opretKunde(int tlfNr, String navn, String efternavn, String cprNr, String adresse, int postnummer, String email) {
		try {
			String k = "INSERT INTO kunde VALUES(" + tlfNr + ",'" + navn + "', '" + efternavn + "', '" + cprNr + "', '" + adresse + "', " + postnummer + ", '" + email + "');";
			
			Statement statement = connection.createStatement();
			statement.executeUpdate(k);
			
		}
		catch(SQLException e) {
			
		}
		
	}
	
	public void opretLåneformular(int udbetaling, int længde, double lånbeløb, int bilid, int tlf, int sælger) {
		try {
			String k = "INSERT INTO låneformular VALUES(" + udbetaling + "," 
														  + længde + "," 
														  + lånbeløb + ","													  
														  + bilid + "," 
														  + tlf + "," 
														  + sælger 
														  + ");";  
			Statement statement = connection.createStatement();
			statement.executeUpdate(k);
			System.out.println(k);
		}
		catch(SQLException e) {
			
		}
	}
	
	public String bilNavnFraLåneFormular(int bilId) {
		try {
			String k = "SELECT bil_navn FROM bil JOIN låneformular ON bil.bil_id=låneformular.bil_id WHERE låneformular.bil_id=" + bilId + ";";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(k);
			
			if(resultSet.next()) {
				String bilNavn = resultSet.getString("bil_navn");
				return bilNavn;
			}}
			catch(SQLException e) {
				
			}
		return null;
		
	}
	
	public double bilPrisFraLåneFormular(int tlf) {
		try {
			String k = "SELECT bil_pris FROM bil JOIN låneformular ON bil.bil_id=låneformular.bil_id WHERE låneformular.tlf_nr=" + tlf + ";";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(k);
			
			if(resultSet.next()) {
				double bilPris = resultSet.getDouble("bil_pris");
				return bilPris;
			}}
			catch(SQLException e) {
				
			}
		return 0;
		
	}
	
	public LåneformularTabel getLåneformular(int tlf) {
		LåneformularTabel låneformular = new LåneformularTabel();
		try {
			String k = "SELECT * FROM låneformular WHERE tlf_nr = " + tlf + ";";
			System.out.println(k);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(k);
			
			if(resultSet.next()) {
				int formularId = resultSet.getInt("formular_id");
				int udbetaling = resultSet.getInt("udbetaling");
				int lånLængde = resultSet.getInt("lån_længde");
				int lånBeløb = resultSet.getInt("lån_beløb");
				int bilId = resultSet.getInt("bil_id");
				int tlfNr = resultSet.getInt("tlf_nr");
				int sælgerId = resultSet.getInt("sælger_id");
				
				
				låneformular.setFormularId(formularId);
				låneformular.setUdbetaling(udbetaling);
				låneformular.setLånLængde(lånLængde);
				låneformular.setLånBeløb(lånBeløb);
				låneformular.setBilId(bilId);
				låneformular.setTlfNr(tlfNr);
				låneformular.setSælgerId(sælgerId);
				
				
				return låneformular;
			}
			
		}
		
		catch(SQLException e) {
			
		}
		return låneformular;
	}
	
	public void opretTilbud(double rente, boolean godkendt, int formularId) {
		try {
			String k = "INSERT INTO tilbud VALUES(" + rente + "," 
														  + godkendt + "," 
														  + formularId 
														  + ");";  
			Statement statement = connection.createStatement();
			statement.executeUpdate(k);
			System.out.println(k);
		}
		catch(SQLException e) {
			
		}
	}
	
	public int getSalgsGrænseSælger(int id) {
		SælgerTabel sælger = new SælgerTabel();
		try {
			String k = "SELECT * FROM sælger WHERE id=" + id +";";
			
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(k);
			
			if(resultSet.next()) {
				int fastGrænse = resultSet.getInt("fast_grænse");
				
				sælger.setFastGrænse(fastGrænse);
				return sælger.getFastGrænse();
			}
			
		}
		catch(SQLException e) {
			
		}
		return sælger.getFastGrænse();
		
	}
}