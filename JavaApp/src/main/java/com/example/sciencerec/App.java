package com.example.sciencerec;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.io.IOException;


public class App extends Application
{
    private static User user = new User();//so that NULL bs can be avoided
    private static GUIHandler gui;

    @Override
    public void start(Stage stage) throws IOException
    {
        System.out.println("started");
        gui = GUIHandler.guiHandle();
        gui.init(stage, user);
    }

    public static void main(String[] args)
    {
        launch();
    }
}