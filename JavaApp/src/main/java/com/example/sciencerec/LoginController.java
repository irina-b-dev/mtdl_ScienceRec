package com.example.sciencerec;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginController extends Controller{

    @FXML
    Button logInButton;
    public void init(){
        super.init();

        System.out.println("initialised login");
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("login.fxml"));
//        try {
//            Parent root = loader.load();
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        Button buttonLogIn = (Button) loader.getNamespace().get("logInButton");
//        System.out.println(buttonLogIn);
//        buttonLogIn.setLayoutX(-400.5);
//
//        buttonLogIn.setStyle("-fx-font: 42 arial; -fx-base: #b6e7c9;");
//        buttonLogIn.setOnMouseClicked(e -> {
//            if (e.getButton() == MouseButton.PRIMARY) {
//                System.out.println("button clicked");
//            }
//        });
//
//        gui.changeScene(Scenes.LOGIN);
    }

    @FXML
    public void onLogInButtonClicked(ActionEvent event){
        System.out.println("button clicked 2");
        gui.changeScene(Scenes.MAIN_PAGE);
    }

}
