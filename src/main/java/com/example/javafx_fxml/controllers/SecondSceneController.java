package com.example.javafx_fxml.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import javafx.stage.Stage;
import org.apache.commons.io.FilenameUtils;
import javafx.scene.input.MouseEvent;
import java.io.File;
import java.io.IOException;


public class SecondSceneController {
    @FXML
    private Label firstTeamLabel;
    @FXML
    private Label secondTeamLabel;
    @FXML
    private Label songNameLabelTeam1;
    @FXML
    private Label songNameLabelTeam2;
    private Stage stage;
    private Scene scene;
    private Parent root;
    private MediaPlayer mediaPlayerTeam1;
    private MediaPlayer mediaPlayerTeam2;
    private File file;
    private final FileChooser fileChooser = new FileChooser();

    public void setTeams(String firstTeamsName, String secondTeamsName) {
        firstTeamLabel.setText(firstTeamsName);
        secondTeamLabel.setText(secondTeamsName);
    }

    @FXML
    void editMusicTeam1(MouseEvent event) {
        fileChooser.setTitle("select your music for team 1");
        file = fileChooser.showOpenDialog(null);
        if(file != null){
            String selected = file.toURI().toString();
            Media media = new Media(selected);
            mediaPlayerTeam1 = new MediaPlayer(media);
            mediaPlayerTeam1.setOnReady(() ->songNameLabelTeam1.setText(FilenameUtils.removeExtension(file.getName())));
        }
    }

    @FXML
    void editMusicTeam2(MouseEvent event) {
        fileChooser.setTitle("select your music for team 2");
        file = fileChooser.showOpenDialog(null);
        if(file != null){
            String selected = file.toURI().toString();
            Media media = new Media(selected);
            mediaPlayerTeam2 = new MediaPlayer(media);
            mediaPlayerTeam2.setOnReady(() ->songNameLabelTeam2.setText(FilenameUtils.removeExtension(file.getName())));
        }
    }

    @FXML
    void playMusicTeam1(MouseEvent event) {
        if(mediaPlayerTeam2 != null)mediaPlayerTeam2.stop();
        mediaPlayerTeam1.play();
    }

    @FXML
    public void playMusicTeam2(MouseEvent event) {
        if(mediaPlayerTeam1 != null)mediaPlayerTeam1.stop();
        mediaPlayerTeam2.play();
    }

    @FXML
    void stopMusicTeam1(MouseEvent event) {
        mediaPlayerTeam1.stop();
    }

    @FXML
    void stopMusicTeam2(MouseEvent event) {
        mediaPlayerTeam2.stop();
    }

    @FXML
    void backToTeams(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/Scene1.fxml"));
        root = loader.load();

        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);

        stage.setResizable(false);

        stage.show();
    }
}
