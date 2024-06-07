package view;

import Regexes.FXMLAddresses;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import model.User;

import java.io.IOException;

public class LoginMenu {
    @FXML
    private TextField username;
    @FXML
    private PasswordField password;
    @FXML
    private Label error;
    public void signIn() {
        User user = User.getUserByUsername(username.getText());
        if (user == null) error.setText("No such user exists!");
        else if (!user.getPassword().equals(password.getText())) error.setText("Wrong Password!");
        else {
            try {
                User.setLoggedInUser(user);
                Launcher.changeScene(FXMLAddresses.MAIN_MENU.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void signUp() {
        try {
            Launcher.changeScene(FXMLAddresses.REGISTER_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void forgetPassword() {
        User user = User.getUserByUsername(username.getText());
        if (user == null) error.setText("No such user exists");
        else {
            try {
                User.setTempUser(user);
                Launcher.changeScene(FXMLAddresses.ANSWER_QUESTION.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void signIn2(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) signIn();
    }
}
