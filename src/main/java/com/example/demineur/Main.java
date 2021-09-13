package com.example.demineur;

import com.example.demineur.caseElements.Case;
import com.example.demineur.caseElements.TableGenerator;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.ArrayList;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {

        TableGenerator tableGenerator = new TableGenerator();
        int y = (int) (Math.random() * (6 - 0) + 4);
        int x = tableGenerator.calculateLargeur(y);
        int numberOfMine = x * y / 8;
        ArrayList<Case> generatedCases = tableGenerator.generate(x, y, numberOfMine);

        /*
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Demineur");
        Scene scene = new Scene(root, 500, 575);
        Stage stage = new Stage();
        stage.setX(50);
        stage.setY(50);
        stage.setScene(scene);
        stage.show();
        //primaryStage.setScene();
        //primaryStage.show();

         */

        GridPane gridpane = new GridPane();


        for (Case item : generatedCases) {
            item.setWidth(30); //setting the width of rectangle
            item.setHeight(30);
            item.setFill(Color.LIGHTGRAY);
            item.setStroke(Color.BLACK);
            gridpane.add(item, item.getPosition().getX(), item.getPosition().getY());
        }

        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Demineur");
        Scene scene = new Scene(gridpane, 30 * x, 30 * y);
        primaryStage.setScene(scene);
        primaryStage.show();


    }


    public static void main(String[] args) {
        launch(args);
    }

}
