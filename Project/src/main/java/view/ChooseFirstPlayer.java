package view;

import Enums.FXMLAddresses;
import Enums.ImageAddresses;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.App;
import model.Game;
import model.PreGame;

import java.io.IOException;
import java.util.Objects;

public class ChooseFirstPlayer {
    @FXML
    private Circle player2Circle;
    @FXML
    private Circle player1Circle;
    @FXML
    private Label player1Label;
    @FXML
    private Label player2Label;

    public void initialize(){
        player1Circle.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(PreGame.getPlayer1().getLeader().getImageAddress())))));
        player2Circle.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(PreGame.getPlayer2().getLeader().getImageAddress())))));
        player1Label.setText(PreGame.getPlayer1().getUsername());
        player2Label.setText(PreGame.getPlayer2().getUsername());
    }

    public void player1() throws IOException {
        App.setGame(new Game(PreGame.getPlayer1(), PreGame.getPlayer2()));
        Launcher.changeScene(FXMLAddresses.STARTING_GAME_MENU.getAddress());
    }

    public void player2() throws IOException {
        App.setGame(new Game(PreGame.getPlayer2(), PreGame.getPlayer1()));
        Launcher.changeScene(FXMLAddresses.STARTING_GAME_MENU.getAddress());
    }
}