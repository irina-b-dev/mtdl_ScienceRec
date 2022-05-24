package com.example.sciencerec;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GUIHandler
{


    Stage stage;
    FXMLLoader fxmlLoader;

    ArrayList<Controller> controllers = new ArrayList<>();
    public GUIHandler(Stage s) {
        stage = s;

    }

    public void init(){
        LoginController c = new LoginController(this);
        controllers.add(c);
        this.changeScene(Scenes.LOGIN);
        c.init();
//         fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
//        Scene scene = null;
//        try {
//            scene = new Scene(fxmlLoader.load(), 600, 480);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//        stage.setTitle("Hello!");
//        stage.setScene(scene);
        stage.show();
    }
    public void changeScene(Scenes s){

        String resource;
        String title;
        switch (s){
            case LOGIN: {
                resource = "login.fxml";
                title = "login";
                break;
            }
            case LOGOUT: {
                resource = "login.fxml";
                title = "logout";
                break;
            }
            case MAIN_PAGE: {
                resource = "main_page.fxml";
                title = "welcome";
                break;
            }
            case ARTICLES:
            {
                resource = "ArticleList.fxml";
                title = "your lists";
                break;
            }
            default: {
                resource = "login.fxml";
                title = "login";
                break;
            }

        }

        fxmlLoader = new FXMLLoader(App.class.getResource(resource));
        Scene scene = null;
        try {
            scene = new Scene(fxmlLoader.load(), 600, 480);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle(title);
        stage.setScene(scene);

    }
}
