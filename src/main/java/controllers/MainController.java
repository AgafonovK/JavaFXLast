package controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

@org.springframework.stereotype.Controller


public class MainController implements Initializable {

    @FXML private MenuBar menuBar;

    @FXML private Menu file;

    @FXML private MenuItem close;

    @FXML private Menu edit;
    @FXML private  MenuItem delete;

    @FXML private Menu help;

    @FXML private MenuItem about;
    @FXML private SplitPane splitPane;
    @FXML private Button btnDepartment;

    @FXML private AnchorPane anchorToChange;
    //@FXML private




    public void initialize(URL location, ResourceBundle resources) {

    }

    @FXML
    private void departmentUnit (MouseEvent event){
            loadUI();
    }

    private void loadUI (){
        Parent root=null;
        try {
          root =  FXMLLoader.load(getClass().getResource("/departmentUnit.fxml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        anchorToChange.setClip(root);

    }
}
