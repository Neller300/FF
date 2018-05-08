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
 
public class Låneformular extends Application {

    
    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ferrari laanetilbud");
    
        	//lave et grid 
        	GridPane root = new GridPane();
            root.setPadding(new Insets(20));
            root.setHgap(15);
            root.setVgap(15);
            root.setPrefSize(Window.WIDTH, Window.HEIGHT);
            root.setMaxSize(Window.WIDTH, Window.HEIGHT);
            root.setMinSize(Window.WIDTH, Window.HEIGHT);
            root.setPrefSize(Window.WIDTH, Window.HEIGHT);
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