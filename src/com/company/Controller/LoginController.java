package com.company.Controller;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    @FXML
    Button button_singup;

    @FXML
    Button button_login;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        button_singup.setOnAction(e -> {
            try {
                openRegisterPage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

    }

    private void openRegisterPage() throws IOException {
        HBox root = FXMLLoader.load(this.getClass().getResource("../View/RegisterView.fxml"));
        Stage stage = new Stage();
        stage.setTitle("register user");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
