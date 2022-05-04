import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javafx.application.Application;
import javafx.scene.Scene;

import javafx.event.*;
import javafx.geometry.*;
import javafx.stage.*;

import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.scene.image.*;
import javafx.scene.text.*;

class DataException extends Exception{

    public DataException(String message){
        super(message);
    }
}

class Data{
    private String name;
    private int age;
    private int weight;
    private int height;

    public void setName(String name){
        this.name = name;
    }
    
    public void setAge(int age){
        this.age = age;
    }
    
    public void setWeight(int weight){
        this.weight = weight;
    }
    
    public void setHeight(int height){
        this.height = height;
    }
    
    public String getName(){ return name; }
    public int getAge(){ return age; }
    public int getWeight(){ return weight; }
    public int getHeight(){ return height; }
    
    
    public Data(){}
    
    public Data(String name, int age, int weight, int height){
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.height = height;
    }

    public static Data parseData(String inp) throws DataException{
        String[] vals = inp.split(",");

        if(vals.length != 4){
            throw new DataException("bad format of data");
        }

        return new Data(vals[0].trim(), Integer.parseInt(vals[1].trim()), 
            Integer.parseInt(vals[2].trim()), Integer.parseInt(vals[3].trim()));
    }
}

public class App extends Application {
    TextField nameInp = new TextField();
    TextField ageInp = new TextField();
    TextField weightInp = new TextField();
    TextField heightInp = new TextField();

    BufferedReader br = null;


    @Override
    public void start(Stage primaryStage)throws Exception{
        try{
            br = new BufferedReader(new FileReader("./demo.txt"));
        }catch(IOException e){
            e.printStackTrace();
        }

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

    public void showNextRecord() throws IOException, DataException{

        if(br == null){
            Alert a = new Alert(AlertType.ERROR);
            // a.setHeaderText("Error");
            a.setContentText("File not found");
            a.show();
            return;
        }

        String st = br.readLine();

        if(st == null){
            Alert a = new Alert(AlertType.ERROR);
            // a.setHeaderText("Error");
            a.setContentText("File reached EOF");
            a.show();
            return;
        }

        Data d = Data.parseData(st);

        nameInp.setText(d.getName());
        ageInp.setText(Integer.toString(d.getAge()) );
        weightInp.setText(Integer.toString(d.getWeight()) );
        heightInp.setText(Integer.toString(d.getHeight()) );

    }

    private void addMyUI(GridPane myGridPane, Stage primaryStage){
        Label nameLabel= new Label("Name ");
        Label ageLbl = new Label("Age");
        Label weightLbl = new Label("Weight");
        Label heightLbl = new Label("Height");

        Button nextBtn = new Button("Next file");

        nextBtn.setOnAction((ActionEvent e) ->{

            try{
                showNextRecord();
            }catch(Exception err){

            }
        });

        nameInp.clear();
        ageInp.clear();
        weightInp.clear();
        heightInp.clear();

        myGridPane.add(nameLabel, 0,0);
        myGridPane.add(nameInp, 1, 0);

        myGridPane.add(ageLbl, 0, 1);
        myGridPane.add(ageInp, 1, 1);
        
        myGridPane.add(weightLbl, 0, 2);
        myGridPane.add(weightInp, 1, 2);
        
        myGridPane.add(heightLbl, 0, 3);
        myGridPane.add(heightInp, 1, 3);

        myGridPane.add(nextBtn, 0, 4, 2, 1);

        GridPane.setHalignment(nextBtn, HPos.CENTER);

    }

    public static void main(String[] args) {

        Application.launch(App.class , args);
    }
}