package controller;

import db.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Customer;
import java.util.ArrayList;

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

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        btnReloadOnAction(actionEvent);
        DBConnection.getInstance().getDBList().add(new Customer(Integer.parseInt(txtId.getText()),txtName.getText(),txtEmail.getText(),txtAddress.getText(),txtPhone.getText(),Double.parseDouble(txtSalary.getText())));
    }

    public void btnReloadOnAction(ActionEvent actionEvent) {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colEmail.setCellValueFactory(new PropertyValueFactory<>("email"));
        colPhone.setCellValueFactory(new PropertyValueFactory<>("phone"));
        colAddress.setCellValueFactory(new PropertyValueFactory<>("address"));
        colSalary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();
        DBConnection.getInstance().getDBList().forEach(customer -> {
            customerObservableList.add(customer);
        });
        tblCustomers.setItems(customerObservableList);
    }
}
