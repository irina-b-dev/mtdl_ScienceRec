package com.example.sciencerec;

import java.util.HashMap;

public class Student extends User
{
    private int[] listsID = new int[2];
    private HashMap<Integer, Integer> recommendedArticlesIDs = new HashMap<Integer, Integer>();

    public Student(int id, userTypes type, String email, String name) {
        super(id, type, email, name);
    }

    public Student(int id, userTypes type, String email, String name, String photo, String hobbies, String specialisation, UserSettings usersettings) {
        super(id, type, email, name, photo, hobbies, specialisation, usersettings);
    }

    public boolean addProjectToList(int listID, int articleID)
    {
        return this.getDatabase().addProjectToList(listID, articleID, this.getID());
    }

    public Article removeProjectFromList(int listID, int articleID)
    {
        return this.getDatabase().removeProjectFromList(listID, articleID, this.getID());
    }

    public int[] getArticleIDs(int listID)
    {
        //TODO

        //return this.getDatabase().getArticleIDsFromList(listID, this.getID());

        return new int[1];
    }

    private int[] recommendArticles()
    {
        //TODO
        //ELASTICSEARCH

        return new int[1];
    }

    //TODO
    //getRecommendedArticlesIDs()
}
