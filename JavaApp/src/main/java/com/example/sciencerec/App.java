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
    private static User user;
    //for testing purposes
    private static databaseDAO db = new databaseDAO();
    private static GUIHandler gui;

    @Override
    public void start(Stage stage) throws IOException
    {
        gui = new GUIHandler(stage);
        gui.init();

    }

    public static void main(String[] args)
    {
        //launch();
        //System.out.println(db.checkIfUserExists("andrei@yahoo.com","andrei"));
        //user = db.connectUser("andrei@yahoo.com","andrei");
        //if(!user.equals(null))
        //{
        //    System.out.println(user.getID() + " " + user.getType());
        //}
        System.out.println(db.createUser(userTypes.STUDENT, "irina@yahoo.com", "irina"));
        user = db.connectUser("irina@yahoo.com","irina");
        System.out.println(user.getID() + " " + user.getType());
        System.out.println(user.recoverPassword());
    }
}