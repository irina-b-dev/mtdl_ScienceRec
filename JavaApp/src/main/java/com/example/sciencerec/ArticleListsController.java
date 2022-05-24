package com.example.sciencerec;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ArticleListsController extends Controller
{
    ArrayList<ArticleGUI> articlesToDisplay = new ArrayList<>();
    @FXML
    MenuButton viewMenuButton;
    @FXML
    ScrollPane scrollRec = new ScrollPane();

    public void init()
    {
        super.init();

        System.out.println("initialised main_menu");
    }

    @FXML
    public void initialize()
    {
        //should be safe to call it here but it isntttttttttttt
        addArticlesToView();
    }

    @Override
    public void afterInit()
    {
        super.afterInit();
    }

    public void addArticlesToView()
    {
        articlesToDisplay.add(new ArticleGUI(new Article(1,"",null,null,null,null,null)));
        articlesToDisplay.add(new ArticleGUI(new Article(1,"",null,null,null,null,null)));
        articlesToDisplay.add(new ArticleGUI(new Article(1,"",null,null,null,null,null)));
        articlesToDisplay.add(new ArticleGUI(new Article(1,"",null,null,null,null,null)));

        VBox root = new VBox();

        root.setSpacing(10);
        root.setPadding(new Insets(10));
        for (ArticleGUI a: articlesToDisplay) {
            root.getChildren().add(a.getGraphics());
        }
        scrollRec.setContent(root);
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
    }
    @FXML
    public void onViewRecClicked(ActionEvent event)
    {
        System.out.println("button clicked rec view");
        // gui.changeScene(Scenes.MAIN_PAGE);
    }

}
