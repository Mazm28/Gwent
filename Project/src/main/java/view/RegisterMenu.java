package view;

import Regexes.FXMLAddresses;
import Regexes.RegisterRegexes;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.App;
import model.User;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

public class RegisterMenu{
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$&";
    @FXML
    private Label error;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField nickname;
    @FXML
    private TextField password;
    private static final SecureRandom random = new SecureRandom();
    public void signIn() {
        try {
            Launcher.changeScene(FXMLAddresses.LOGINMENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUp() {
        String passwordString = password.getText();
        String usernameString = username.getText();
        String emailString = email.getText();
        String nicknameString = nickname.getText();
        if (!RegisterRegexes.getMatcher(usernameString, RegisterRegexes.USERNAME).matches()) {
            error.setText("Invalid Username");
        } else if (!RegisterRegexes.getMatcher(nicknameString, RegisterRegexes.USERNAME).matches()) {
            error.setText("Invalid nickname format");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD_WEAKNESS1).matches()) {
            error.setText("where is uppercase bro?");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD_WEAKNESS2).matches()) {
            error.setText("where is special letter?");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD_WEAKNESS3).matches()) {
            error.setText("where is number?");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD_WEAKNESS4).matches()) {
            error.setText("where is lowercase letter?");
        } else if (passwordString.length() < 8) {
            error.setText("Your password is too short!");
        } else if (!RegisterRegexes.getMatcher(emailString, RegisterRegexes.EMAIL).matches()) {
            error.setText("Wrong email format!");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD).matches()) {
            error.setText("Invalid password format");
        } else if (User.getUserByUsername(usernameString) != null) {
            error.setText("There is a user with given username");
            String newUsername = usernameString + App.getRandom().nextInt();
            while (User.getUserByUsername(newUsername) != null) {
                newUsername = usernameString + App.getRandom().nextInt();
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("do you want " + newUsername);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
                User user = new User(newUsername, passwordString, emailString, nicknameString);
                User.setLoggedInUser(user);
                try {
                    Launcher.changeScene(FXMLAddresses.SELECTQUESTION.getAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            User user = new User(usernameString, passwordString, emailString, nicknameString);
            User.setLoggedInUser(user);
            try {
                Launcher.changeScene(FXMLAddresses.SELECTQUESTION.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void makePassword() {
        ArrayList<Character> passwordString = new ArrayList<>();
        passwordString.add(UPPERCASE.charAt(random.nextInt(UPPERCASE.length())));
        passwordString.add(LOWERCASE.charAt(random.nextInt(LOWERCASE.length())));
        passwordString.add(DIGITS.charAt(random.nextInt(DIGITS.length())));
        passwordString.add(SPECIAL_CHARACTERS.charAt(random.nextInt(SPECIAL_CHARACTERS.length())));

        String allCharacters = UPPERCASE + LOWERCASE + DIGITS + SPECIAL_CHARACTERS;
        for (int i = 4; i < 8; i++) {
            passwordString.add(allCharacters.charAt(random.nextInt(allCharacters.length())));
        }
        Collections.shuffle(passwordString);

        StringBuilder passwordBuilder = new StringBuilder();
        for (char ch : passwordString) {
            passwordBuilder.append(ch);
        }
        password.setText(passwordBuilder.toString());
    }
}