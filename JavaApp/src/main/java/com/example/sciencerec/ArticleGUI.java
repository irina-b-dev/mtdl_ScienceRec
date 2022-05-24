package com.example.sciencerec;

import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class ArticleGUI {

    Article article;
    private Pane p = new Pane();
    ArticleGUI(Article article){
        this.article = article;
        Label title = new Label("title");
        Label authors = new Label("authors");
        Label type = new Label("type");

        HBox hbox = new HBox();
        hbox.getChildren().addAll(title,authors,type);
        p.getChildren().addAll(hbox);
        p.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("clicked on article");
                GUIHandler.guiHandle().changeScene(Scenes.VIEW_ARTICLE);
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


}
