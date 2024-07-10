package view;

import Enums.FXMLAddresses;
import Enums.ImageAddresses;
import Enums.RegisterRegexes;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Ellipse;
import model.App;
import server.User;

import java.io.IOException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;
import java.util.Optional;

public class RegisterMenu{
    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$&";
    @FXML
    private TextField username1;
    @FXML
    private Ellipse showCircle;
    @FXML
    private Label error;
    @FXML
    private TextField username;
    @FXML
    private TextField email;
    @FXML
    private TextField nickname;
    @FXML
    private PasswordField password;
    @FXML
    private PasswordField repeatPassword;
    private static final SecureRandom random = new SecureRandom();
    public void signIn() {
        try {
            Launcher.changeScene(FXMLAddresses.LOGIN_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void signUp() {
        String passwordString = password.getText();
        String usernameString = username.getText();
        String emailString = email.getText();
        String nicknameString = nickname.getText();
        String repeatPasswordString = repeatPassword.getText();
        if(passwordString.isEmpty() || usernameString.isEmpty() || emailString.isEmpty() || nicknameString.isEmpty()){
            error.setText("You should fill all of the fields!");
        } else if (!RegisterRegexes.getMatcher(usernameString, RegisterRegexes.USERNAME).matches()) {
            error.setText("Invalid Username format!");
        } else if (!RegisterRegexes.getMatcher(nicknameString, RegisterRegexes.USERNAME).matches()) {
            error.setText("Invalid nickname format!");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD_WEAKNESS1).matches()) {
            error.setText("Your password must contain an uppercase letter!");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD_WEAKNESS2).matches()) {
            error.setText("Your password must contain a special letter!");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD_WEAKNESS3).matches()) {
            error.setText("Your password must contain a number!");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD_WEAKNESS4).matches()) {
            error.setText("Your password must contain a lowercase letter!");
        } else if (passwordString.length() < 8) {
            error.setText("Your password is too short!");
        } else if (!RegisterRegexes.getMatcher(emailString, RegisterRegexes.EMAIL).matches()) {
            error.setText("Wrong email format!");
        } else if (!RegisterRegexes.getMatcher(passwordString, RegisterRegexes.PASSWORD).matches()) {
            error.setText("Invalid password format!");
        } else if (!repeatPasswordString.equals(passwordString)) {
            error.setText("Repeat your password correctly!");
        } else if (User.getUserByUsername(usernameString) != null) {
            error.setText("There is a user with given username!");
            String newUsername = usernameString + App.getRandom().nextInt();
            while (User.getUserByUsername(newUsername) != null) {
                newUsername = usernameString + App.getRandom().nextInt();
            }
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("do you want " + newUsername);
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
                User user = new User(usernameString, passwordString, emailString, nicknameString);
                ArrayList<User> users = App.getUsers();
                users.add(user);
                App.SaveUsers(users);
                User.setTempUser(user);
                try {
                    Launcher.changeScene(FXMLAddresses.SELECT_QUESTION.getAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            ArrayList<User> users = App.getUsers();
            User user = new User(usernameString, passwordString, emailString, nicknameString);
            users.add(user);
            App.SaveUsers(users);
            User.setTempUser(user);
            try {
                Launcher.changeScene(FXMLAddresses.SELECT_QUESTION.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    private User passwordExists(String password) {
        for(User user: App.getUsers()){
            if(user.getPassword().equals(password)) return user;
        }
        return null;
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
        repeatPassword.setText(password.getText());
    }
    public void initialize(){
        showCircle.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.SHOW.getAddress())))));
    }
    public void showPassword(MouseEvent mouseEvent){
        (new LoginMenu()).showPassword(password,username1,showCircle);
    }
    public void signUp2(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) signUp();
    }
}