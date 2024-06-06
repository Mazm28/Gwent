package view;

import Regexes.FXMLAddresses;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.input.MouseEvent;
import model.User;

import java.io.IOException;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Matcher;

public class MainMenu{
    public Button newGameButton;
    public Button profileMenuButton;
    public Button logoutButton;

    public void newGame(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene("/FXML/PreGameMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void logout(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("do you want to logout?");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get().equals(ButtonType.YES)) {
            User.setLoggedInUser(null);
            try {
                Launcher.changeScene(FXMLAddresses.LOGINMENU.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void profileMenu(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene("/FXML/ProfileMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}