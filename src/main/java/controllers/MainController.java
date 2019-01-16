package controllers;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;




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
    private TitledPane workers;
    @FXML
    private TitledPane setting;
    @FXML
    private Button btnDepartment;
    @FXML
    private  Button btnGraph;
    @FXML
    private AnchorPane anchorToChange;

    //TIME ON LABEL IN BOTTOM
    @FXML
    private Label timeLabel;

    //formate the date
    private DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    private final Timeline timeLine = new Timeline(new KeyFrame(Duration.millis(1000),event -> {
        final long diff = System.currentTimeMillis();
        if (diff<0){
            timeLabel.setText("0");
        }
        else {
            timeLabel.setText(dateFormat.format(diff));
        }
    }));


    public void initialize(URL location, ResourceBundle resources) {

        //start time on label
        timeLine.setCycleCount(Animation.INDEFINITE);
        timeLine.play();
       // delete.setDisable(true);
        expandedMenu(true);
    }

    private void expandedMenu(Boolean active){
        workers.setDisable(active);
        setting.setDisable(active);
    }
    //Clear anchorToChange
    private void clear() {
        anchorToChange.getChildren().clear();
    }
    
    @FXML
    private void setDepartmentUnit(MouseEvent event) throws IOException {
        loadUI();
    }

    @FXML
    private void loadUI() throws IOException {
        clear();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/departmentUnit.fxml"));
        anchorToChange.getChildren().add(root);
    }

    @FXML
    private  void loadGraph () throws IOException{
        clear();
        Parent root;
        root = FXMLLoader.load(getClass().getResource("/graphics.fxml"));
        anchorToChange.getChildren().add(root);

    }


}
