package com.company.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RegisterController  implements Initializable {

    @FXML
    private Button button_cancel;

    @FXML
    private Label errorLBL;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLBL.setText(" ");

        button_cancel.setOnAction(e -> closeStage());

    }

    private void closeStage(){
        ( (Stage) button_cancel.getScene().getWindow() ).close();

        LoginController.registerStage = null;

    }

}
