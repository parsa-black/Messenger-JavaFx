package com.company.Controller;


import com.company.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class LoginController  implements Initializable {

    @FXML
    private Button button_singup;

    @FXML
    private Button button_login;

    @FXML
    private TextField tf_username;

    @FXML
    private TextField tf_password;

    @FXML
    private Label checkLBL;


    static Stage registerStage = null; //we need open once


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        checkLBL.setText("");

        button_singup.setOnAction(e -> {
            try {
                openRegisterPage();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });

        button_login.setOnAction(e -> {
            LoginBTN();
        });

    }

    private void openRegisterPage() throws IOException {
        if (registerStage  == null){
            HBox root = FXMLLoader.load(this.getClass().getResource("../View/RegisterView.fxml"));
            registerStage = new Stage();
            registerStage.setTitle("register user");
            registerStage.setScene(new Scene(root));
            registerStage.show();
        }

    }

    private void LoginBTN(){
        if (checkAllFiled()){
            User user = getUserWithUserName(tf_username.getText());
            if (user != null){
                if (checkPassWord(tf_password.getText(),user)){
                    try {
                        loadMainPage();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                else {
                    checkLBL.setText("PassWord Incorrect");
                }
            }
            else {
                checkLBL.setText("User Not Found!");
            }

        }
    }


    private boolean checkAllFiled(){
        if (tf_username.getText().isEmpty() || tf_password.getText().isEmpty()){
            checkLBL.setText("Please Fill Up The Form");
            return false;
        }
        return true;
    }

    private User getUserWithUserName(String userName){
        ArrayList<User> users = User.getAllUsers();

        for (User user : users){
            if (user.getUsername().equals(userName))
                return user;
        }
        return null;
    }

    private boolean checkPassWord(String PassWord, User USER){
        return  PassWord.equals(USER.getPassword());
    }

    private void loadMainPage() throws IOException {
        AnchorPane root = FXMLLoader.load(this.getClass().getResource("../View/MainPageView.fxml"));
        Stage stage = (Stage) button_login.getScene().getWindow();
        stage.setScene(new Scene(root));

        stage.show();
    }
}
