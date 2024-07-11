package model;

import Enums.FXMLAddresses;
import Enums.Faction;
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
import view.LeadersMenu;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LeadersMenuTest extends ApplicationTest {
    private LeadersMenu controller;

    @Override
    public void start(Stage stage) throws IOException {
        User user = new User();
        User.setLoggedInUser(user);
        Player player = new Player();
        PreGame.setTurn(player);
        player.setFaction(Faction.MONSTERS);
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXMLAddresses.LEADER_MENU.getAddress()));
        Parent root = loader.load();
        controller = loader.getController();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();

    }

    @Test
    public void tracherous() {
        FxRobot robot = new FxRobot();
        ImageView tracherous = controller.getTheTracherous();
        robot.clickOn(tracherous);
        Label label = controller.getNotify();
        assertEquals("You chose \"The Tracherous\" as your leader", label.getText());
    }

    @Test
    public void commanderOfTheRedRiders() {
        FxRobot robot = new FxRobot();
        ImageView commander = controller.getCommanderOfTheRedRiders();
        Label label = controller.getNotify();
        robot.clickOn(commander);
        assertEquals("You chose \"Commander Of The Red Riders\" as your leader", label.getText());
    }

    @Test
    public void bringerOfDeath() {
        FxRobot robot = new FxRobot();
        ImageView bringer = controller.getBringerOfDeath();
        Label label = controller.getNotify();
        robot.clickOn(bringer);
        assertEquals("You chose \"Bringer Of Death\" as your leader", label.getText());

    }

    @Test
    public void kingOfTheWildHunt() {
        FxRobot robot = new FxRobot();
        ImageView king = controller.getKingOfTheWildHunt();
        Label label = controller.getNotify();
        robot.clickOn(king);
        assertEquals("You chose \"King Of The Wild Hunt\" as your leader", label.getText());
    }

    @Test
    public void destroyerOfTheWorlds() {
        FxRobot robot = new FxRobot();
        ImageView destroyer = controller.getDestroyerOfWorlds();
        Label label = controller.getNotify();
        robot.clickOn(destroyer);
        assertEquals(label.getText(), "You chose \"Destroyer Of Worlds\" as your leader");
    }

}