package com.company.Controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ChatController implements Initializable {

    @FXML
    private Button exit_BT_Page2;
    
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        exit_BT_Page2.setOnAction(e -> {
            ( (Stage) exit_BT_Page2.getScene().getWindow() ).close();
        });

    }
}
