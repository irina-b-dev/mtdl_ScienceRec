package com.example.sciencerec;

import com.example.sciencerec.Controller;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class ViewArticleController extends Controller {

    public Button BackButton;

    public void init(){
        super.init();

        System.out.println("initialised main_menu");


    }

    @FXML
    public void onBackClicked(ActionEvent event){
        System.out.println("button back");
        gui.changeScene(Scenes.MAIN_PAGE);
    }


}
