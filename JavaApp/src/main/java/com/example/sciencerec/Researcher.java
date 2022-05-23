package com.example.sciencerec;

public class Researcher extends User
{
    private int[] recommendedArticleIDs;

    public Researcher(int id, userTypes type, String email, String name)
    {
        super(id, type, email, name);
    }

    public Researcher(int id, userTypes type, String email, String name, String photo, String hobbies, String specialisation, UserSettings usersettings)
    {
        super(id, type, email, name, photo, hobbies, specialisation, usersettings);
    }

    public boolean addOrEditArticle()
    {
        //TODO

        //database implementation

        //returns false if something went wrong
        return false;
    }

    public boolean deleteArticle()
    {
        //TODO

        //database implementation

        //returns false if something went wrong
        return false;
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
