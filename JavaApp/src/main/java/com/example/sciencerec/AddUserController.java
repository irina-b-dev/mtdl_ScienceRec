package com.example.sciencerec;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class AddUserController extends  Controller{
    public TextField usernameInput;
    public PasswordField passwordInput;
    public Button AddUserButton;

    @Override
    public void init() {
        super.init();


    }

    public void onAddUserClicked(ActionEvent event) {
        String uname = usernameInput.getText();
        String pw = passwordInput.getText();
        App.getUser().getDatabase().createUser(userTypes.STUDENT,uname,pw);
        GUIHandler.guiHandle().changeScene(Scenes.MAIN_PAGE);
    }

    public void onBackClicked(ActionEvent event) {
        GUIHandler.guiHandle().changeScene(Scenes.MAIN_PAGE);
    }
}
