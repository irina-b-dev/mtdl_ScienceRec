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

    }

    @FXML
    public void onLogInButtonClicked(ActionEvent event){
        System.out.println("button clicked 2");
        gui.changeScene(Scenes.MAIN_PAGE);
    }

}
