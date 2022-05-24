package com.example.sciencerec;

public class UserSettings
{
    private boolean darkMode;

    public UserSettings()
    {
        this.darkMode = true;
    }

    public boolean getDarkMode()
    {
        return darkMode;
    }
    public void setDarkMode(boolean mode)
    {
        this.darkMode = mode;
    }
}
