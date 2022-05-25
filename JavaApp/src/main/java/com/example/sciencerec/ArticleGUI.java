package com.example.sciencerec;

import javafx.css.Style;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;


import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ArticleGUI {

    Article article;
    private Desktop desktop = Desktop.getDesktop();
    private Pane p = new Pane();
    ArticleGUI(Article article){
        this.article = article;

        Label title = new Label(this.article.getTitle());
        title.setFont(new Font("Arial", 30));
        title.setMinHeight(100);
        Label authors = new Label(App.ArrayToString(this.article.getAuthors()));
        authors.setLayoutY(150);
        authors.setMinHeight(100);
        Label type = new Label(article.getType().toString());
        type.setLayoutY(250);
        type.setMinHeight(100);

        Pane pane = new Pane();

        Button addToListButton = new Button("+");
        addToListButton.setTranslateY(30);
        addToListButton.setTranslateX(450);
        //addToListButton.setLayoutY(550);
        addToListButton.setLayoutX(1500);
        addToListButton.setMinHeight(10);

        VBox hbox = new VBox();

        hbox.setSpacing(50);
        hbox.setPadding(new Insets(50));
        hbox.getChildren().addAll(title,authors,type, addToListButton);
        addToListButton.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                App.getUser().getDatabase().addProjectToList(1,article.getID(),App.getUser().getID());
            }
        });
        p.getChildren().addAll(hbox);

        p.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on article");
               // GUIHandler.guiHandle().changeScene(Scenes.VIEW_ARTICLE);
                //article.getFilepath()
                File file = new File("C:\\sample.pdf");
                openFile(file);

            }
        });


        //use these to set label positions
        authors.relocate(20,20);
        type.relocate(40,40);

        p.getChildren().addAll(title,authors,type);


    }

    public Pane getGraphics(){
        return p;
    }

    private void openFile(File file) {
        try {
            desktop.open(file);
        } catch (IOException ex) {
            Logger.getLogger(
                    AddArticlesController.class.getName()).log(
                    Level.SEVERE, null, ex
            );
        }
    }


}
