package com.company.Controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class SettingController implements Initializable {

    @FXML
    private Button exit_BT_Page;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exit_BT_Page.setOnAction(e -> {
            ( (Stage) exit_BT_Page.getScene().getWindow() ).close();
            MainPageController.stage = null;
        });

    }
}
