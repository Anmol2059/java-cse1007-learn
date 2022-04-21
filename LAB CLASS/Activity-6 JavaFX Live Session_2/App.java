/*
createdby @Anmol2059
@Java Fx APplication



*/
import java.io.*;
import java.io.File;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.Window;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Profile Submission Form");
         
        GridPane myGridPane = createProfileFormPane();
        
        addMyUI(myGridPane, primaryStage);
        
        Scene scene = new Scene(myGridPane, 800, 500);
        
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    private GridPane createProfileFormPane() {

        GridPane myGridPane = new GridPane();


        myGridPane.setAlignment(Pos.CENTER);

       
        myGridPane.setPadding(new Insets(48, 48, 48, 48));

        
        myGridPane.setHgap(15);

        
        myGridPane.setVgap(15);

        
        

        return myGridPane;
    }

    //Designing Form with proper Pane and Controls (4 Marks)
    private void addMyUI(GridPane myGridPane, Stage primaryStage) {
       

        //for text label and field
        Label nameLabel = new Label("Your  Name : ");
        myGridPane.add(nameLabel, 0,1);

        
        TextField nameField = new TextField();
        nameField.setPrefHeight(40);
        myGridPane.add(nameField, 1,1);


        // For Email Label and Field
        Label emailLabel = new Label("Your Email   ");
        myGridPane.add(emailLabel, 0, 2);

        
        TextField emailField = new TextField();
        emailField.setPrefHeight(40);
        myGridPane.add(emailField, 1, 2);

        //for number label and field
        Label numberLabel = new Label("Your Number ");
        myGridPane.add(numberLabel, 0, 3);

       
        TextField numberField = new TextField();
        
        
        numberField.setPrefHeight(40);
        myGridPane.add(numberField, 1, 3);

        //adding the date picker
        Label dateLabel = new Label("Date of Birth ");
        myGridPane.add(dateLabel, 0, 4);

        DatePicker dateField = new DatePicker();
        dateField.setPrefHeight(40);
        myGridPane.add(dateField, 1, 4);

        //adding radio for gender
        Label genderLabel = new Label("Gender ");
        myGridPane.add(genderLabel, 0, 5);
       
        RadioButton r1 = new RadioButton("male");
        RadioButton r2 = new RadioButton("female");
        myGridPane.add(r1, 1, 5);
        myGridPane.add(r2, 2, 5);

        //choose profile picture
        Label ppLabel = new Label("Upload Profile Picture ");
        myGridPane.add(ppLabel, 0, 6);
        Button ppButton = new Button("Choose Profile Picture");
        ppButton.setPrefHeight(20);
        ppButton.setDefaultButton(true);
        ppButton.setPrefWidth(300);
        myGridPane.add(ppButton, 1, 6, 2, 1);

        FileChooser filepp = new FileChooser();

        Label fileUploadStatus = new Label();
        myGridPane.add(fileUploadStatus, 0, 7);
        ppButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                File file = filepp.showOpenDialog(primaryStage);
                try{
                Image image = new Image(new FileInputStream(file.toPath().toString()));
                ImageView iv = new ImageView();
                iv.setImage(image);
                iv.setFitHeight(100);
                iv.setFitWidth(100);
                myGridPane.add(iv, 1, 9);
                }catch(IOException e){
                    e.printStackTrace();
                }

                if (file != null) {
                    fileUploadStatus.setText("File Upload Successful");
                } else {
                    fileUploadStatus.setText("File Not able to Upload");
                }
            }
        });


        // FileChooser fileChooser = new FileChooser();
        // fileChooser.setTitle("Select Profile Picture");
        // FileChooser.ExtensionFilter filter = new FileChooser.ExtensionFilter("Image Files, *.jpeg, *.png",
        //         ".jpeg", ".png");

        // chooser.getExtensionFilters().add(filter);
        

        

        //submit Button
        Button submitButton = new Button("Submit Profile");
        submitButton.setPrefHeight(40);
        submitButton.setDefaultButton(true);
        submitButton.setPrefWidth(100);
        myGridPane.add(submitButton, 0, 8, 2, 1);
        GridPane.setHalignment(submitButton, HPos.LEFT);
        GridPane.setMargin(submitButton, new Insets(20, 0,20,0));


        //Form Control validation (2 Marks)
        submitButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                try{
                BufferedWriter bw = new BufferedWriter(new FileWriter("file.txt", true));
                if(nameField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, myGridPane.getScene().getWindow(), "504 Warning!", "Name not Given");
                    return;
                }
                else if(emailField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, myGridPane.getScene().getWindow(), "504 Warning!", "Email id, not Given");
                    return;
                }
                else if(numberField.getText().isEmpty()) {
                    showAlert(Alert.AlertType.ERROR, myGridPane.getScene().getWindow(), "504 Warning!", "Please enter a number");
                    return;
                }
                //Storing Profile Information into File (2 Marks)
                else{
                    bw.write(nameField.getText() + "\n");
                    bw.append(emailField.getText() + "\n");
                    bw.append(numberField.getText() + "\n");
                }
                bw.close();
            }catch(IOException e){
                e.printStackTrace();
            }

                showAlert(Alert.AlertType.CONFIRMATION, myGridPane.getScene().getWindow(), "Profile Details stored in The File", "Thank You " + nameField.getText());
            }
        });
    }


    //Form Control validation (2 Marks) by throwing the error
    private void showAlert(Alert.AlertType alertType, Window owner, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.initOwner(owner);
        alert.show();
    }

    public static void main(String[] args) {
        Application.launch(App.class, args);
    }
}	 	  	 		      	 	   	    	  	       	 	
    
    
    
    
    
    
    
    