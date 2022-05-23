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
    private static databaseDAO db;
    private static GUIHandler gui;

    @Override
    public void start(Stage stage) throws IOException
    {

        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("login.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 480);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args)
    {

        /*
        try {
           // Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
            //DriverManager.registerDriver(new com.);
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/database",
                    "root", "andrei");

            Statement stmt = conn.createStatement();
            ResultSet rset;

            String strSelect = "select * from users";
            System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging

            rset = stmt.executeQuery(strSelect);

            while(rset.next())
            {
                System.out.println("First name is: " + rset.getString("first_name") + " ; Last name is: " + rset.getString("last_name") + " ; Age: " + rset.getString("age"));
            }

            System.out.println("First name is: ");


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
         */
        launch();
    }
}