package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Observable;

public class  CustomerFormController {
    public TextField txtId;
    public TextField txtPhone;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtEmail;
    public TableColumn colId;
    public TableColumn colName;
    public TableColumn colEmail;
    public TableColumn colPhone;
    public TableColumn colAddress;
    public TableColumn colSalary;
    public TableView tblCustomers;
    ArrayList<Customer> customerList = new ArrayList<>();

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        customerList.add(new Customer(Integer.parseInt(txtId.getText()),txtName.getText(),txtEmail.getText(),txtAddress.getText(),txtPhone.getText(),Double.parseDouble(txtSalary.getText())));
        btnReloadOnAction(actionEvent);
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        customerList.forEach(customer -> {
            customerObservableList.add(customer);
        });
        tblCustomers.setItems(customerObservableList);
    }
}
