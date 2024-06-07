package view;

import Regexes.FXMLAddresses;
import Regexes.RegisterRegexes;
import controller.ProfileMenuController;
import controller.SaveUsersController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;

import java.io.IOException;

public class ChangeInformation {
    private final String whatToChange = ProfileMenuController.getWhatToChange();
    @FXML
    private Label error;
    @FXML
    private TextField newInfo;
    @FXML
    private TextField oldPassword;
    @FXML
    private TextField reenterNewPassword;

    public void initialize() {
        newInfo.setPromptText("Enter new " + whatToChange);
        oldPassword.setPromptText("Enter Your Old Password");
        reenterNewPassword.setPromptText("Enter new Password Again");
        if (!whatToChange.equals("Password")) {
            oldPassword.setVisible(false);
            reenterNewPassword.setVisible(false);
        }
    }

    public void saveChanges() {
        switch (whatToChange) {
            case "Username":
                if (!RegisterRegexes.getMatcher(newInfo.getText(), RegisterRegexes.USERNAME).matches()) {
                    error.setText("Invalid Username format!");
                    return;
                }
                if (User.getUserByUsername(newInfo.getText()) != null) {
                    error.setText("There is a user with given username!");
                    return;
                }
                User.getLoggedInUser().setUsername(newInfo.getText());
                break;
            case "Email":
                if (!RegisterRegexes.getMatcher(newInfo.getText(), RegisterRegexes.EMAIL).matches()) {
                    error.setText("Wrong email format!");
                    return;
                }
                User.getLoggedInUser().setEmail(newInfo.getText());
                break;
            case "Nickname":
                if (!RegisterRegexes.getMatcher(newInfo.getText(), RegisterRegexes.USERNAME).matches()) {
                    error.setText("Invalid nickname format!");
                    return;
                }
                User.getLoggedInUser().setNickname(newInfo.getText());
                break;
            case "Password":
                if (!User.getLoggedInUser().getPassword().equals(newInfo.getText())) {
                    error.setText("Wrong Old Password!");
                    return;
                } else if (!RegisterRegexes.getMatcher(newInfo.getText(), RegisterRegexes.PASSWORD_WEAKNESS1).matches()) {
                    error.setText("Your password must contain an uppercase letter!");
                    return;
                } else if (!RegisterRegexes.getMatcher(newInfo.getText(), RegisterRegexes.PASSWORD_WEAKNESS2).matches()) {
                    error.setText("Your password must contain a special letter!");
                    return;
                } else if (!RegisterRegexes.getMatcher(newInfo.getText(), RegisterRegexes.PASSWORD_WEAKNESS3).matches()) {
                    error.setText("Your password must contain a number!");
                    return;
                } else if (!RegisterRegexes.getMatcher(newInfo.getText(), RegisterRegexes.PASSWORD_WEAKNESS4).matches()) {
                    error.setText("Your password must contain a lowercase letter!");
                    return;
                } else if (newInfo.getText().length() < 8) {
                    error.setText("Your password is too short!");
                    return;
                } else if (!RegisterRegexes.getMatcher(newInfo.getText(), RegisterRegexes.PASSWORD).matches()) {
                    error.setText("Invalid password format!");
                    return;
                } else if (!reenterNewPassword.getText().equals(newInfo.getText())) {
                    error.setText("Repeat your password correctly!");
                    return;
                }
                User.getLoggedInUser().setPassword(newInfo.getText());
                break;
        }
        SaveUsersController.SaveInfo(User.getLoggedInUser());
        try {
            Launcher.changeScene(FXMLAddresses.PROFILE_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void profileMenu() {
        try {
            Launcher.changeScene(FXMLAddresses.PROFILE_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
