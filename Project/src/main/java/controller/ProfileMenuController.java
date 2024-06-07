package controller;

import model.User;
import view.ProfileMenu;

import java.util.regex.Matcher;

public class ProfileMenuController{
    private static String whatToChange;

    public static String getWhatToChange() {
        return whatToChange;
    }

    public static void setWhatToChange(String whatToChange) {
        ProfileMenuController.whatToChange = whatToChange;
    }




}