package com.example.sciencerec;

public class Article
{
    private int ID;
    private String title;
    private String[] authors;
    private String[] categories;
    private articleTypes type;
    private String[] keywords;
    private String filepath;

    public Article(int id, String title, String[] authors, String[] categories, articleTypes type, String[] keywords, String filepath)
    {
        this.ID = id;
        this.title = title;
        this.authors = authors;
        this.categories = categories;
        this.type = type;
        this.keywords = keywords;
        this.filepath = filepath;
    }

    public int getID()
    {
        return ID;
    }

    public String getTitle()
    {
        return title;
    }

    public String[] getAuthors()
    {
        return authors;
    }

    public String[] getCategories()
    {
        return categories;
    }

    public articleTypes getType()
    {
        return type;
    }

    public String[] getKeywords()
    {
        return keywords;
    }

    public String getFilepath()
    {
        return filepath;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setAuthors(String[] authors)
    {
        this.authors = authors;
    }

    public void setCategories(String[] categories)
    {
        this.categories = categories;
    }

    public void setType(articleTypes type)
    {
        this.type = type;
    }

    public void setKeywords(String[] keywords)
    {
        this.keywords = keywords;
    }

    public void setFilepath(String filepath)
    {
        this.filepath = filepath;
    }
}
