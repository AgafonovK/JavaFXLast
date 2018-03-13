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

    @FXML
    private MenuBar menuBar;
    @FXML
    private Menu file;
    @FXML
    private MenuItem close;
    @FXML
    private Menu edit;
    @FXML
    private MenuItem delete;
    @FXML
    private Menu help;
    @FXML
    private MenuItem about;
    @FXML
    private SplitPane splitPane;
    @FXML
    private Button btnDepartment;
    @FXML
    private  Button btnGraph;
    @FXML
    private AnchorPane anchorToChange;



    public void initialize(URL location, ResourceBundle resources) {
    }

    //Clear anchorToChange
    private void clear() throws IOException {
        anchorToChange.getChildren().clear();
    }
    
    @FXML
    private void setDepartmentUnit(MouseEvent event) throws IOException {
        loadUI();
    }

    @FXML
    private void loadUI() throws IOException {
        clear();
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/departmentUnit.fxml"));
        anchorToChange.getChildren().add(root);
    }

    @FXML
    private  void loadGraph () throws IOException{
        clear();
        Parent root = null;
        root = FXMLLoader.load(getClass().getResource("/graphics.fxml"));
        anchorToChange.getChildren().add(root);

    }


}
