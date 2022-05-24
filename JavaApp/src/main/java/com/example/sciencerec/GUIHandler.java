package com.example.sciencerec;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class GUIHandler
{

    private static GUIHandler guiHandler = new GUIHandler();
    Stage stage;
    FXMLLoader fxmlLoader;

    ArrayList<Controller> controllers = new ArrayList<>();
    private GUIHandler() {}

    public static GUIHandler guiHandle(){
        return  guiHandler;
    }

    public void init(Stage s){
        System.out.println("is in init");
        stage = s;
        LoginController c = new LoginController();
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
        System.out.println("im here 1");
        stage.show();
        System.out.println("im here 2");

    }
}
