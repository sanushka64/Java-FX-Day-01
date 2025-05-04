package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.TextField;

public class  CustomerFormController {
    public TextField txtId;
    public TextField txtPhone;
    public TextField txtAddress;
    public TextField txtName;
    public TextField txtSalary;
    public TextField txtEmail;

    public void btnAddCustomerOnAction(ActionEvent actionEvent) {
        System.out.println("click");
    }
}
