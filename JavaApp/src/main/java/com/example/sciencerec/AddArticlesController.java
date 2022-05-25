package com.example.sciencerec;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.Desktop;


public class AddArticlesController extends Controller {

    public Button addArticleButton;
    public Button addFileButton;
    public TextField typeInput;
    public TextField titleInput;
    public TextField authorsInput;
    public TextField keywordsInput;

    private Desktop desktop = Desktop.getDesktop();

    final FileChooser fileChooser = new FileChooser();

    private String fpath;
    @Override
    public void init() {
        super.init();


    }

    @FXML
    public void onAddFileClicked(ActionEvent event){
        System.out.println("button add file");
        File file = fileChooser.showOpenDialog(GUIHandler.guiHandle().stage);
        if (file != null) {
            openFile(file);
            fpath = file.getAbsolutePath();
            System.out.println(fpath);

        }
    }

    @FXML
    public void onAddArticleClicked(ActionEvent event){
        System.out.println("button add article");

        String title = titleInput.getText();
        String[] keywords = keywordsInput.getText().split(",");
        String[] authors = authorsInput.getText().split(",");
        String type = typeInput.getText();
        String[] categories = {"",""};
        Article article = new Article(0,title,authors,categories,articleTypes.LICENCE,keywords,fpath);
        App.getUser().getDatabase().createArticle(article);
        gui.changeScene(Scenes.MAIN_PAGE);
    }

    @FXML
    public void onBackClicked(ActionEvent event){
        System.out.println("button back article");

        gui.changeScene(Scenes.MAIN_PAGE);
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
