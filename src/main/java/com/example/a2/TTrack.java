package com.example.a2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;
import java.util.Timer;


public class TTrack extends Application {
    @Override
    public void start(Stage stage){

        // Layout
        // Navigation Bar
        HBox nav = new HBox();

        Button add = new Button("add");
        Button del = new Button("del");
        Button view = new Button("view");

        nav.getChildren().addAll(add,  del, view);
        nav.setAlignment(Pos.BASELINE_CENTER);
        add.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        del.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        view.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        nav.maxHeight(10);
        nav.setBackground(new Background(new BackgroundFill(Color.rgb(255, 253, 247), CornerRadii.EMPTY, Insets.EMPTY)));
        nav.setStyle("-fx-border-color: black;-fx-border-width: 0.1;");
        nav.setPadding(new Insets(10, 10, 10, 10));
        nav.setSpacing(30);

        // Container (the one with all the boxes)
        FlowPane flowPane = new FlowPane(); // contains all the boxes of companies we add
        // some styling
        flowPane.setPadding(new Insets(15, 15, 15, 15));
        flowPane.setAlignment(Pos.CENTER);
//        container.setAlignment(Pos.CENTER);
        flowPane.setVgap(10);
        flowPane.setHgap(10);


        // add button
        add.setOnAction(event -> {
            HBox box = new HBox(); // create a new hbox to put everything in
            TextInputDialog companyName = new TextInputDialog("ENTER NAME");
            companyName.setTitle("Company Name");
            companyName.setHeaderText(null);
            companyName.setGraphic(null);
            companyName.showAndWait();
            String name = companyName.getResult();
            if (name == null){
                return;
            }


            GridPane containerItem = new GridPane();
            Label lname = new Label(name);
            Label t = new Label("00:00");
            CheckBox timeToggle;
            Button close;

            lname.setPadding(new Insets(15,0,5,15));
            lname.setFont(Font.font("Verdana", FontWeight.BOLD,16));
            lname.setTextFill(Color.rgb(107, 107, 107));

            t.setPadding(new Insets(0,0,0,15));
            t.setFont(Font.font("Verdana", FontWeight.BOLD,20));

            close = new Button("-");
            close.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
            close.setPadding(new Insets(5,5,5,5));

            close.setAlignment(Pos.CENTER);

            timeToggle = new CheckBox();
            timeToggle.setStyle("-fx-background-color: transparent;");
            timeToggle.setAlignment(Pos.CENTER);

            containerItem.setBackground((new Background(new BackgroundFill(Color.rgb(255, 249, 249), new CornerRadii(8), Insets.EMPTY))));
            containerItem.setStyle("-fx-border-color: black; -fx-border-radius: 8; -fx-border-width: 0.1;");
            containerItem.setPrefSize(160, 90);

            containerItem.getColumnConstraints().add(new ColumnConstraints(140));
            containerItem.add(lname, 0,0);
            containerItem.add(t, 0,1);
            containerItem.add(timeToggle, 1,1);
            containerItem.add(close, 0,2);

            box.getChildren().add(containerItem);
            flowPane.getChildren().add(box);

            close.setOnAction(e -> {
                flowPane.getChildren().remove(box);
            });
        });




        // remove button
        del.setOnAction(event ->{
           TextInputDialog delName = new TextInputDialog("ENTER NAME");
           delName.setTitle("Remove Company");
           delName.setHeaderText(null);
           delName.setGraphic(null);
           delName.showAndWait();
           String name = delName.getResult();

            for (Node child: flowPane.getChildren()){
                System.out.println(child.toString());
            }
        });


        BorderPane root = new BorderPane();
        root.setTop(nav);
        root.setCenter(flowPane);
        Scene scene = new Scene(root, 400, 600);
        stage.setTitle("TTrack");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}