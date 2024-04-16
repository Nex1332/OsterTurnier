package com.example.javafx_fxml.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class FirstSceneController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TextField textField1;
    @FXML
    private TextField textField2;

    public void forward(ActionEvent e) throws IOException {
        String firstTeamsName = textField1.getText();
        String secondTeamsName = textField2.getText();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene2.fxml"));
        root = loader.load();

        SecondSceneController scene2Controller = loader.getController();
        scene2Controller.setTeams(firstTeamsName, secondTeamsName);

        stage = (Stage)((Node)e.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.setResizable(false);

        stage.show();
    }
}