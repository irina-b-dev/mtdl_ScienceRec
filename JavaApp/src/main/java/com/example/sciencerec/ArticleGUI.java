package com.example.sciencerec;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class ArticleGUI {

    Article article;
    private Pane p = new Pane();
    ArticleGUI(Article article){
        this.article = article;
        Label title = new Label("title");
        Label authors = new Label("authors");
        Label type = new Label("type");

        p.getChildren().addAll(title,authors,type);

    }

    public Pane getGraphics(){
        return p;
    }


}
