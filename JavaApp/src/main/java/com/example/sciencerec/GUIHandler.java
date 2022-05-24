package com.example.sciencerec;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.io.IOException;
import java.util.ArrayList;



public class GUIHandler
{

    private static GUIHandler guiHandler = new GUIHandler();
    Stage stage;
    FXMLLoader fxmlLoader;
    JMetro jMetro;

    ArrayList<Controller> controllers = new ArrayList<>();
    Controller currentController;
    private GUIHandler() {
        jMetro = new JMetro(Style.LIGHT);

    }

    public static GUIHandler guiHandle(){
        return  guiHandler;
    }

    public void init(Stage s){
        System.out.println("is in init");
        stage = s;
        LoginController c = new LoginController();
        controllers.add(c);
        currentController = c;
        this.changeScene(Scenes.LOGIN);
        c.init();
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
                currentController = new ArticleListsController();

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
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle(title);

        jMetro.setScene(scene); ///always call before stage.setScene
        stage.setScene(scene);
        stage.show();

        currentController.init();
        currentController.afterInit();


    }
}
