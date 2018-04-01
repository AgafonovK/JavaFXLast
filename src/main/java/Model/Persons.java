package Model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.util.List;

public class Persons  {

    private SimpleStringProperty firstName = new SimpleStringProperty("");
    private SimpleStringProperty secondName = new SimpleStringProperty("");
    private SimpleStringProperty middleName = new SimpleStringProperty("");
    private StringProperty department;
    private StringProperty email;
    private StringProperty position;
    private StringProperty phone;


    public Persons (){
        this("");//,"","");
    }

    public Persons(String firstName){//}, String secondName, String middleName){
    setFirstName(firstName);
    //setSecondName(secondName);
    //setMiddleName(middleName);
    }



    public String getEmail(){
        return email.get();
    }
    public void setEmail(String email){
        this.email.set(email);
    }

    public StringProperty emailProperty() {
        return email;
    }

    public StringProperty positionProperty() {
        return position;
    }

    public String getPosition() {
        return position.get();
    }

    public void setPosition(String position) {
        this.position.set(position);
    }
    public StringProperty phone(){
        return phone;
    }
    public String getPhone(){
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }
    public StringProperty firstNameProperty() {
        return firstName;
    }
    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        this.firstName.set(fName);
    }

    public StringProperty secondNameProperty() {
        return secondName;
    }

    public String getSecondName() {
        return secondName.get();
    }

    public void setSecondName(String secondName) {
        this.secondName.set(secondName);
    }

    public StringProperty middleNameProperty() {
        return middleName;
    }

    public String getMiddleName (){
        return middleName.get();
    }

    public void setMiddleName (String middleName){
        this.middleName.set(middleName);
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public String getDepartment() {
        return department.get();
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }
}
