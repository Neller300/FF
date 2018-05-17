package persistens;

import java.sql.*;
import java.util.ArrayList;
import persistens.*;

public class Datalag {
	private Connection connection;
	private String navn;
	private String efternavn;
	private String adresse;
	private int postnummer;

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
			if(connection != null) 
				System.out.println("Forbindelse til database er oprettet");
			else 
				System.out.println("Database blev ikke fundet");
			
			
		} catch (SQLException e) {

			System.out.println("Kunne ikke oprette forbindelse til database");
			System.exit(1);
		}
	}
	
	public String getEfternavn(int tlfNr) {
		try {
		String kk = "SELECT efternavn FROM kunde WHERE tlf_nr=" + tlfNr + ";";
		System.out.println(kk);
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(kk);
		
		
		
		if(resultSet.next()) {
			efternavn = resultSet.getString("efternavn");
			statement.close();
			return efternavn;
			
		}
			
		else 
			return null;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	public String getNavn(int tlfNr) {
		try {
		String k = "SELECT navn FROM kunde WHERE tlf_nr=" + tlfNr + ";";
		System.out.println(k);
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(k);
		
		
		
		if(resultSet.next()) {
			navn = resultSet.getString("navn");
			statement.close();
			return navn;
			
		}
			
		else 
			return null;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public String getCpr(int tlfNr) {
		try {
		String k = "SELECT cpr_nr FROM kunde WHERE tlf_nr=" + tlfNr + ";";
		System.out.println(k);
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(k);
		
		
		
		if(resultSet.next()) {
			navn = resultSet.getString("cpr_nr");
			statement.close();
			return navn;
			
		}
			
		else 
			return null;
		}
		catch(SQLException e) {
			return null;
		}
	}
	public String getAdresse(int tlfNr) {
		try {
		String k = "SELECT adresse FROM kunde WHERE tlf_nr=" + tlfNr + ";";
		System.out.println(k);
		
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(k);
		
		
		
		if(resultSet.next()) {
			navn = resultSet.getString("adresse");
			statement.close();
			return navn;
			
		}
			
		else 
			return null;
		}
		catch(SQLException e) {
			return null;
		}
	}
	
	
	
	
	
}
