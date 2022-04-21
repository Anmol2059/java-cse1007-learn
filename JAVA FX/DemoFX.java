import java.io.*;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
public class DemoFX extends Application {
    public static void main(String[] args) {
        launch();
    }


    @Override
    public void start(Stage primaryStage) throws Exception{
        //adding control i,e button
        Button bt1 = new Button("Click me");
        //lets define the layout
        HBox root = new HBox();
        //add ourt control 
        root.getChildren().add(bt1);
        //add layout in sscene
        Scene sc = new Scene(root);
        //add this scene to stage
        primaryStage.setScene(sc);
        primaryStage.show();
    }
}
