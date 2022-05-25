package com.example.sciencerec;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;


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
        Label authors = new Label("this.article.getAuthors()[1]");
        Label type = new Label("type");
        Button addToListButton = new Button("+");

        HBox hbox = new HBox();

        hbox.setSpacing(10);
        hbox.setPadding(new Insets(10));
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
