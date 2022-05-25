package com.example.sciencerec;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;


public class ArticleListsController extends Controller {


    public Button addArticle = new Button();
    public Button addUser = new Button();
    public Pane burger = new Pane();
    public Button burg = new Button();

    private boolean sideMenuState = false;



    ArrayList<ArticleGUI> articlesToDisplay = new ArrayList<>();
    @FXML
    MenuButton viewMenuButton;
    @FXML
    ScrollPane scrollRec = new ScrollPane();

    public void init(){
        super.init();

        System.out.println("initialised main_menu");
        burger.setVisible(sideMenuState);




    }

    @FXML
    public void initialize(){

        articlesToDisplay = new ArrayList<>();
        ArrayList<Article> arts = App.getUser().getDatabase().searchArticles("");
        for(Article a : arts){
            articlesToDisplay.add(new ArticleGUI(a));
        }

        addArticlesToView();
    }


    public void setViewingArticles(){

    }


    public void addArticlesToView()
    {
//        ArrayList<Article> arts = App.getUser().getDatabase().searchArticles("");
//        for(Article a : arts){
//            articlesToDisplay.add(new ArticleGUI(a));
//        }
//        articlesToDisplay.add(new ArticleGUI(new Article(1,"",null,null,null,null,null)));
//        articlesToDisplay.add(new ArticleGUI(new Article(1,"",null,null,null,null,null)));
//        articlesToDisplay.add(new ArticleGUI(new Article(1,"",null,null,null,null,null)));
//        articlesToDisplay.add(new ArticleGUI(new Article(1,"",null,null,null,null,null)));

        VBox root = new VBox();

        root.setSpacing(10);
        root.setPadding(new Insets(10));
        root.getChildren().add(new Label("Recomended Articles"));

        for (ArticleGUI a: articlesToDisplay) {
            root.getChildren().add(a.getGraphics());
        }
        System.out.println("trying to add to scroll view");
        scrollRec.setContent(root);
        scrollRec.setPrefWidth(600.0);
        scrollRec.setPrefHeight(500.0);
        System.out.println("trying to add to scroll view 2");

    }

    @FXML
    public void onViewMenuClicked(MouseEvent event)
    {
        System.out.println("button clicked view");
       // gui.changeScene(Scenes.MAIN_PAGE);
    }

    @FXML
    public void onViewListClicked(ActionEvent event)
    {
        System.out.println("button clicked list view");
        // gui.changeScene(Scenes.MAIN_PAGE);
        articlesToDisplay = new ArrayList<>();
        ArrayList<Article> arts = App.getUser().getDatabase().getArticlesInList(1,App.getUser().getID());
        for(Article a : arts){
            articlesToDisplay.add(new ArticleGUI(a));
        }
       // addArticlesToView();
    }
    @FXML
    public void onViewRecClicked(ActionEvent event)
    {
        System.out.println("button clicked rec view");
        // gui.changeScene(Scenes.MAIN_PAGE);
        articlesToDisplay = new ArrayList<>();
        ArrayList<Article> arts = App.getUser().getDatabase().searchArticles("");
        for(Article a : arts){
            articlesToDisplay.add(new ArticleGUI(a));
        }
       // addArticlesToView();
    }

    @FXML
    public void onSideMenuClicked(ActionEvent event){
        sideMenuState = !sideMenuState;
        burger.setVisible(sideMenuState);
        System.out.println("side menu");
    }

    @FXML
    public void onAddArticleClicked(ActionEvent event){
        System.out.println("button clicked add Article");
         gui.changeScene(Scenes.ADD_ARTICLES);
    }

    @FXML
    public void onAddUserClicked(ActionEvent event){
        System.out.println("button clicked add user");
        gui.changeScene(Scenes.ADD_USER);
    }

}
