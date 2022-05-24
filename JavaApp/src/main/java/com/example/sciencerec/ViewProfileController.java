package com.example.sciencerec;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class ViewProfileController extends Controller {


    @FXML
    public void onBackClicked(ActionEvent event){
        System.out.println("button back");
        gui.changeScene(Scenes.MAIN_PAGE);
    }
}
