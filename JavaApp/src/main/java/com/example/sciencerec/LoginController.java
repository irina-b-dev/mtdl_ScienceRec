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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;

import java.io.IOException;

public class LoginController extends Controller
{
    private static User user;
    @FXML
    TextField email;
    @FXML
    PasswordField password;
    @FXML
    Button logInButton;

    public void init(User u)
    {
        super.init();

        user = u;

        System.out.println("initialised login");
    }

    @FXML
    public void onLogInButtonClicked(ActionEvent event)
    {
        System.out.println("log in button clicked");

        User check = user.getDatabase().connectUser(email.getText(), password.getText());

        if(check != null)
        {
            user = check;
            gui.changeScene(Scenes.MAIN_PAGE);
        }
        else
        {
            System.out.println("invalid login credentials");
        }
    }
}
