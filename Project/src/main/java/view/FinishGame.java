package view;

import Enums.FXMLAddresses;
import Enums.ImageAddresses;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.*;
import server.User;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

public class FinishGame {
    @FXML
    private HBox eHBOX;
    @FXML
    private HBox yHBOX;
    @FXML
    private Circle winOrLose;

    public void initialize() {
        Game game = App.getGame();
        int wins = 0;
        int draws = 0;
        for (Round round : game.getRounds()) {
            if (round.winner() == null) draws++;
            else if (round.winner().equals(game.getPlayer1())) wins++;
        }
        int loses = 3 - (wins + draws);
        Player winner = null;
        if (wins > loses) {
            winOrLose.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.WIN.getAddress())))));
            winner = game.getPlayer1();
        } else if (wins < loses) {
            winOrLose.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.LOSE.getAddress())))));
            winner = game.getPlayer2();
        } else {
            winOrLose.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.DRAW.getAddress())))));
        }
        for (int i = 1; i <= game.getRoundNumber(); i++) {
            ((Label) yHBOX.getChildren().get(i)).setText(String.valueOf(game.getPlayer1().getPoints()[i - 1]));
            ((Label) eHBOX.getChildren().get(i)).setText(String.valueOf(game.getPlayer2().getPoints()[i - 1]));
        }
        makeGameRecords(winner);
    }

    private void makeGameRecords(Player winner) {
        Game game = App.getGame();
        int[] finalPoints = new int[2];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        int[][] points = new int[2][3];
        for (int i = 0; i < 3; i++) {
            points[0][i] = game.getPlayer1().getPoints()[i];
            finalPoints[0] += game.getPlayer1().getPoints()[i];
            points[1][i] = game.getPlayer2().getPoints()[i];
            finalPoints[1] += game.getPlayer2().getPoints()[i];
        }
        User user1 = User.getLoggedInUser();
        user1.addToGameRecords(new GameRecord(points, finalPoints, formatter.format(localDateTime), winner, game.getPlayer2()));
        App.SaveInfo(user1);
        finalPoints[0] = 0;
        finalPoints[1] = 0;
        for (int i = 0; i < 3; i++) {
            points[0][i] = game.getPlayer2().getPoints()[i];
            finalPoints[0] += game.getPlayer2().getPoints()[i];
            points[1][i] = game.getPlayer1().getPoints()[i];
            finalPoints[1] += game.getPlayer1().getPoints()[i];
        }
        for(User user: App.getUsers()){
            if(user.getUsername().equals(game.getPlayer2().getUsername())){
                user.addToGameRecords(new GameRecord(points, finalPoints, formatter.format(localDateTime), winner, game.getPlayer1()));
                App.SaveInfo(user);
                break;
            }
        }
    }

    public void backToLobby() {
        try {
            Launcher.changeScene(FXMLAddresses.MAIN_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
