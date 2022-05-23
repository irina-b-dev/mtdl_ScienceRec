package com.example.sciencerec;

public abstract class User
{
    private int ID;
    private userTypes type;
    private String email;
    private String name;
    private String photo;
    private String hobbies;
    private String specialisation;
    private UserSettings usersettings;
    private static databaseDAO database = new databaseDAO();;

    public User(int id, userTypes type, String email, String name)
    {
        this.ID = id;
        this.type = type;
        this.email = email;
        this.name = name;
    }

    public User(int id, userTypes type, String email, String name, String photo, String hobbies, String specialisation, UserSettings usersettings)
    {
        this.ID = id;
        this.type = type;
        this.email = email;
        this.name = name;
        this.photo = photo;
        this.hobbies = hobbies;
        this.specialisation = specialisation;
        this.usersettings = usersettings;
    }

    public int getID()
    {
        return ID;
    }

    public userTypes getType()
    {
        return type;
    }

    public String getEmail()
    {
        return email;
    }

    public String getName()
    {
        return name;
    }

    public String getPhoto()
    {
        return photo;
    }

    public String getHobbies()
    {
        return hobbies;
    }

    public String getSpecialisation()
    {
        return specialisation;
    }

    public UserSettings getUsersettings()
    {
        return usersettings;
    }

    public void setID(int ID)
    {
        this.ID = ID;
    }

    public void setType(userTypes type)
    {
        this.type = type;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setPhoto(String photo)
    {
        this.photo = photo;
    }

    public void setHobbies(String hobbies)
    {
        this.hobbies = hobbies;
    }

    public void setSpecialisation(String specialisation)
    {
        this.specialisation = specialisation;
    }

    public void setUsersettings(UserSettings usersettings)
    {
        this.usersettings = usersettings;
    }

    public String recoverPassword()
    {
        return this.database.getPassword(this.email);
    }

    public databaseDAO getDatabase()
    {
        return this.database;
    }
}
