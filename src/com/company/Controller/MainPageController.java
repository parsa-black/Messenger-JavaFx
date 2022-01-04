package com.company.Controller;

import com.company.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
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
    private Button chatBT;

    @FXML
    private Button groupBT;

    @FXML
    private Button channelBT;

    @FXML
    private Button contactBT;

    @FXML
    private Button settingBT;


    @FXML
     Label nameLBL;

    static Stage logoutStage = null;

    static Stage stage ;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        exitBT.setOnAction(e -> ( (Stage) exitBT.getScene().getWindow() ).close());

        logoutBT.setOnAction(e ->{
            ( (Stage) exitBT.getScene().getWindow() ).close();
            try {
                if (logoutStage  == null){
                    HBox root = FXMLLoader.load(this.getClass().getResource("../View/LoginView.fxml"));
                    logoutStage = new Stage();
                    logoutStage.setTitle("Go To LogInPage");
                    logoutStage.setScene(new Scene(root));
                    logoutStage.show();
                }
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });


        chatBT.setOnAction(e -> {
                AnchorPane root = null;
                try {
                    root = FXMLLoader.load(this.getClass().getResource("../View/ChatPageView.fxml"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
                stage = new Stage();
                stage.setTitle("register user");
                stage.setScene(new Scene(root));
                stage.show();

        });


    }

}
