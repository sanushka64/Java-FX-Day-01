package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {

    public TextField txtEmail;
    public PasswordField txtPassword;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void btnloginOnAAction(ActionEvent actionEvent) throws IOException {
        final String txtEmail1 = "saman@gmail.com";
        final String txtPassword1 = "123";
        String email = txtEmail.getText();
        String password = txtPassword.getText();

        if(txtEmail1.equals(email) && txtPassword1.equals(password)){
            new Alert(Alert.AlertType.CONFIRMATION,"Login Success...").show();
            Stage stage = new Stage();
            stage.setScene(new Scene(FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/view/customer_form.fxml")))));
            stage.show();
        }else{
            new Alert(Alert.AlertType.ERROR,"Login Failed...").show();
        }
        User user = new User(email,password);
        System.out.println(user);
    }
}
