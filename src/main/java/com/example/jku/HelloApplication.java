package com.example.jku;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class HelloApplication extends Application {
    @FXML
    TextField Log;
    @FXML
    PasswordField Por;
    @FXML
    Button Enter;
    @FXML Button Back;
    @FXML
    Label Test;

    private String login = "1";
    private int pasword = 1;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Enter.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public void Enter1(ActionEvent actionEvent) throws IOException {
        if (Log.getText().equals(login) && Por.getText().equals(String.valueOf(pasword))) {
            Stage stageCLose = (Stage) Enter.getScene().getWindow();
            stageCLose.close();

            Stage stage = new Stage();
            FXMLLoader fxmlLoader = new FXMLLoader();
            Pane root = fxmlLoader.load(getClass().getResource("First.fxml").openStream());
            Scene scene = new Scene(root, 1200, 900);
            stage.setTitle("Учет спортивных тренировок");
            stage.setScene(scene);
            stage.show();


        }
        else {
            JOptionPane.showMessageDialog(null, "Вы ввели не верные данные!");
        }
    }

}