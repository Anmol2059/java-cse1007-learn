import javafx.application.Application;
import javafx.scene.Scene;

import javafx.event.*;
import javafx.geometry.*;
import javafx.stage.*;

import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.text.*;

public class App extends Application {
    @Override
    public void start(Stage primaryStage)throws Exception{
        primaryStage.setTitle("HEllo app");
        GridPane myGridPane = createPane();
        addMyUI(myGridPane, primaryStage);
        Scene scene = new Scene(myGridPane, 500 , 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
    private GridPane createPane(){
        GridPane myGridPane= new GridPane();
        myGridPane.setAlignment(Pos.CENTER);
        myGridPane.setPadding(new Insets(48 , 48, 48, 48));
        myGridPane.setHgap(15);
        myGridPane.setVgap(15);

        return myGridPane;
    }

    private void addMyUI(GridPane myGridPane, Stage primaryStage){
        Label nameLabel= new Label("Enter your name ");
        myGridPane.add(nameLabel, 0,0);
        TextField nameField = new TextField();
        myGridPane.add(nameField, 1, 0);
    }

    public static void main(String[] args) {
        Application.launch(App.class , args);
    }
}