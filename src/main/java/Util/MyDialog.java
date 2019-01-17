package Util;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class MyDialog extends Stage {

    public MyDialog(Stage owner,String textButtOne, String textButtTwo, int n ) {

        super();
        initOwner(owner);
        setTitle("AddDepartment");
        Group root = new Group();
        Scene scene = new Scene(root, 250, 150, Color.WHITE);
        setScene(scene);

        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        List<Label> list = new ArrayList<>(n);


        Label userNameLbl = new Label("Name Department: ");
        gridpane.add(userNameLbl, 0, 1);

        final TextField userNameFld = new TextField("Depsrtment");
        gridpane.add(userNameFld, 1, 1);

        Button first = new Button("Add");
        first.setOnAction(new EventHandler<ActionEvent>() {

            public void handle(ActionEvent event) {
                close();
            }
        });


        gridpane.add(first, 1, 3);
        GridPane.setHalignment(first, HPos.RIGHT);
        root.getChildren().add(gridpane);
    }
}