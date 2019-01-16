package controllers;

import Entity.Persons;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;

public class departmentUnitController implements Initializable {

    @FXML
    private TableView<Persons> tablePerson;
    @FXML
    private TableColumn<Persons,String> columnfirstName;
    @FXML
    private TableColumn<Persons,String> secondName;
    @FXML
    private TableColumn<Persons,String> middleName;
    @FXML
    private TableColumn department;
    @FXML
    private TableColumn position;
    @FXML
    private TableColumn phone;

    private ObservableList<Persons> observableList = FXCollections.observableArrayList();
            //new Persons("A", "b",            "c", "57", "engin"));


    private TableCell tableCell;
    private String drv = "org.postgresql.Driver";
    private String url= "jdbc:postgresql://localhost:5432/Test5";
    private String userNameDB = "postgres";
    private String password = "postgres";
    private Connection connection ;
    private Statement statement ;
    private ResultSet resultSet ;

    public void initialize(URL Location, ResourceBundle resourceBundle) {

        dB();
        //setTableCell();
    }

    public void dB() {
        try {
            Class.forName(drv);
            connection = connection = DriverManager.getConnection(url, userNameDB, password);
            System.out.println("Connection is enabled");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT first_name " + "FROM stuff;");
            while (resultSet.next()){

                String firstNameDB = resultSet.getString("first_name");
                System.out.println(firstNameDB);
                observableList.add(new Persons(firstNameDB));
               //observableList.add(new Persons(firstNameDB, "2","3","qwe","eng"));
               // firstName.setCellValueFactory(new PropertyValueFactory<>(firstNameDB));
            }
    columnfirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
            tablePerson.setItems(observableList);
            connection.close();
            statement.close();
            resultSet.close();

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    public void setTableCell() {

       // firstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        secondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        tablePerson.setItems(observableList);
    }

}
