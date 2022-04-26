package src;
import java.lang.reflect.Executable;
import java.sql.*;


import   javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.geometry.*;

public class App extends Application{

    public static void main(String[] args) {
        
        Application.launch(App.class, args);
    }

    TextField userInp = new TextField();
    PasswordField passInp = new PasswordField();

    public void clearForm(){
        userInp.clear();
        passInp.clear();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        GridPane grid = new GridPane();

        Label userLbl = new Label("Username");
        Label passLbl = new Label("Password");
        Button submitBtn = new Button("Submit");
        Button clearBtn = new Button("Clear");

        clearForm();

        // add to grid
        grid.add(userLbl, 0, 0);
        grid.add(userInp, 1, 0);

        grid.add(passLbl, 0, 1);
        grid.add(passInp, 1, 1);


        grid.add(submitBtn, 0, 2, 2, 1);

        grid.add(clearBtn, 0, 3, 2, 2);

        grid.setAlignment(Pos.CENTER);
        grid.setVgap(15);
        grid.setHgap(15);

        GridPane.setHalignment(submitBtn, HPos.CENTER);

        clearBtn.setOnAction((ActionEvent e) -> clearForm());

        submitBtn.setOnAction((ActionEvent e) -> addToDatabase());

        Scene scene = new Scene(grid, 400, 400);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();


    }

    private void addToDatabase() {
        String user = userInp.getText();
        String pass = passInp.getText();
        
        if(user == null && pass == null && 
            !user.equals("") && !pass.equals("")){

            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Enter correct information");
            a.setHeaderText("Enter username and password");
            a.setContentText("You not entered anything");
            a.show();
            return;
        }

        try{ 
            Class.forName("com.mysql.jdbc.Driver");

            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/userinp", 
                    "root", "M@nmolL14");

            Statement stmt = con.createStatement();

            String query = String.format("INSERT INTO userdata VALUES ('%s', '%s')", user, pass);
            
            int res = stmt.executeUpdate(query);
            
            
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Insert successful");
            a.setContentText(res + " inserted to the database");
            a.show();

            con.close();

        }catch(Exception e){
            Alert a = new Alert(AlertType.INFORMATION);
            a.setTitle("Error");
            a.setHeaderText("Error");
            a.setContentText(e.getMessage());
            a.show();
        }
    }
}