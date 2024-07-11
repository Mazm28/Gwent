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
import view.ChoosingOpponent;

import java.io.IOException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ChooseOpponentTest extends ApplicationTest {
    private ChoosingOpponent controller;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLAddresses.CHOOSE_OPPONENT.getAddress()));
        Parent root = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testAnswer() {
        FxRobot robot = new FxRobot();
        TextField answer = controller.getAnswer();
        robot.clickOn(answer).write("testAnswer");
        assertEquals("testAnswer", answer.getText());
    }

}