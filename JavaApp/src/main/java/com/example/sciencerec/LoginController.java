package com.example.sciencerec;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class LoginController extends Controller{
    @FXML
    private Label welcomeText;
    @FXML
    private Button logInButton ;

    public LoginController(GUIHandler gui) {
        super(gui);


    }

    public void init(){
//        logInButton.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
//
//            }
//        });

        //logInButton.setOnMouseClicked();
        logInButton.setOnAction(event -> {

           System.out.println("im crying");
        });
    }

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Login!");
    }

    @FXML
    protected void onLogInButtonClick() {

    }
}
