package view;

 

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Screen;
import javafx.stage.Stage;
 
public class MainMenu extends Application {
	
	Scene scene, tilbudscene, laaneformularscene;

    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ferrari");
    
        	//lave et grid 
        	GridPane gridp = new GridPane();
        	gridp.setPadding(new Insets(20));
            gridp.setHgap(15);
            gridp.setVgap(15);
            //gridp.setGridLinesVisible(true);
            
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(20);
            gridp.getColumnConstraints().add(column);
            
            column = new ColumnConstraints();
            column.setPercentWidth(60);
            gridp.getColumnConstraints().add(column);
            
            column = new ColumnConstraints();
            column.setPercentWidth(20);
            gridp.getColumnConstraints().add(column);
            
            RowConstraints row = new RowConstraints();
            row.setPercentHeight(20);
            gridp.getRowConstraints().add(row);
            
            row = new RowConstraints();
            row.setPercentHeight(20);
            gridp.getRowConstraints().add(row);
            
            row = new RowConstraints();
            row.setPercentHeight(20);
            gridp.getRowConstraints().add(row);
            
            row = new RowConstraints();
            row.setPercentHeight(20);
            gridp.getRowConstraints().add(row);
            
            row = new RowConstraints();
            row.setPercentHeight(20);
            gridp.getRowConstraints().add(row);
            
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
            
            gridp.add(opretlaan, 1, 0);
            
            gridp.add(redigerlaan, 1, 1);
            
            gridp.add(lavtilbud, 1, 2);
            
            gridp.add(redigertilbud, 1, 3);
            
            gridp.add(godkendtilbud, 1, 4);
            
            //ændre knappens max height og width value. og derefter fylder knappen ud i den grid den er i
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
            
            //lave event handlers der åbner den ønskede nye scene
//            opretlaan.setOnAction(new EventHandler<ActionEvent>() {
//                @Override
//                public void handle(ActionEvent event) {
//                	primaryStage.hide();
//                	new stage = 
                	
                
//            }
//    });
            
            opretlaan.setOnAction(e -> primaryStage.setScene(laaneformularscene));
            
            //ændre icon
            Image anotherImage = new Image("file:LTKF/src/download.jpg");
			primaryStage.getIcons().add(anotherImage);
            
            Scene scene = new Scene(gridp, 3000, 3000);
            primaryStage.setScene(scene);
            primaryStage.show();
        
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());
        
    }
    
    public void tilbudstage(Stage tilbudStage) {
    
        	//lave et grid 
        	GridPane root = new GridPane();
            root.setPadding(new Insets(20));
            root.setHgap(15);
            root.setVgap(15);
        //    root.setGridLinesVisible(true);
            
            // styre hver kolones størrelse i procent
            ColumnConstraints column = new ColumnConstraints();
            column.setPercentWidth(10);
            root.getColumnConstraints().add(column);

            column = new ColumnConstraints();
            column.setPercentWidth(40);
            root.getColumnConstraints().add(column);
            
            column = new ColumnConstraints();
            column.setPercentWidth(10);
            root.getColumnConstraints().add(column);
            
            column = new ColumnConstraints();
            column.setPercentWidth(40);
            root.getColumnConstraints().add(column);
            

            //lave sine label, buttons, text
            Label labelTitle = new Label("Udarbejd tilbud");
            // Put on cell (0,0), span 2 column, 1 row.
            root.add(labelTitle, 0, 0, 2, 1);
      
            Label cpr = new Label("CPR-nummer:");
            TextField cprinput = new TextField();
          //  cprinput.setMaxWidth(200);
            
            Label RKI = new Label("Info fra RKI:");
            TextArea RKIINFO = new TextArea();
            RKIINFO.setEditable(false);
            RKIINFO.setMouseTransparent(true);
         // 	RKIINFO.setPrefRowCount();
            
            Label bil = new Label("Bil");
            
            //combobox
            final ComboBox<String> biltype = new ComboBox<String>();
            biltype.getItems().addAll(
                "Ferrari F50",
                "Ferrari California",
                "Ferrari 599",
                "Ferrari F50 spider"
            );
            biltype.setPromptText("Vaelg bil");
            
            Button hentRente = new Button("Rente");
            TextField renten = new TextField ();
            renten.setEditable(false);
            renten.setMouseTransparent(true);
            
            Label ydelse = new Label("Foerste ydelse");
            TextField forsteYde = new TextField();
            forsteYde.setEditable(false);
            forsteYde.setMouseTransparent(true);
            
            Label laanLaengde = new Label("Laengde paa laan");
            TextField laengdeLaan = new TextField();
            
            Label LaaneInf = new Label("Laane information");
            TextArea LaanINFO = new TextArea();
            LaanINFO.setEditable(false);
            LaanINFO.setMouseTransparent(true);
            
            Label saelger = new Label("Saelger:");
            TextField vaelgsaelger = new TextField();
            
          //  biltype.getSelectionModel().selectedItemProperty().addListener( (v, oldvalue, newvalue )-> opdateryde);
            
            //Sætte text,buttons, label i et grid
            //cells row, colomn, row, colom
            GridPane.setHalignment(cpr, HPos.LEFT);
            root.add(cpr, 0, 1);
      
            GridPane.setHalignment(cprinput, HPos.LEFT);
            root.add(cprinput, 0, 2);
            
            GridPane.setHalignment(RKI, HPos.LEFT);
            
            root.add(RKI, 0, 3);
            
            root.add(RKIINFO, 0, 4, 2, 8);
            
            root.add(bil, 2, 1);
            
            root.add(biltype, 2, 2);
            
            root.add(hentRente, 2, 3);
            
            root.add(renten, 2, 4);
            
            root.add(ydelse, 3, 1);
            
            root.add(forsteYde, 3, 2);
            
            root.add(laanLaengde, 3, 3);
            
            root.add(laengdeLaan, 3, 4);
            
            root.add(LaaneInf, 2, 5);
            
            root.add(LaanINFO,2 ,6, 2,6 );
            
            root.add(saelger, 0, 12);
            
            root.add(vaelgsaelger, 0, 13);
            
            //sætter maks 10 tegn
            cprinput.setOnKeyTyped(event ->{
                int maxCharacters = 10;
                if(cprinput.getText().length() > maxCharacters) event.consume();
            });
            
            //Kun tal
            cprinput.textProperty().addListener((observable, oldValue, newValue) -> {
                if(!newValue.matches("[0-9]*")){
                    cprinput.setText(oldValue);
                }
            });

            
            Scene tilbudscene = new Scene(root, 3000, 3000);
            tilbudStage.setTitle("Ferrari laane tilbud");
            tilbudStage.setScene(tilbudscene);
            tilbudStage.show();
        
        
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();

        tilbudStage.setX(bounds.getMinX());
        tilbudStage.setY(bounds.getMinY());
        tilbudStage.setWidth(bounds.getWidth());
        tilbudStage.setHeight(bounds.getHeight());
    }
    
    public void laaneFormularsStage(Stage laaneformularStage) {
        
    	//lave et grid 
    	GridPane gridp = new GridPane();
        gridp.setPadding(new Insets(20));
        gridp.setHgap(15);
        gridp.setVgap(15);
    //    gridp.setGridLinesVisible(true);
        
        // styre hver kolones størrelse i procent
        ColumnConstraints column = new ColumnConstraints();
        column.setPercentWidth(30);
        gridp.getColumnConstraints().add(column);

        column = new ColumnConstraints();
        column.setPercentWidth(10);
        gridp.getColumnConstraints().add(column);
        
        column = new ColumnConstraints();
        column.setPercentWidth(30);
        gridp.getColumnConstraints().add(column);
        
        column = new ColumnConstraints();
        column.setPercentWidth(30);
        gridp.getColumnConstraints().add(column);

        
        
        
        Label cpr = new Label("CPR-nummer");
        TextField cprtext = new TextField();
        
        Label navn = new Label("Navn");
        TextField navntext = new TextField();
        
        Label efternavn = new Label("Efternavn");
        TextField efternavntext = new TextField();
        
        Label adresse = new Label("Adresse");
        TextField adressetext = new TextField();
        
        Label by = new Label("By");
        TextField bytext = new TextField();
        
        Label postnummer = new Label("Postnummer");
        TextField postnummertext = new TextField();
        
        Label email = new Label("E-mail");
        TextField emailtext = new TextField();
        
        Label tlf = new Label("Tlf:");
        TextField tlftext = new TextField();
        
        Label saelger = new Label("Saelger");
        TextField saelgertext = new TextField();
        
        Label bil = new Label("Bil");
        
        //combobox
        final ComboBox<String> biltype = new ComboBox<String>();
        biltype.getItems().addAll(
            "Ferrari F50",
            "Ferrari California",
            "Ferrari 599",
            "Ferrari F50 spider"
        );
        biltype.setPromptText("Vaelg bil");
        
        Label udbetaling = new Label("Udbetaling");
        TextField udbetalingtext = new TextField();
        
        Label pris = new Label("Pris");
        TextField pristext = new TextField();
        
        Label laengdelaan = new Label("Laengde paa laan");
        TextField laengdelaantext = new TextField();
        
        Label kommentar = new Label("Kommentar");
        TextArea kommentartext = new TextArea();
        
        Button opret = new Button("Opret");
        
        Button cancel = new Button("Cancel");
        
      //cells row, colomn, row, colom
        gridp.add(tlf, 0, 0);
        
        gridp.add(tlftext, 0, 1);
        
        gridp.add(navn, 0, 2);
        
        gridp.add(navntext, 0, 3);
        
        gridp.add(efternavn, 0,4);
        
        gridp.add(efternavntext, 0, 5);
        
        gridp.add(adresse, 0, 6);
        
        gridp.add(adressetext, 0, 7);
        
        gridp.add(by, 0, 8);
        
        gridp.add(bytext, 0, 9);
        
        gridp.add(postnummer, 0, 10);
        
        gridp.add(postnummertext, 0, 11);
        
        gridp.add(email, 0, 12);
        
        gridp.add(emailtext, 0, 13);
        
        gridp.add(cpr, 0, 14);
        
        gridp.add(cprtext, 0, 15);
        
        gridp.add(saelger, 0, 16);
        
        gridp.add(saelgertext, 0, 17);
        
        gridp.add(bil, 2, 0);
        
        gridp.add(biltype, 2, 1);
        
        gridp.add(udbetaling, 3, 0);
        
        gridp.add(udbetalingtext, 3, 1);
        
        gridp.add(pris, 2, 2);
        
        gridp.add(pristext, 2, 3);
        
        gridp.add(laengdelaan, 3, 2);
        
        gridp.add(laengdelaantext, 3, 3);
        
        gridp.add(kommentar, 2, 4);
        
        gridp.add(kommentartext, 2, 6, 3,6);
        
        gridp.add(opret, 2, 12);
        
        gridp.add(cancel, 3, 12);
        
        //sætter maks 10 tegn i CPR
        cprtext.setOnKeyTyped(event ->{
            int maxCharacters = 10;
            if(cprtext.getText().length() > maxCharacters) event.consume();
        });
        
        //Kun tal i CPR
        cprtext.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.matches("[0-9]*")){
                cprtext.setText(oldValue);
            }
        });
        
        //Kun tal i tlf
        tlftext.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.matches("[0-9]*")){
                tlftext.setText(oldValue);
            }
        });
        
        //Kun tal i postnummer
       postnummertext.textProperty().addListener((observable, oldValue, newValue) -> {
            if(!newValue.matches("[0-9]*")){
                postnummertext.setText(oldValue);
            }
        });
       
       //sætter maks 4 tegn i CPR
       postnummertext.setOnKeyTyped(event ->{
           int maxCharacters = 4;
           if(postnummertext.getText().length() > maxCharacters) event.consume();
       });
        
        
        Scene laaneformularscene = new Scene(gridp, 3000, 3000);
        laaneformularStage.setTitle("Ferrari laane formular");
        laaneformularStage.setScene(laaneformularscene);
        laaneformularStage.show();
    
    
    Screen screen = Screen.getPrimary();
    Rectangle2D bounds = screen.getVisualBounds();

    laaneformularStage.setX(bounds.getMinX());
    laaneformularStage.setY(bounds.getMinY());
    laaneformularStage.setWidth(bounds.getWidth());
    laaneformularStage.setHeight(bounds.getHeight());
    
}
    public static void main(String[] args) {
        launch(args);
    }
}