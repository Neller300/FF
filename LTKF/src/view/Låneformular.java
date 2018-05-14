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
 
public class Låneformular extends Application {

    
    @Override
    public void start(Stage primaryStage) {
    
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
            
            //ændre icon
            Image anotherImage = new Image("file:LTKF/src/download.jpg");
			primaryStage.getIcons().add(anotherImage);
            
            Scene scene = new Scene(gridp, 3000, 3000);
            primaryStage.setTitle("Ferrari laane formular");
            primaryStage.setScene(scene);
            primaryStage.show();
        
        
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