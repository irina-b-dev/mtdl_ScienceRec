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
    //for testing purposes
   // private static databaseDAO db = new databaseDAO();
    private static GUIHandler gui;

    @Override
    public void start(Stage stage) throws IOException
    {
        System.out.println("is starting app");
        gui = GUIHandler.guiHandle();
        gui.init(stage);
    }

    public static void main(String[] args)
    {
        launch();
        //System.out.println(db.checkIfUserExists("andrei@yahoo.com","andrei"));
        //user = db.connectUser("andrei@yahoo.com","andrei");
        //if(!user.equals(null))
        //{
        //    System.out.println(user.getID() + " " + user.getType());
        //}

        /////////////////////////////////////////////////
//        System.out.println(db.createUser(userTypes.STUDENT, "irina@yahoo.com", "irina"));
//        user = db.connectUser("irina@yahoo.com","irina");
//        System.out.println(user.getID() + " " + user.getType());
//        System.out.println(user.recoverPassword());

        //testing excel exporting
        //user = user.getDatabase().connectUser("teacher@yahoo.com", "teacher");
        //if(user.getType().equals(userTypes.TEACHER))
        //{
        //    ((Teacher)user).exportStudentList();
        //}
        //it works
    }
}