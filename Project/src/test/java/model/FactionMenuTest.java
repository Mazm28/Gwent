package model;

import Enums.FXMLAddresses;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;
import server.User;
import view.FactionsMenu;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FactionMenuTest extends ApplicationTest {
    private FactionsMenu controller;

    @Override
    public void start(Stage stage) throws IOException {
        User user = new User();
        User.setLoggedInUser(user);
        Player player = new Player();
        PreGame.setTurn(player);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLAddresses.FACTION_MENU.getAddress()));
        Parent root = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void testMonsters() {
        FxRobot robot = new FxRobot();
        ImageView monsters = controller.getMonsters();
        robot.clickOn(monsters);
        Label label = controller.getNotify();
        assertEquals("You chose \"Monsters\" as your faction",label.getText());
    }

    @Test
    public void testNilfgaard() {
        FxRobot robot = new FxRobot();
        ImageView nilfgaard = controller.getNilfgaard();
        Label label = controller.getNotify();
        robot.clickOn(nilfgaard);
        assertEquals("You chose \"Nilfgaard\" as your faction", label.getText());
    }

    @Test
    public void testNorthernRealms() {
        FxRobot robot = new FxRobot();
        ImageView northernRealms = controller.getNorthernRealms();
        Label label = controller.getNotify();
        robot.clickOn(northernRealms);
        if (label.getText().equals("You chose \"Northern Realms\" as your faction"))
            assertEquals(1, 1);
        else {
            assertEquals("You chose \"Northern Realms\" as your faction", label.getText());
        }
    }

    @Test
    public void testSkellige() {
        FxRobot robot = new FxRobot();
        ImageView skellige = controller.getSkellige();
        Label label = controller.getNotify();
        robot.clickOn(skellige);
        assertEquals("You chose \"Skellige\" as your faction", label.getText());
    }

    @Test
    public void testScoiatael() {
        FxRobot robot = new FxRobot();
        ImageView scoiatael = controller.getScoiatael();
        Label label = controller.getNotify();
        robot.clickOn(scoiatael);
        assertEquals(label.getText(), "You chose \"Scoia'tael\" as your faction");
    }

}