package view;

import Regexes.FXMLAddresses;
import controller.MainMenuController;
import controller.ProfileMenuController;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;

public class ProfileMenu{

    public void changeUsername(MouseEvent mouseEvent) {
        ProfileMenuController.setWhatToChange("Username");
        try {
            Launcher.changeScene(FXMLAddresses.CHANGE_INFO.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeEmail(MouseEvent mouseEvent) {
        ProfileMenuController.setWhatToChange("Email");
        try {
            Launcher.changeScene(FXMLAddresses.CHANGE_INFO.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changeNickname(MouseEvent mouseEvent) {
        ProfileMenuController.setWhatToChange("Nickname");
        try {
            Launcher.changeScene(FXMLAddresses.CHANGE_INFO.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void changePassword(MouseEvent mouseEvent) {
        ProfileMenuController.setWhatToChange("Password");
        try {
            Launcher.changeScene(FXMLAddresses.CHANGE_INFO.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showInfo(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.SHOW_INFO.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void mainMenu() {
        try {
            Launcher.changeScene(FXMLAddresses.MAIN_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showGameHistory(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.SHOW_GAME_HISTORY.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}