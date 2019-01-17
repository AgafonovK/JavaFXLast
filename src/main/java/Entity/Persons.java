package Entity;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persons {

    private String firstName;// = new SimpleStringProperty("");
    private String secondName; //= new SimpleStringProperty("");
    private String middleName; //= new SimpleStringProperty("");
    private String department; //= new SimpleStringProperty();
    private String email;
    private String position;
    private String phone;

    public Persons() {
    }

    public Persons(String firstName, String secondName, String middleName, String department, String email, String position, String phone) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.middleName = middleName;
        this.department = department;
        this.email = email;
        this.position = position;
        this.phone = phone;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
/*


    public Persons(String firstName, String secondName, String middleName, String department, String email, String position, String phone){
    setFirstName(firstName);
    setSecondName(secondName);
    setMiddleName(middleName);
    setDepartment(department);
    setEmail(email);
    setPosition(position);
    setPhone(phone);
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
*/