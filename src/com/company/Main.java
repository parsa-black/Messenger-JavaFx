package com.company;

import com.company.Controller.DBUser;
import com.company.Model.User;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.sql.SQLException;
import java.util.ArrayList;

public class Main extends Application{

    public static void main(String[] args) {
        launch(args);
    }


    @Override
    public void start(Stage stage) throws Exception {
        HBox root = FXMLLoader.load(this.getClass().getResource("/com/company/View/LoginView.fxml"));

        stage.setTitle("Messenger");
        stage.setScene(new Scene(root));
        stage.show();
    }
}
