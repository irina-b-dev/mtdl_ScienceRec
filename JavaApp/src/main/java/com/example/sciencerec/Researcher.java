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

    public boolean addArticle(Article a)
    {
        return this.getDatabase().createArticle(a);
    }

    public boolean editArticle(int articleID, String Title, String[] authors, String[] categories, articleTypes type, String[] keywords, String filepath)
    {
        return this.getDatabase().editArticle(articleID, Title, authors, categories, type, keywords, filepath);
    }

    public boolean deleteArticle(int articleID)
    {
        return this.getDatabase().deleteArticle(articleID);
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
