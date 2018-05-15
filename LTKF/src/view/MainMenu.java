package view;

 

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
import logic.BankRente;
import logic.LoanThread;
import persistens.BankData;

 
public class MainMenu extends Application {
	
	TextField renten2 = new TextField();
	
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ferrari");
    
        	//lave et grid 
        	GridPane grid1 = new GridPane();
        	grid1.setPadding(new Insets(20));
            grid1.setHgap(15);
            grid1.setVgap(15);
            //gridp.setGridLinesVisible(true);
            
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
            row.setPercentHeight(20);
            grid1.getRowConstraints().add(row);
            
            row = new RowConstraints();
            row.setPercentHeight(20);
            grid1.getRowConstraints().add(row);
            
            row = new RowConstraints();
            row.setPercentHeight(20);
            grid1.getRowConstraints().add(row);
            
            row = new RowConstraints();
            row.setPercentHeight(20);
            grid1.getRowConstraints().add(row);
            
            row = new RowConstraints();
            row.setPercentHeight(20);
            grid1.getRowConstraints().add(row);
            
            Button opretlaan = new Button("Opret laaneformular");
            opretlaan.setStyle("-fx-font: 30 arial;");
            
            Button redigerlaan = new Button("Rediger laaneformular");
            redigerlaan.setStyle("-fx-font: 30 arial;");

            Button lavtilbud = new Button("Udarbejd laanetilbud");
            lavtilbud.setStyle("-fx-font: 30 arial;");
            
            Button redigertilbud = new Button("Rediger laanetilbud");
            redigertilbud.setStyle("-fx-font: 30 arial;");
            
            Button godkendtilbud = new Button("Godkend laanetilbud");
            godkendtilbud.setStyle("-fx-font: 30 arial;");
            
            grid1.add(opretlaan, 1, 0);
            
            grid1.add(redigerlaan, 1, 1);
            
            grid1.add(lavtilbud, 1, 2);
            
            grid1.add(redigertilbud, 1, 3);
            
            grid1.add(godkendtilbud, 1, 4);
            
            //�ndre knappens max height og width value. og derefter fylder knappen ud i den grid den er i
            opretlaan.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            GridPane.setFillWidth(opretlaan, true);
            GridPane.setFillHeight(opretlaan, true);
            
            redigerlaan.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            GridPane.setFillWidth(redigerlaan, true);
            GridPane.setFillHeight(redigerlaan, true);
            
            lavtilbud.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            GridPane.setFillWidth(lavtilbud, true);
            GridPane.setFillHeight(lavtilbud, true);
            
            redigertilbud.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            GridPane.setFillWidth(redigertilbud, true);
            GridPane.setFillHeight(redigertilbud, true);
            
            godkendtilbud.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
            GridPane.setFillWidth(godkendtilbud, true);
            GridPane.setFillHeight(godkendtilbud, true);
            
            Scene mainmenuscene = new Scene(grid1, 3000, 3000);
            primaryStage.setScene(mainmenuscene);
            primaryStage.show();
            
            
            
            
            //Tilbuds scene
          //lave et grid 
        	GridPane grid2 = new GridPane();
            grid2.setPadding(new Insets(20));
            grid2.setHgap(15);
            grid2.setVgap(15);
        //    root.setGridLinesVisible(true);
            
            // styre hver kolones st�rrelse i procent
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
            

            //lave sine label, buttons, text
            Label labelTitle = new Label("Udarbejd tilbud");
            // Put on cell (0,0), span 2 column, 1 row.
            grid2.add(labelTitle, 0, 0, 2, 1);
      
            Label cpr2 = new Label("CPR-nummer:");
            TextField cprinput2 = new TextField();
          //  cprinput.setMaxWidth(200);
            
            Label RKI2 = new Label("Info fra RKI:");
            TextArea RKIINFO2 = new TextArea();
            RKIINFO2.setEditable(false);
            RKIINFO2.setMouseTransparent(true);
         // 	RKIINFO.setPrefRowCount();
            
            Label bil2 = new Label("Bil");
            
            //combobox
            final ComboBox<String> biltype2 = new ComboBox<String>();
            biltype2.getItems().addAll(
                "Ferrari F50",
                "Ferrari California",
                "Ferrari 599",
                "Ferrari F50 spider"
            );
            biltype2.setPromptText("Vaelg bil");
            
            Button hentRente2 = new Button("Rente");
            renten2.setEditable(false);
            renten2.setMouseTransparent(true);
            
            
            
            
            Label ydelse2 = new Label("Foerste ydelse");
            TextField forsteYde2 = new TextField();
            forsteYde2.setEditable(false);
            forsteYde2.setMouseTransparent(true);
            
            Label laanLaengde2 = new Label("Laengde paa laan");
            TextField laengdeLaan2 = new TextField();
            
            Label LaaneInfo2 = new Label("Laane information");
            TextArea LaanINFO2 = new TextArea();
            LaanINFO2.setEditable(false);
            LaanINFO2.setMouseTransparent(true);
            
            Label saelger2 = new Label("Saelger:");
            TextField vaelgsaelger2 = new TextField();
            
            Button back = new Button("Tilbage");

            
          //  biltype.getSelectionModel().selectedItemProperty().addListener( (v, oldvalue, newvalue )-> opdateryde);
            
            //S�tte text,buttons, label i et grid
            //cells row, colomn, row, colom
            GridPane.setHalignment(cpr2, HPos.LEFT);
            grid2.add(cpr2, 0, 1);
      
            GridPane.setHalignment(cprinput2, HPos.LEFT);
            grid2.add(cprinput2, 0, 2);
            
            GridPane.setHalignment(RKI2, HPos.LEFT);
            
            grid2.add(RKI2, 0, 3);
            
            grid2.add(RKIINFO2, 0, 4, 2, 8);
            
            grid2.add(bil2, 2, 1);
            
            grid2.add(biltype2, 2, 2);
            
            grid2.add(hentRente2, 2, 3);
            
            grid2.add(renten2, 2, 4);
            
            grid2.add(ydelse2, 3, 1);
            
            grid2.add(forsteYde2, 3, 2);
            
            grid2.add(laanLaengde2, 3, 3);
            
            grid2.add(laengdeLaan2, 3, 4);
            
            grid2.add(LaaneInfo2, 2, 5);
            
            grid2.add(LaanINFO2,2 ,6, 2,6 );
            
            grid2.add(saelger2, 0, 12);
            
            grid2.add(vaelgsaelger2, 0, 13);
            
            grid2.add(back, 0, 14);
            
            
            
            //s�tter maks 10 tegn
            cprinput2.setOnKeyTyped(event ->{
                int maxCharacters = 10;
                if(cprinput2.getText().length() > maxCharacters) event.consume();
            });
            
            //Kun tal
            cprinput2.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.matches("[0-9]*")){
                    cprinput2.setText(oldValue);
                }
            });

            Scene tilbudscene = new Scene(grid2, 3000, 3000);
            
            //lave event handlers der �bner den �nskede nye scene
            lavtilbud.setOnAction(new EventHandler<ActionEvent>() {
               @Override
               public void handle(ActionEvent event) {
                	primaryStage.setScene(tilbudscene); 
                	
                
            }
    });
            
            
            
            
            
            
            
            //Laaneformular scene
          //lave et grid 
        	GridPane grid3 = new GridPane();
            grid3.setPadding(new Insets(20));
            grid3.setHgap(15);
            grid3.setVgap(15);
        //    gridp.setGridLinesVisible(true);
            
            // styre hver kolones st�rrelse i procent
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
            
            Label saelger3 = new Label("Saelger");
            TextField saelgertext3 = new TextField();
            
            Label bil3 = new Label("Bil");
            
            //combobox
            final ComboBox<String> biltype3 = new ComboBox<String>();
            biltype3.getItems().addAll(
                "Ferrari F50",
                "Ferrari California",
                "Ferrari 599",
                "Ferrari F50 spider"
            );
            biltype3.setPromptText("Vaelg bil");
            
            Label udbetaling3 = new Label("Udbetaling");
            TextField udbetalingtext3 = new TextField();
            
            Label pris3 = new Label("Pris");
            TextField pristext3 = new TextField();
            
            Label laengdelaan3 = new Label("Laengde paa laan");
            TextField laengdelaantext3 = new TextField();
            
            Label kommentar3 = new Label("Kommentar");
            TextArea kommentartext3 = new TextArea();
            
            Button opret3 = new Button("Opret");
            
            Button cancel3 = new Button("Ryd alt");
            
          //cells row, colomn, row, colom
            grid3.add(tlf3, 0, 0);
            
            grid3.add(tlftext3, 0, 1);
            
            grid3.add(navn3, 0, 2);
            
            grid3.add(navntext3, 0, 3);
            
            grid3.add(efternavn3, 0,4);
            
            grid3.add(efternavntext3, 0, 5);
            
            grid3.add(adresse3, 0, 6);
            
            grid3.add(adressetext3, 0, 7);
            
            grid3.add(by3, 0, 8);
            
            grid3.add(bytext3, 0, 9);
            
            grid3.add(postnummer3, 0, 10);
            
            grid3.add(postnummertext3, 0, 11);
            
            grid3.add(email3, 0, 12);
            
            grid3.add(emailtext3, 0, 13);
            
            grid3.add(cpr3, 0, 14);
            
            grid3.add(cprtext3, 0, 15);
            
            grid3.add(saelger3, 0, 16);
            
            grid3.add(saelgertext3, 0, 17);
            
            grid3.add(bil3, 2, 0);
            
            grid3.add(biltype3, 2, 1);
            
            grid3.add(udbetaling3, 3, 0);
            
            grid3.add(udbetalingtext3, 3, 1);
            
            grid3.add(pris3, 2, 2);
            
            grid3.add(pristext3, 2, 3);
            
            grid3.add(laengdelaan3, 3, 2);
            
            grid3.add(laengdelaantext3, 3, 3);
            
            grid3.add(kommentar3, 2, 4);
            
            grid3.add(kommentartext3, 2, 6, 3,6);
            
            grid3.add(opret3, 2, 12);
            
            grid3.add(cancel3, 3, 12);
            
            grid3.add(back, 0, 18);
            
            //s�tter maks 10 tegn i CPR
            cprtext3.setOnKeyTyped(event ->{
                int maxCharacters = 9;
                if(cprtext3.getText().length() > maxCharacters) event.consume();
            });
            
            //Kun tal i CPR
            cprtext3.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.matches("[0-9]*")){
                    cprtext3.setText(oldValue);
                }
            });
            
            //Kun tal i tlf
            tlftext3.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.matches("[0-9]*")){
                    tlftext3.setText(oldValue);
                }
            });
            
            //Kun tal i postnummer
           postnummertext3.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.matches("[0-9]*")){
                    postnummertext3.setText(oldValue);
                }
            });
           
           //s�tter maks 4 tegn i CPR
           postnummertext3.setOnKeyTyped(event ->{
               int maxCharacters = 3;
               if(postnummertext3.getText().length() > maxCharacters) event.consume();
           });
            
            
            Scene laaneformularscene = new Scene(grid3, 3000, 3000);
            
            //�ndre icon
            Image anotherImage = new Image("file:LTKF/src/download.jpg");
			primaryStage.getIcons().add(anotherImage);
            


        //lave event handlers der �bner den �nskede nye scene
        opretlaan.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
            	primaryStage.setScene(laaneformularscene); 
            	
            
        }
});
        
        
        
        //lave event handlers der g�r tilbage til main menu
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
            	saelgertext3.setText("");
            	udbetalingtext3.setText("");
            	pristext3.setText("");
            	kommentartext3.setText("");
            	laengdelaantext3.setText("");
        }
});
        
        //lave event handlers der g�r tilbage til main menu
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
            	saelgertext3.setText("");
            	udbetalingtext3.setText("");
            	pristext3.setText("");
            	kommentartext3.setText("");
            	laengdelaantext3.setText("");
        }
});
        
        BankData data = new BankData(cpr2.getText(), 0, null);
		LoanThread t = new LoanThread(data, renten2);
//        lave event handlers der g�r tilbage til main menu
        hentRente2.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
//        	   BankRente Bank = new BankRente();
//        	   Thread rente = new Thread(Bank);
//        	   rente.start();
//        	   renten2.setText(""+ Bank.toDouble());
        	   t.start();
           }
        });
        
        
        
		
		
        
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        
    }
    

    public static void main(String[] args) {
        launch(args);
    }
}