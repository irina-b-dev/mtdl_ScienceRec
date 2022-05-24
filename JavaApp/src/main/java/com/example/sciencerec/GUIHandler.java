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
    private static User user;//so that its methods can be accessed from everywhere else
    Stage stage;
    FXMLLoader fxmlLoader;
    JMetro jMetro;

    ArrayList<Controller> controllers = new ArrayList<>();
    Controller currentController;

    private GUIHandler()
    {
        jMetro = new JMetro(Style.LIGHT);
    }

    public static GUIHandler guiHandle(){return guiHandler;}

    public static User getUser(){return user;}

    public void init(Stage s, User u)
    {
        System.out.println("initialising guihandler: " + s.getTitle());
        user = u;
        stage = s;
        LoginController c = new LoginController();
        controllers.add(c);
        currentController = c;
        this.changeScene(Scenes.LOGIN);
        c.init();
        stage.show();
        System.out.println("initialised");
    }

    public void changeScene(Scenes s)
    {
        String resource;
        String title;

        switch (s){
            case LOGIN: {
                resource = "login.fxml";
                title = "login";
                currentController = new LoginController();
                break;
            }
            case LOGOUT: {
                resource = "login.fxml";
                title = "logout";
                currentController = new LoginController();
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
            case ADD_ARTICLES:
            {
                resource = "AddArticles.fxml";
                title = "add article";
                break;
            }

            case VIEW_ARTICLE:{
                resource = "viewArticle.fxml";
                title = "view article";
                break;
            }

            default: {
                resource = "login.fxml";
                title = "login";
                currentController = new LoginController();
                break;
            }

        }

        fxmlLoader = new FXMLLoader(App.class.getResource(resource));
        Scene scene = null;
        try
        {
            scene = new Scene(fxmlLoader.load(), 1000, 700);
        }
        catch (IOException e)
        {
            throw new RuntimeException(e);
        }

        stage.setTitle(title);
        jMetro.setScene(scene); ///always call before stage.setScene
        stage.setScene(scene);
        stage.show();

        if(currentController instanceof  LoginController)
        {
            ((LoginController)currentController).init(user);//to be able to access init with user parameter
        }
        else
        {
            currentController.init();
        }
        currentController.afterInit();
    }
}
