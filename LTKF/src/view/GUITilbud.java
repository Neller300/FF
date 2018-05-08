package view;

 
import java.awt.Window;

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
 
public class GUITilbud extends Application {

    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ferrari laanetilbud");
    
        	//lave et grid 
        	GridPane root = new GridPane();
            root.setPadding(new Insets(20));
            root.setHgap(15);
            root.setVgap(15);
//            root.setPrefSize(Window.WIDTH, Window.HEIGHT);
//            root.setMaxSize(Window.WIDTH, Window.HEIGHT);
//            root.setMinSize(Window.WIDTH, Window.HEIGHT);
//            root.setPrefSize(Window.WIDTH, Window.HEIGHT);
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

            //ændre icon
            Image anotherImage = new Image("file:src/download.jpg");
			primaryStage.getIcons().add(anotherImage);
            
            Scene scene = new Scene(root, 3000, 3000);
            primaryStage.setTitle("Ferrari laane tilbud");
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