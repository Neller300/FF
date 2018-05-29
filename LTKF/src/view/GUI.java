//Skrevet af Daniel, Patrick, Niels Erik og Jonas
package view;

import java.text.DecimalFormat;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.util.Callback;
import logic.FFController;
import persistens.BilTabel;
import persistens.KundeTabel;



public class GUI extends Application {
	TextField renten2 = new TextField();
	FFController controller;
	
	
	@Override
	public void start(Stage primaryStage) {
		FFController controller = new FFController();
		primaryStage.setTitle("Ferrari");

		// lave et grid
		GridPane grid1 = new GridPane();
		grid1.setPadding(new Insets(20));
		grid1.setHgap(15);
		grid1.setVgap(15);
		// gridp.setGridLinesVisible(true);

		ColumnConstraints column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		grid1.getColumnConstraints().add(column1);

		column1 = new ColumnConstraints();
		column1.setPercentWidth(60);
		grid1.getColumnConstraints().add(column1);

		column1 = new ColumnConstraints();
		column1.setPercentWidth(20);
		grid1.getColumnConstraints().add(column1);

		RowConstraints row = new RowConstraints();
		row.setPercentHeight(25);
		grid1.getRowConstraints().add(row);

		row = new RowConstraints();
		row.setPercentHeight(25);
		grid1.getRowConstraints().add(row);

		row = new RowConstraints();
		row.setPercentHeight(25);
		grid1.getRowConstraints().add(row);

		row = new RowConstraints();
		row.setPercentHeight(25);
		grid1.getRowConstraints().add(row);
		

		Button opretlån = new Button("Opret låneformular");
		opretlån.setStyle("-fx-font: 30 arial;");

		Button lavtilbud = new Button("Udarbejd lånetilbud");
		lavtilbud.setStyle("-fx-font: 30 arial;");

		Button godkendtilbud = new Button("Godkend lånetilbud");
		godkendtilbud.setStyle("-fx-font: 30 arial;");
		
		Button færdigtilbud = new Button("Færdig lånetilbud");
		færdigtilbud.setStyle("-fx-font: 30 arial;");

		grid1.add(opretlån, 1, 0);
		grid1.add(lavtilbud, 1, 1);
		grid1.add(færdigtilbud, 1, 2);
		grid1.add(godkendtilbud, 1, 3);

		// ï¿½ndre knappens max height og width value. og derefter fylder knappen ud i den
		// grid den er i
		opretlån.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		GridPane.setFillWidth(opretlån, true);
		GridPane.setFillHeight(opretlån, true);

		lavtilbud.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		GridPane.setFillWidth(lavtilbud, true);
		GridPane.setFillHeight(lavtilbud, true);

		godkendtilbud.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		GridPane.setFillWidth(godkendtilbud, true);
		GridPane.setFillHeight(godkendtilbud, true);
		
		færdigtilbud.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
		GridPane.setFillWidth(godkendtilbud, true);
		GridPane.setFillHeight(godkendtilbud, true);

		Scene mainmenuscene = new Scene(grid1, 3000, 3000);
		primaryStage.setScene(mainmenuscene);
		primaryStage.show();

		// Tilbuds scene
		// lave et grid
		GridPane grid2 = new GridPane();
		grid2.setPadding(new Insets(20));
		grid2.setHgap(15);
		grid2.setVgap(15);
		// root.setGridLinesVisible(true);

		// styre hver kolones stï¿½rrelse i procent
		ColumnConstraints column2 = new ColumnConstraints();
		column2.setPercentWidth(10);
		grid2.getColumnConstraints().add(column2);

		column2 = new ColumnConstraints();
		column2.setPercentWidth(40);
		grid2.getColumnConstraints().add(column2);

		column2 = new ColumnConstraints();
		column2.setPercentWidth(10);
		grid2.getColumnConstraints().add(column2);

		column2 = new ColumnConstraints();
		column2.setPercentWidth(40);
		grid2.getColumnConstraints().add(column2);

		// lave sine label, buttons, text
		Label labelTitle = new Label("Udarbejd tilbud");
		// Put on cell (0,0), span 2 column, 1 row.
		grid2.add(labelTitle, 0, 0, 2, 1);

		Label tlfnr2 = new Label("Telefon nummer:");
		TextField tlfinput2 = new TextField();
		// cprinput.setMaxWidth(200);

		Label RKI2 = new Label("Info fra RKI:");
		TextArea RKIINFO2 = new TextArea();
		RKIINFO2.setEditable(false);
		RKIINFO2.setMouseTransparent(true);
		// RKIINFO.setPrefRowCount();

		Label bil2 = new Label("Bil");

		TextField biltype2 = new TextField();
		biltype2.setEditable(false);

		Button hentRente2 = new Button("Rente");
		renten2.setEditable(false);
		renten2.setMouseTransparent(true);
		
		Label lånbeløb2 = new Label("Lånebeløb");
		TextField lånbeløbtext2 = new TextField();
		lånbeløbtext2.setEditable(false);
		lånbeløbtext2.setMouseTransparent(true);

		Label ydelse2 = new Label("Første ydelse");
		TextField førsteYde2 = new TextField();
		førsteYde2.setEditable(false);
		førsteYde2.setMouseTransparent(true);

		Label lånLængde2 = new Label("Længde på lån");
		TextField laengdeLaan2 = new TextField();
		laengdeLaan2.setEditable(false);
		
		Label låneInfo2 = new Label("Låne information");
		TextArea lånINFO2 = new TextArea();
		lånINFO2.setEditable(false);
		lånINFO2.setMouseTransparent(true);
		//Sætter info for lånet i textArea.
		
		TextField mdrAfdrag = new TextField();
		mdrAfdrag.setEditable(false);
		
		TextField mdrRente = new TextField();
		mdrRente.setEditable(false);
		
		Label sælger2 = new Label("Sælger:");
		TextField vælgsælger2 = new TextField();
		
		Label labelMdrAfdrag = new Label("Måndelig afdrag:");
		
		Label labelMdrRente = new Label("Måndelig Rente:");
		

		Button back = new Button("Tilbage");
		
		Button tilbage = new Button("Tilbage");
		
		Button tilbage1 = new Button("Tilbage");
		
		Button tilbage2 = new Button("Tilbage");
		
		Button hentKunde = new Button("Hent kunde");
		
		Button hentKunde1 = new Button("Hent kunde");
		
		Button opretTilbud = new Button("Opret Tilbud");


		// biltype.getSelectionModel().selectedItemProperty().addListener( (v, oldvalue,
		// newvalue )-> opdateryde);

		// Sï¿½tte text,buttons, label i et grid
		// cells row, colomn, row, colom
		GridPane.setHalignment(tlfnr2, HPos.LEFT);
		grid2.add(tlfnr2, 0, 1);

		GridPane.setHalignment(tlfinput2, HPos.LEFT);
		grid2.add(tlfinput2, 0, 2);
		
		grid2.add(hentKunde, 1, 2);
		
		grid2.add(hentKunde1, 1, 2);

		GridPane.setHalignment(RKI2, HPos.LEFT);

		grid2.add(RKI2, 0, 3);

		grid2.add(RKIINFO2, 0, 4, 2, 8);

		grid2.add(bil2, 2, 1);

		grid2.add(biltype2, 2, 2);

		grid2.add(hentRente2, 2, 3);

		grid2.add(renten2, 2, 4);
		
		grid2.add(lånbeløb2, 2, 5);
		
		grid2.add(lånbeløbtext2, 2, 6);

		grid2.add(ydelse2, 3, 1);

		grid2.add(førsteYde2, 3, 2);

		grid2.add(lånLængde2, 3, 3);

		grid2.add(laengdeLaan2, 3, 4);
		
		grid2.add(låneInfo2, 2, 7);
		
		grid2.add(labelMdrAfdrag, 2, 8);
		
		grid2.add(labelMdrRente, 3, 8);

		//grid2.add(lånINFO2, 2, 8, 2, 8);

		grid2.add(mdrAfdrag, 2, 9 );
		
		grid2.add(mdrRente, 3, 9);

		grid2.add(sælger2, 0, 12);

		grid2.add(vælgsælger2, 0, 13);

		grid2.add(tilbage2, 0, 14);
		
		grid2.add(opretTilbud, 2, 10);
		
		
		
	

		// sï¿½tter maks 10 tegn
		tlfinput2.setOnKeyTyped(event -> {
			int maxCharacters = 10;
			if (tlfinput2.getText().length() > maxCharacters)
				event.consume();
		});

		// Kun tal
		tlfinput2.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("[0-9]*")) {
				tlfinput2.setText(oldValue);
			}
		});

		Scene tilbudscene = new Scene(grid2, 3000, 3000);

		// lave event handlers der åbner den ønskede nye scene
		lavtilbud.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(tilbudscene);

			}
		});

		// Laaneformular scene
		// lave et grid
		GridPane grid3 = new GridPane();
		grid3.setPadding(new Insets(20));
		grid3.setHgap(15);
		grid3.setVgap(15);
		// gridp.setGridLinesVisible(true);

		// styre hver kolones stï¿½rrelse i procent
		ColumnConstraints column3 = new ColumnConstraints();
		column3.setPercentWidth(30);
		grid3.getColumnConstraints().add(column3);

		column3 = new ColumnConstraints();
		column3.setPercentWidth(10);
		grid3.getColumnConstraints().add(column3);

		column3 = new ColumnConstraints();
		column3.setPercentWidth(30);
		grid3.getColumnConstraints().add(column3);

		column3 = new ColumnConstraints();
		column3.setPercentWidth(30);
		grid3.getColumnConstraints().add(column3);

		Label cpr3 = new Label("CPR-nummer");
		TextField cprtext3 = new TextField();

		Label navn3 = new Label("Navn");
		TextField navntext3 = new TextField();

		Label efternavn3 = new Label("Efternavn");
		TextField efternavntext3 = new TextField();

		Label adresse3 = new Label("Adresse");
		TextField adressetext3 = new TextField();

		Label by3 = new Label("By");
		TextField bytext3 = new TextField();

		Label postnummer3 = new Label("Postnummer");
		TextField postnummertext3 = new TextField();

		Label email3 = new Label("E-mail");
		TextField emailtext3 = new TextField();

		Label tlf3 = new Label("Tlf:");
		TextField tlftext3 = new TextField();

		Label sælger3 = new Label("Sælger");
		TextField sælgertext3 = new TextField();

		Label bil3 = new Label("Bil");

		 //combobox
		final ComboBox<BilTabel> biltype3 = new ComboBox<BilTabel>();
		biltype3.setItems(controller.getAlleBiler());
		biltype3.setPromptText("Vælg bil");

	    final ListCell<BilTabel> customCell = new ListCell<BilTabel>() {
	        @Override
	        protected void updateItem(BilTabel item, boolean empty) {
	            super.updateItem(item, empty);
	            if(item!= null){
                    setText(item.getBilNavn());
                    
                }else{
                    setText(null);
                }
	        }
	    };
	    biltype3.setButtonCell(customCell);
		
		biltype3.setCellFactory(new Callback<ListView<BilTabel>,ListCell<BilTabel>>(){
			 
            @Override
            public ListCell<BilTabel> call(ListView<BilTabel> p) {
                 
                final ListCell<BilTabel> cell = new ListCell<BilTabel>(){
 
                    @Override
                    protected void updateItem(BilTabel t, boolean bln) {
                        super.updateItem(t, bln);
                         
                        if(t != null){
                            setText(t.getBilNavn());
                            
                        }else{
                            setText(null);
                        }
                    }
  
                };
                 
                return cell;
            }
        });

		Label udbetaling3 = new Label("Udbetaling");
		TextField udbetalingtext3 = new TextField();

		Label pris3 = new Label("Pris");
		TextField pristext3 = new TextField();
		
		
		
		Label længdelån3 = new Label("Længde på lån");
		TextField længdelåntext3 = new TextField();

		Label kommentar3 = new Label("Kommentar");
		TextArea kommentartext3 = new TextArea();
		
		TextField lånbeløb = new TextField();
		lånbeløb.setPromptText("Låne beløb");
		lånbeløb.setEditable(false);
		
		Button opret3 = new Button("Opret");

		Button cancel3 = new Button("Ryd alt");
		
		biltype3.getSelectionModel().selectedItemProperty().addListener((Observable, oldValue, newValue) -> {
				pristext3.setText(newValue.getBilPris());
		});

		// cells row, colomn, row, colom
		grid3.add(tlf3, 0, 0);

		grid3.add(tlftext3, 0, 1);

		grid3.add(navn3, 0, 2);

		grid3.add(navntext3, 0, 3);

		grid3.add(efternavn3, 0, 4);

		grid3.add(efternavntext3, 0, 5);

		grid3.add(adresse3, 0, 6);

		grid3.add(adressetext3, 0, 7);

		grid3.add(postnummer3, 0, 8);

		grid3.add(postnummertext3, 0, 9);
		
		grid3.add(by3, 0, 10);

		grid3.add(bytext3, 0, 11);

		grid3.add(email3, 0, 12);

		grid3.add(emailtext3, 0, 13);

		grid3.add(cpr3, 0, 14);

		grid3.add(cprtext3, 0, 15);

		grid3.add(sælger3, 0, 16);

		grid3.add(sælgertext3, 0, 17);

		grid3.add(bil3, 2, 0);

		grid3.add(biltype3, 2, 1);

		grid3.add(udbetaling3, 3, 0);

		grid3.add(udbetalingtext3, 3, 1);

		grid3.add(pris3, 2, 2);

		grid3.add(pristext3, 2, 3);

		grid3.add(længdelån3, 3, 2);

		grid3.add(længdelåntext3, 3, 3);

		grid3.add(kommentar3, 2, 4);
		
		grid3.add(lånbeløb, 3, 4);

		grid3.add(kommentartext3, 2, 6, 3, 6);

		grid3.add(opret3, 2, 12);

		grid3.add(cancel3, 3, 12);

		grid3.add(hentKunde, 1, 1);
		
		grid3.add(tilbage1, 0, 18);
		
		

		// sï¿½tter maks 10 tegn i CPR
		cprtext3.setOnKeyTyped(event -> {
			int maxCharacters = 9;
			if (cprtext3.getText().length() > maxCharacters)
				event.consume();
		});
		
		// sï¿½tter maks 10 tegn i CPR
		tlfinput2.setOnKeyTyped(event -> {
			int maxCharacters = 9;
			if (cprtext3.getText().length() > maxCharacters)
				event.consume();
		});

		// Kun tal i CPR
		cprtext3.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("[0-9]*")) {
				cprtext3.setText(oldValue);
			}
		});

		// Kun tal i tlf
		tlftext3.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("[0-9]*")) {
				tlftext3.setText(oldValue);
			}
		});

		// Kun tal i postnummer
		postnummertext3.textProperty().addListener((observable, oldValue, newValue) -> {
			if (!newValue.matches("[0-9]*")) {
				postnummertext3.setText(oldValue);
			}
		});
		
		pristext3.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
			if(!udbetalingtext3.getText().isEmpty()) {
//				DecimalFormat formattere = new DecimalFormat("#.##");
				lånbeløb.setText(String.valueOf(Double.parseDouble(pristext3.getText()) - Double.parseDouble(udbetalingtext3.getText())));
		}
			else {
				lånbeløb.setText("");
			}}
			catch(NumberFormatException nfe) {
				
			}
		});
		
		udbetalingtext3.textProperty().addListener((observable, oldValue, newValue) -> {
			try {
			if(!pristext3.getText().isEmpty()) {
//				DecimalFormat formattere = new DecimalFormat("#.##");
				lånbeløb.setText(String.valueOf(Double.parseDouble(pristext3.getText()) - Double.parseDouble(udbetalingtext3.getText())));
		}
			else {
				lånbeløb.setText("");
			}}
			catch(NumberFormatException nfe) {
				
			}
		});
		
		renten2.textProperty().addListener((observable, oldValue, newValue) -> {
			if(!renten2.getText().isEmpty()) {
				String månedligRente = String.valueOf(controller.udregnMånedligRente(Double.parseDouble(renten2.getText())));
				String afdrag = String.valueOf(
							 controller.udregnAfdrag(controller.getFormular(Integer.parseInt(tlfinput2.getText())).getLånBeløb(), 
							 controller.udregnMånedligRente(Double.parseDouble(renten2.getText())), 
							 controller.getFormular(Integer.parseInt(tlfinput2.getText())).getLånLængde()));
				
				mdrRente.setText(månedligRente);
				mdrAfdrag.setText(afdrag);
				 
			}
		});

		// sï¿½tter maks 4 tegn i CPR
		postnummertext3.setOnKeyTyped(event -> {
			int maxCharacters = 3;
			if (postnummertext3.getText().length() > maxCharacters)
				event.consume();
		});

		Scene laaneformularscene = new Scene(grid3, 3000, 3000);
		
		GridPane grid4 = new GridPane();
		grid4.setPadding(new Insets(20));
		grid4.setHgap(15);
		grid4.setVgap(15);
		
		
		
		Scene godkendelsesSide = new Scene(grid4, 3000, 3000);

		// ændre icon
		Image anotherImage = new Image("file:LTKF/src/download.jpg");
		primaryStage.getIcons().add(anotherImage);

		// lave event handlers der åbner den ønskede nye scene
		godkendtilbud.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(godkendelsesSide);

			}
		});
		
		opretlån.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(laaneformularscene);

			}
		});

		// lave event handlers der gï¿½r tilbage til main menu
		cancel3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				tlftext3.setText("");
				navntext3.setText("");
				efternavntext3.setText("");
				adressetext3.setText("");
				bytext3.setText("");
				postnummertext3.setText("");
				emailtext3.setText("");
				cprtext3.setText("");
				sælgertext3.setText("");
				udbetalingtext3.setText("");
				pristext3.setText("");
				kommentartext3.setText("");
				længdelåntext3.setText("");
			}
		});

		// lave event handlers der går tilbage til main menu
		back.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				primaryStage.setScene(mainmenuscene);
				tlftext3.setText("");
				navntext3.setText("");
				efternavntext3.setText("");
				adressetext3.setText("");
				bytext3.setText("");
				postnummertext3.setText("");
				emailtext3.setText("");
				cprtext3.setText("");
				sælgertext3.setText("");
				udbetalingtext3.setText("");
				pristext3.setText("");
				kommentartext3.setText("");
				længdelåntext3.setText("");
			}
		});
		
		// lave event handlers der gï¿½r tilbage til main menu
				tilbage.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						primaryStage.setScene(mainmenuscene);
						tlftext3.setText("");
						navntext3.setText("");
						efternavntext3.setText("");
						adressetext3.setText("");
						bytext3.setText("");
						postnummertext3.setText("");
						emailtext3.setText("");
						cprtext3.setText("");
						sælgertext3.setText("");
						udbetalingtext3.setText("");
						pristext3.setText("");
						kommentartext3.setText("");
						længdelåntext3.setText("");
					}
				});
				
				// lave event handlers der gï¿½r tilbage til main menu
				tilbage2.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						primaryStage.setScene(mainmenuscene);
						tlftext3.setText("");
						navntext3.setText("");
						efternavntext3.setText("");
						adressetext3.setText("");
						bytext3.setText("");
						postnummertext3.setText("");
						emailtext3.setText("");
						cprtext3.setText("");
						sælgertext3.setText("");
						udbetalingtext3.setText("");
						pristext3.setText("");
						kommentartext3.setText("");
						længdelåntext3.setText("");
					}
				});
				
				
				// lave event handlers der gï¿½r tilbage til main menu
				tilbage1.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						primaryStage.setScene(mainmenuscene);
						tlftext3.setText("");
						navntext3.setText("");
						efternavntext3.setText("");
						adressetext3.setText("");
						bytext3.setText("");
						postnummertext3.setText("");
						emailtext3.setText("");
						cprtext3.setText("");
						sælgertext3.setText("");
						udbetalingtext3.setText("");
						pristext3.setText("");
						kommentartext3.setText("");
						længdelåntext3.setText("");
					}
				});

		
		// lave event handlers der gï¿½r tilbage til main menu
		hentRente2.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				controller.getRente(tlfinput2, renten2);
				System.out.println(tlfinput2.getText().toString());
			}
		});
		
		hentKunde1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				if(tlfinput2.getText().isEmpty() || tlfinput2.getText() == "") {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Telefon nummer mangler!");
					alert.setHeaderText(null);
					alert.setContentText("Mangler indhold");

					alert.showAndWait();
				}
				try {
					int tlfparse = Integer.parseInt(tlfinput2.getText());
					if(tlfparse != controller.getFormular(tlfparse).getTlfNr()) {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Ingen låneanmodning");
						alert.setHeaderText(null);
						alert.setContentText("Ingen låneanmodning associeret med dette telefon nummer!");

						alert.showAndWait();
					}
					else {
					 biltype2.setText(controller.bilNavnFraLåneFormular(controller.getFormular(tlfparse).getBilId()));
					 lånbeløbtext2.setText(String.valueOf(controller.getFormular(tlfparse).getLånBeløb()));
					 laengdeLaan2.setText(String.valueOf(controller.getFormular(tlfparse).getLånLængde()));
					 vælgsælger2.setText(String.valueOf(controller.getFormular(tlfparse).getSælgerId()));
					 førsteYde2.setText(String.valueOf(controller.getFormular(tlfparse).getUdbetaling()));
					 
						
					}
					
				}
				catch(NumberFormatException nfe) {
					
				}
				
			}
		});
		
		// lave event handlers der ï¿½bner den ï¿½nskede nye scene
		hentKunde.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {								
				if(tlftext3.getText().isEmpty() || tlftext3.getText() == "") {
						Alert alert = new Alert(AlertType.INFORMATION);
						alert.setTitle("Telefon nummer mangler!");
						alert.setHeaderText(null);
						alert.setContentText("Mangler indhold");

						alert.showAndWait();
					}
				try{
				int tlfparse = Integer.parseInt(tlftext3.getText());
				if(tlfparse != controller.getKunde(tlfparse).getTlfNr()) {
					Alert alert = new Alert(AlertType.INFORMATION);
					alert.setTitle("Telefon nummer eksisterer ikke!");
					alert.setHeaderText(null);
					alert.setContentText("Kunde er ikke oprettet");

					alert.showAndWait();
				}
				else {
					navntext3.setText(controller.getKunde(tlfparse).getNavn());
					efternavntext3.setText(controller.getKunde(tlfparse).getEfternavn());
					adressetext3.setText(controller.getKunde(tlfparse).getAdresse());
					cprtext3.setText(controller.getKunde(tlfparse).getCprNr());
					postnummertext3.setText(String.valueOf(controller.getKunde(tlfparse).getPostNummer()));
					bytext3.setText(controller.getByen(tlfparse));
					emailtext3.setText(controller.getKunde(tlfparse).getEmail()); 
				}
				}
				catch(NumberFormatException nfe) {
					
				}
				
			}
		});
		
		opret3.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				int tlfparse = Integer.parseInt(tlftext3.getText());
				
				if(tlfparse != controller.getKunde(tlfparse).getTlfNr()) {
					
					System.out.println("Kunde eksistere ikke, opretter kunde.");
				controller.opretKunde(Integer.parseInt(tlftext3.getText()), navntext3.getText(), efternavntext3.getText(), cprtext3.getText(), adressetext3.getText(), Integer.parseInt(postnummertext3.getText()), emailtext3.getText());
				}

				controller.opretLåneformular(Integer.parseInt(udbetalingtext3.getText()), Integer.parseInt(længdelåntext3.getText()), Double.parseDouble(lånbeløb.getText()), biltype3.getSelectionModel().getSelectedItem().getBilId(), Integer.parseInt(tlftext3.getText()), Integer.parseInt(sælgertext3.getText()));  
				
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("Låneformular oprettet");
				alert.setHeaderText(null);
				alert.setContentText("Låneformular er oprettet." + "\n" + "Hvis kunde ikke var oprettet, så er kunden blevet oprettet.");
				alert.showAndWait();
				
				primaryStage.setScene(mainmenuscene); 
			}
		});
		
		opretTilbud.setOnAction(new EventHandler<ActionEvent>(){
			@Override
			public void handle(ActionEvent event) {
				if(!mdrAfdrag.getText().isEmpty() && !mdrRente.getText().isEmpty()) {
					 controller.opretTilbud(Double.parseDouble(renten2.getText()), controller.bilPrisFraLåneFormular(Integer.parseInt(tlfinput2.getText()))<controller.getSalgsGrænseSælger(Integer.parseInt(vælgsælger2.getText())), controller.getFormular(Integer.parseInt(tlfinput2.getText())).getFormularId());
					
				}
			}
		});
		

		//Tableview1 scene
				// lave et grid

				GridPane grid5 = new GridPane();
				grid5.setPadding(new Insets(20));
				grid5.setHgap(15);
				grid5.setVgap(15);
//				grid4.setGridLinesVisible(true);
				grid5.add(back, 0, 1);
				
				Scene færdigtilbudSide = new Scene(grid5, 3000, 3000);
				
				// lave event handlers der åbner den ønskede nye scene
				færdigtilbud.setOnAction(new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						primaryStage.setScene(færdigtilbudSide);

					}
				});
				
				TableView<KundeTabel> færdigtabel;
				    
				    
				 
				 
				 
				 
				
//				//navn column
//				TableColumn<KundeTabel, Integer> tlfcolumn = new TableColumn<>("Tlf:");
//				tlfcolumn.setCellValueFactory(new PropertyValueFactory<>("tlfNr"));
//				
//				//navn column
//				TableColumn<KundeTabel, String> navncolumn = new TableColumn<>("Navn");
//				navncolumn.setCellValueFactory(new PropertyValueFactory<KundeTabel,String>("navn"));
//				
//				//navn column
//				TableColumn<KundeTabel, String> efternavncolumn = new TableColumn<>("Efternavn");
//				efternavncolumn.setCellValueFactory(new PropertyValueFactory<>("efternavn"));

//				TableColumn<KundeTabel, Boolean> actioncolumn = new TableColumn<>("Tjek tilbud");
//				actioncolumn.setCellValueFactory(new PropertyValueFactory<>("godkend"));
//				actioncolumn.setSortable(false);
				
//				actioncolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<KundeTabel, Boolean>, ObservableValue<Boolean>>() {
//				      @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<KundeTabel, Boolean> features) {
//				        return new SimpleBooleanProperty(features.getValue() != null);
//				      }
//				    });
				
//				  actioncolumn.setCellFactory(new Callback<TableColumn<KundeTabel, Boolean>, TableCell<KundeTabel, Boolean>>() {
//				      @Override public TableCell<KundeTabel, Boolean> call(TableColumn<KundeTabel, Boolean> personBooleanTableColumn) {
//				        return new AddPersonCell(grid4, tabel);
//				      }
//				    });
				
//				//navn column
//				TableColumn<KundeTabel, String> adressecolumn = new TableColumn<>("Adresse");
//				adressecolumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
			//	
//				//navn column
//				TableColumn<KundeTabel, String> bycolumn = new TableColumn<>("By");
//				bycolumn.setCellValueFactory(new PropertyValueFactory<>(test.getByen()));
			//	
//				//navn column
//				TableColumn<KundeTabel, Integer> postcolumn = new TableColumn<>("Postnummer");
//				postcolumn.setCellValueFactory(new PropertyValueFactory<>("postNummer"));
			//	
//				//navn column
//				TableColumn<KundeTabel, Integer> emailcolumn = new TableColumn<>("E-mail");
//				emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));
//				
//				færdigtabel = new TableView<KundeTabel>();
//				færdigtabel.setItems(getKundeTabel());
//				færdigtabel.getColumns().addAll(tlfcolumn, navncolumn,efternavncolumn);
//				
//				grid5.getChildren().addAll(færdigtabel);
				
				

//			KundeTabel test = new KundeTabel(22905618, "Daniel", "Jensen", "Algade65", "Spjald", 6971, "danielsj96@gmail.com");
//			private ObservableList<KundeTabel> getKundeTabel() {
//			ObservableList<KundeTabel> KundeTabel = FXCollections.observableArrayList();
//			KundeTabel.add(test);
//			return KundeTabel;
//			}
				
				

				
				//Tableview2 scene
						// lave et grid
				
						GridPane gridTabel = new GridPane();
						gridTabel.setPadding(new Insets(20));
						gridTabel.setHgap(15);
						gridTabel.setVgap(15);
//						grid4.setGridLinesVisible(true);
						gridTabel.add(tilbage, 0, 1);
						
						Scene godkendelsesScene = new Scene(gridTabel, 3000, 3000);
						
						// lave event handlers der åbner den ønskede nye scene
						godkendtilbud.setOnAction(new EventHandler<ActionEvent>() {
							@Override
							public void handle(ActionEvent event) {
								primaryStage.setScene(godkendelsesScene);

							}
						});
						
						TableView<KundeTabel> tabel;
						    
						    
						 
						 
						 
						 
						
						//navn column
						TableColumn<KundeTabel, Integer> tlfcolumn = new TableColumn<>("Tlf:");
						tlfcolumn.setCellValueFactory(new PropertyValueFactory<>("tlfNr"));
						
						//navn column
						TableColumn<KundeTabel, String> navncolumn = new TableColumn<>("Navn");
						navncolumn.setCellValueFactory(new PropertyValueFactory<KundeTabel,String>("navn"));
						
						//navn column
						TableColumn<KundeTabel, String> efternavncolumn = new TableColumn<>("Efternavn");
						efternavncolumn.setCellValueFactory(new PropertyValueFactory<>("efternavn"));
					
//						TableColumn<KundeTabel, Boolean> actioncolumn = new TableColumn<>("Tjek tilbud");
//						actioncolumn.setCellValueFactory(new PropertyValueFactory<>("godkend"));
//						actioncolumn.setSortable(false);
						
//						actioncolumn.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<KundeTabel, Boolean>, ObservableValue<Boolean>>() {
//						      @Override public ObservableValue<Boolean> call(TableColumn.CellDataFeatures<KundeTabel, Boolean> features) {
//						        return new SimpleBooleanProperty(features.getValue() != null);
//						      }
//						    });
						
//						  actioncolumn.setCellFactory(new Callback<TableColumn<KundeTabel, Boolean>, TableCell<KundeTabel, Boolean>>() {
//						      @Override public TableCell<KundeTabel, Boolean> call(TableColumn<KundeTabel, Boolean> personBooleanTableColumn) {
//						        return new AddPersonCell(grid4, tabel);
//						      }
//						    });
						
//						//navn column
//						TableColumn<KundeTabel, String> adressecolumn = new TableColumn<>("Adresse");
//						adressecolumn.setCellValueFactory(new PropertyValueFactory<>("adresse"));
//						
//						//navn column
//						TableColumn<KundeTabel, String> bycolumn = new TableColumn<>("By");
//						bycolumn.setCellValueFactory(new PropertyValueFactory<>(test.getByen()));
//						
//						//navn column
//						TableColumn<KundeTabel, Integer> postcolumn = new TableColumn<>("Postnummer");
//						postcolumn.setCellValueFactory(new PropertyValueFactory<>("postNummer"));
//						
//						//navn column
//						TableColumn<KundeTabel, Integer> emailcolumn = new TableColumn<>("E-mail");
//						emailcolumn.setCellValueFactory(new PropertyValueFactory<>("email"));
						
						tabel = new TableView<KundeTabel>();
						tabel.setItems(getKundeTabel());
						tabel.getColumns().addAll(tlfcolumn, navncolumn,efternavncolumn);
						
						gridTabel.getChildren().addAll(tabel);
						
						
						
						
						
						Screen screen = Screen.getPrimary();
						Rectangle2D bounds = screen.getVisualBounds();

						primaryStage.setX(bounds.getMinX());
						primaryStage.setY(bounds.getMinY());
						primaryStage.setWidth(bounds.getWidth());
						primaryStage.setHeight(bounds.getHeight());

					}
			
			
			

			
			KundeTabel test = new KundeTabel(22905618, "Daniel", "Jensen", "Algade65", "Spjald", 6971, "danielsj96@gmail.com");
			private ObservableList<KundeTabel> getKundeTabel() {
				ObservableList<KundeTabel> KundeTabel = FXCollections.observableArrayList();
				KundeTabel.add(test);
				return KundeTabel;
			}
			
			
	
	public static void main(String[] args) {
		launch(args);
	}
}