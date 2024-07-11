package model;

import Enums.FXMLAddresses;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import view.RegisterMenu;
import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegisterMenuTest extends ApplicationTest {
    private RegisterMenu controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLAddresses.REGISTER_MENU.getAddress()));
        Parent root = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testUsername() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUser");
        assertEquals("testUser", username.getText());
    }
    @Test
    public void testEmail() {
        FxRobot robot = new FxRobot();
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        assertEquals("testEmail@gmail.com", email.getText());
    }
    @Test
    public void testNickname() {
        FxRobot robot = new FxRobot();
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        assertEquals("testNickname", nickname.getText());
    }
    @Test
    public void testPassword() {
        FxRobot robot = new FxRobot();
        TextField password = controller.getPassword();
        robot.clickOn(password).write("testPassword");
        assertEquals("testPassword", password.getText());
    }
    @Test
    public void testRepeatPassword() {
        FxRobot robot = new FxRobot();
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("testPassword");
        assertEquals("testPassword", repeatPassword.getText());
    }

    @Test
    public void testUsernameFormat() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("@testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("testPassword");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("testPassword");
        robot.clickOn(controller.getSignUp());
        assertEquals("Invalid Username format!", controller.getError().getText());
    }
    @Test
    public void testNicknameFormat() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("@testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("testPassword");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("testPassword");
        robot.clickOn(controller.getSignUp());
        assertEquals("Invalid nickname format!", controller.getError().getText());
    }
    @Test
    public void testUppercase() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("testpassword");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("testpassword");
        robot.clickOn(controller.getSignUp());
        assertEquals("Your password must contain an uppercase letter!", controller.getError().getText());
    }
    @Test
    public void testLowercase() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("TESTPASSWORD123@");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("TESTPASSWORD123@");
        robot.clickOn(controller.getSignUp());
        assertEquals("Your password must contain a lowercase letter!", controller.getError().getText());
    }

    @Test
    public void testSpecialLetter() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("testPassword123");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("testPassword123");
        robot.clickOn(controller.getSignUp());
        assertEquals("Your password must contain a special letter!", controller.getError().getText());
    }

    @Test
    public void testNumber() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("testPassword@");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("testPassword@");
        robot.clickOn(controller.getSignUp());
        assertEquals("Your password must contain a number!", controller.getError().getText());
    }

    @Test
    public void testLength() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("tP1@");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("tP1@");
        robot.clickOn(controller.getSignUp());
        assertEquals("Your password is too short!", controller.getError().getText());
    }

    @Test
    public void testEmailFormat() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("testPassword123@");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("testPassword123@");
        robot.clickOn(controller.getSignUp());
        assertEquals("Wrong email format!", controller.getError().getText());
    }

    @Test
    public void testRepeatingCorrectly() {
        FxRobot robot = new FxRobot();
        TextField username = controller.getUsername();
        robot.clickOn(username).write("testUsername");
        TextField email = controller.getEmail();
        robot.clickOn(email).write("testEmail@gmail.com");
        TextField nickname = controller.getNickname();
        robot.clickOn(nickname).write("testNickname");
        TextField password = controller.getPassword();
        robot.clickOn(password).write("testPassword123@");
        TextField repeatPassword = controller.getRepeatPassword();
        robot.clickOn(repeatPassword).write("testPassword1234@");
        robot.clickOn(controller.getSignUp());
        assertEquals("Repeat your password correctly!", controller.getError().getText());
    }

}