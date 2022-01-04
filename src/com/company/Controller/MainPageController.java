package com.company.Controller;

import com.company.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MainPageController implements Initializable {

    @FXML
    private Button exitBT;

    @FXML
    private Button logoutBT;

    @FXML
     Label nameLBL;

    static Stage registerStage = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        exitBT.setOnAction(e -> ( (Stage) exitBT.getScene().getWindow() ).close());

        logoutBT.setOnAction(e ->{
            ( (Stage) exitBT.getScene().getWindow() ).close();
            try {
                if (registerStage  == null){
                    HBox root = FXMLLoader.load(this.getClass().getResource("../View/LoginView.fxml"));
                    registerStage = new Stage();
                    registerStage.setTitle("register user");
                    registerStage.setScene(new Scene(root));
                    registerStage.show();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


    }

}
