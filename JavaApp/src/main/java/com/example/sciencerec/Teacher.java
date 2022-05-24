package com.example.sciencerec;

public class Teacher extends User
{
    private boolean researcherPrivilege = false;

    public Teacher(int id, userTypes type, String email, String name)
    {
        super(id, type, email, name);
    }

    public Teacher(int id, userTypes type, String email, String name, String photo, String hobbies, String specialisation, UserSettings usersettings)
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

    public boolean createAccount(userTypes type, String email, String password)
    {
        return this.getDatabase().createUser(type, email, password);
    }

    public boolean exportStudentList()
    {
        return this.getDatabase().exportStudentListAsExcel();
    }

    public void changeResearchPrivilege(boolean hasPrivilege)
    {
        this.researcherPrivilege = hasPrivilege;
    }

    public int[] recommendArticles()
    {
        //TODO

        return new int[1];
    }
}
