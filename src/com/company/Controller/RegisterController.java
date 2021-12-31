package com.company.Controller;

import com.company.Model.User;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class RegisterController  implements Initializable {

    @FXML
    private Button button_cancel;

    @FXML
    private Button button_register;

    @FXML
    private Label errorLBL;

    @FXML
    private TextField tf_user_name;

    @FXML
    private TextField tf_pass_word;

    @FXML
    private TextField tf_pass_word_2;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_lastname;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        errorLBL.setText(" ");

        button_cancel.setOnAction(e -> closeStage());

        button_register.setOnAction(e -> createUser());

    }

    private void closeStage(){
        ( (Stage) button_cancel.getScene().getWindow() ).close();

        LoginController.registerStage = null;

    }

    private void createUser(){

        if (checkAllField()){
            if (checkUserName()){
                if (checkPassword()){
                    User user = new User(tf_user_name.getText(),tf_name.getText(),tf_lastname.getText(),tf_pass_word.getText());
                    user.save();
                    cleanPage();
                }

            }
        }

    }

    private boolean checkAllField(){
        if (tf_user_name.getText().isEmpty() || tf_pass_word.getText().isEmpty() ||
                tf_name.getText().isEmpty() || tf_lastname.getText().isEmpty() || tf_pass_word_2.getText().isEmpty()){
            errorLBL.setText("Please fill up the form");
            return false;
        }
        return true;
    }

    private boolean checkUserName(){
        ArrayList<User> users = User.getAllUsers();

        for (User user : users){
            if (user.getUsername().equals(tf_user_name.getText())){
                errorLBL.setText("This UserName Is Already Taken");
                return false;
            }
        }
        return true;
    }

    private boolean checkPassword(){
        if (!tf_pass_word.getText().equals(tf_pass_word_2.getText())){
            errorLBL.setText("Password Is Not Matched");
            return false;
        }
        return true;
    }

    private void cleanPage(){
        tf_user_name.setText("");
        tf_name.setText("");
        tf_lastname.setText("");
        tf_pass_word.setText("");
        tf_pass_word_2.setText("");
        errorLBL.setText("");
    }

}
