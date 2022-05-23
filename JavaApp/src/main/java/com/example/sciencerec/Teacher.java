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

    public boolean addOrEditArticle()
    {
        //TODO


        return false;
    }

    public boolean deleteArticle()
    {
        //TODO

        return false;
    }

    public boolean createAccount()
    {
        //TODO

        return false;
    }

    public String exportStudentList()
    {
        //TODO

        //this should be converted later to an Excel file

        return "test";
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
