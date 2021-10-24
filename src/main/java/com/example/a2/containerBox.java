package com.example.a2;

import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextInputDialog;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

import java.util.Timer;

public class containerBox {
    HBox box = new HBox();
    GridPane container = new GridPane();
    Label name;
    Label t = new Label("00:00");
    Timer time;
    CheckBox timeToggle;
    Button close;

    public Label getName() {
        return name;
    }


    public containerBox(String name) {
        this.name = new Label(name);
        this.name.setPadding(new Insets(15,0,5,15));
        this.name.setFont(Font.font("Verdana", FontWeight.BOLD,16));
        this.name.setTextFill(Color.rgb(107, 107, 107));

        this.t.setPadding(new Insets(0,0,0,15));
        this.t.setFont(Font.font("Verdana", FontWeight.BOLD,20));

        this.close = new Button("X");
        this.close.setFont(Font.font("Verdana", FontWeight.BOLD,5));
        this.close.setPadding(new Insets(6,6,6,6));

        this.close.setAlignment(Pos.CENTER);

        this.timeToggle = new CheckBox();
        this.timeToggle.setAlignment(Pos.CENTER);

        this.time = new Timer();
        container.setBackground((new Background(new BackgroundFill(Color.rgb(0, 253, 247), CornerRadii.EMPTY, Insets.EMPTY))));
        container.setPrefSize(160, 90);

        container.getColumnConstraints().add(new ColumnConstraints(140));
        container.add(this.name, 0,0);
        container.add(this.t, 0,1);
        container.add(this.timeToggle, 1,1);
        container.add(this.close, 1,2);

        close.setOnAction(event ->{
//            TextInputDialog delName = new TextInputDialog("ENTER NAME");
//            delName.setTitle("Remove Company");
//            delName.setHeaderText(null);
//            delName.setGraphic(null);
//            delName.showAndWait();
//            String dName = delName.getResult();

            for (Node child: container.getChildren()){
                System.out.println(child);
            }
        });
    }

}
