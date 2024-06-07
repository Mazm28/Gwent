package controller;

import Regexes.FXMLAddresses;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import view.Launcher;

import java.io.IOException;
import java.util.Optional;

public class MainMenuController {
    public static void lunchMainMenu(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure?");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
            try {
                Launcher.changeScene(FXMLAddresses.MAIN_MENU.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
