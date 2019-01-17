package controllers;

import Util.MyDialog;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.util.Pair;

import java.io.IOException;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;
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
    private TitledPane equipment;
    @FXML
    private TitledPane report;
    @FXML
    private Button btnGetDepartment;
    @FXML
    private  Button btnGraph;
    @FXML
    private MenuItem login;
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
        equipment.setDisable(active);
        report.setDisable(active);
    }

    @FXML
    private void loginUser (ActionEvent event){
        System.out.println("Hello");
        // Create the custom dialog.
        Dialog<Pair<String, String>> dialog = new Dialog<>();
        dialog.setTitle("Login Dialog");
        dialog.setHeaderText("Look, a Custom Login Dialog");

// Set the icon (must be included in the project).
        //dialog.setGraphic(new ImageView(this.getClass().getResource("login.png").toString()));

// Set the button types.
        ButtonType loginButtonType = new ButtonType("Login", ButtonBar.ButtonData.OK_DONE);
        dialog.getDialogPane().getButtonTypes().addAll(loginButtonType, ButtonType.CANCEL);

// Create the username and password labels and fields.
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20, 150, 10, 10));

        TextField username = new TextField();
        username.setPromptText("Username");
        PasswordField password = new PasswordField();
        password.setPromptText("Password");

        grid.add(new Label("Username:"), 0, 0);
        grid.add(username, 1, 0);
        grid.add(new Label("Password:"), 0, 1);
        grid.add(password, 1, 1);

// Enable/Disable login button depending on whether a username was entered.
        Node loginButton = dialog.getDialogPane().lookupButton(loginButtonType);
        loginButton.setDisable(true);

// Do some validation (using the Java 8 lambda syntax).
        username.textProperty().addListener((observable, oldValue, newValue) -> {

            loginButton.setDisable(newValue.trim().isEmpty());
        });

        dialog.getDialogPane().setContent(grid);

// Request focus on the username field by default.
        Platform.runLater(() -> username.requestFocus());

// Convert the result to a username-password-pair when the login button is clicked.
        dialog.setResultConverter(dialogButton -> {
            if (dialogButton == loginButtonType) {
                return new Pair<>(username.getText(), password.getText());
            }
            return null;
        });

        Optional<Pair<String, String>> result = dialog.showAndWait();
        //TODO Autorization with DB
        result.ifPresent(usernamePassword -> {
            if (usernamePassword.getValue().contains("ADMIN") & usernamePassword.getKey().contains("admin")) {
                expandedMenu(false);
                System.out.println("Username=" + usernamePassword.getKey() + ", Password=" + usernamePassword.getValue());
            } else {
                report.setDisable(false);
                System.exit(0);
            }
        });

    }

    @FXML
    private void logoutUser(ActionEvent event){
        expandedMenu(true);
    }

    //Clear anchorToChange
    private void clear() {
        anchorToChange.getChildren().clear();
    }

    @FXML
    private void addDepartmentUnit(MouseEvent event) throws IOException{

        Stage stage = (Stage) anchorToChange.getScene().getWindow();
        Stage myDialog = new MyDialog(stage, "Hello", "Hi", 5);
        myDialog.sizeToScene();
        myDialog.show();
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
