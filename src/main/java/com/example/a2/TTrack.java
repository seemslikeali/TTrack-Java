package com.example.a2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import java.util.ArrayList;


public class TTrack extends Application {
    @Override
    public void start(Stage stage){

        // Create MVC

        // Connect MVC


        // Layout

        // Navigation Bar
        HBox nav = new HBox();

        Button add = new Button("add");
        Button del = new Button("del");
        Button view = new Button("view");
        nav.getChildren().addAll(add, del, view);
        nav.setAlignment(Pos.BASELINE_CENTER);
        add.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        del.setFont(Font.font("Verdana", FontWeight.BOLD, 12));
        view.setFont(Font.font("Verdana", FontWeight.BOLD, 12));

        nav.maxHeight(10);
        nav.setBackground(new Background(new BackgroundFill(Color.rgb(255, 253, 247), CornerRadii.EMPTY, Insets.EMPTY)));
        nav.setPadding(new Insets(10, 10, 10, 10));
        nav.setSpacing(30);

        // Container (the one with all the boxes)
        HBox container = new HBox();
        container.setBackground(new Background(new BackgroundFill( Color.rgb(246, 0, 0), CornerRadii.EMPTY, Insets.EMPTY)));
        FlowPane flowPane = new FlowPane();

        flowPane.setPadding(new Insets(10, 10, 10, 10));
        flowPane.setAlignment(Pos.CENTER);
        container.setAlignment(Pos.CENTER);
        flowPane.setVgap(10);
        flowPane.setHgap(10);

        ArrayList<containerBox> holders = new ArrayList<>();

        // add button
        add.setOnAction(event -> {
            TextInputDialog companyName = new TextInputDialog("ENTER NAME");
            companyName.setTitle("Company Name");
            companyName.setHeaderText(null);
            companyName.setGraphic(null);
            companyName.showAndWait();
            String name = companyName.getResult();
            if (name == null){
                return;
            }

            containerBox newCompany = new containerBox(name);
            holders.add(0, newCompany);
            flowPane.getChildren().addAll(holders.get(0).container);
        });

        container.getChildren().add(flowPane);

        // remove button
        del.setOnAction(event ->{
            TextInputDialog delName = new TextInputDialog("ENTER NAME");
            delName.setTitle("Remove Company");
            delName.setHeaderText(null);
            delName.setGraphic(null);
            delName.showAndWait();
            String name = delName.getResult();
            
            for (Node child: flowPane.getChildren()){
                System.out.println(child);
            }
        });


        BorderPane root = new BorderPane();
        root.setTop(nav);
        root.setCenter(container);

        Scene scene = new Scene(root, 400, 600);
        stage.setTitle("TTrack");
        stage.setScene(scene);
        stage.show();
    }


    public static void main(String[] args) {
        launch();
    }
}