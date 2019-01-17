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
    private TableColumn<Persons,String> columnFirstName;
    @FXML
    private TableColumn<Persons,String> columnSecondName;
    @FXML
    private TableColumn<Persons,String> columnMiddleName;
    @FXML
    private TableColumn<Persons,String> columnPosition;
    @FXML
    private TableColumn<Persons,String> columnPhone;
    @FXML
    private TableColumn<Persons,String> columnDepartment;
    @FXML
    private TableColumn<Persons,String> columnEmail;


    private ObservableList<Persons> observableList = FXCollections.observableArrayList();
            //new Persons("A", "b",            "c", "57", "engin"));


    private TableCell tableCell;
    private String drv = "org.postgresql.Driver";
    private String url= "jdbc:postgresql://localhost:5433/postgres";
    private String userNameDB = "postgres";
    private String password = "postgre";
    private Connection connection ;
    private Statement statement ;
    private ResultSet resultSet ;

    public void initialize(URL Location, ResourceBundle resourceBundle) {

        //dB();
        //setTableCell();


        columnFirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        columnSecondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        columnMiddleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        columnPosition.setCellValueFactory(new PropertyValueFactory<>("position"));
        columnPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        columnDepartment.setCellValueFactory(new PropertyValueFactory<>("department"));
        columnEmail.setCellValueFactory(new PropertyValueFactory<>("email"));

        ObservableList<Persons> list = getUserList();
        tablePerson.setItems(list);
        tablePerson.getColumns().addAll(columnFirstName,columnSecondName,columnMiddleName,columnPosition,columnEmail,columnDepartment,columnPhone);

        tablePerson.setItems(observableList);
    }

    private ObservableList<Persons> getUserList (){
        Persons person1 = new Persons("Ivanov","Ivan", "Ivanovich","Бухгалтерия","bux@mail.ru", "Бухгалтер", "34265432");
        Persons person2 = new Persons("Petrov", "Aleksei", "Ivanovich", "Закупки", "zakyp@mail.ru", "Specialist", "890002");
        ObservableList<Persons> list = FXCollections.observableArrayList(person1,person2);
        return list;
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
                //observableList.add(new Persons(firstNameDB));
               //observableList.add(new Persons(firstNameDB, "2","3","qwe","eng"));
               // firstName.setCellValueFactory(new PropertyValueFactory<>(firstNameDB));
            }
            //columnfirstName.setCellValueFactory(new PropertyValueFactory<>("firstName"));
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
        //secondName.setCellValueFactory(new PropertyValueFactory<>("secondName"));
        //middleName.setCellValueFactory(new PropertyValueFactory<>("middleName"));
        tablePerson.setItems(observableList);
    }

}
