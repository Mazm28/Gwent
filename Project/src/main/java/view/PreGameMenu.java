package view;

import Regexes.FXMLAddresses;
import controller.MainMenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.App;
import model.Game;
import model.Player;
import model.User;

import java.io.IOException;
import java.util.Optional;

public class PreGameMenu {
    private static Game game;
    private static Player player1;
    private static Player player2;
    private static boolean player1Turn = true;
    @FXML
    private Button readyButton;
    @FXML
    private Button showFactionsButton;
    @FXML
    private Button showCardsButton;
    @FXML
    private Button showDeckButton;
    @FXML
    private Button showLeadersButton;
    @FXML
    private Label turn = new Label();
    @FXML
    private Button backButton;

    @FXML
    void initialize(){
        turn.setText(player1.getUsername() + "'s turn\n\n" + player1.getUsername() + " is not ready\n" + player2.getUsername() + " is not ready");
    }
    public static Player getPlayer1() {
        return player1;
    }

    public static Player getPlayer2() {
        return player2;
    }

    public static Game getGame() {
        return game;
    }

    public static void setPlayer1(Player player1) {
        PreGameMenu.player1 = player1;
    }

    public static void setPlayer2(Player player2) {
        PreGameMenu.player2 = player2;
    }

    public static void setGame(Game game) {
        PreGameMenu.game = game;
    }

    public void ready(MouseEvent mouseEvent){
        if(!player1Turn){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you want to start the game?");
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
                try {
                    Game game = new Game(player1,player2);
                    App.setGame(game);
                    Launcher.changeScene(FXMLAddresses.GAME_MENU.getAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        else {
            player1Turn = false;
            turn.setText(player2.getUsername() + "'s turn\n\n" + player1.getUsername() + " is ready\n" + player2.getUsername() + " is not ready");

        }
    }

    public void showFactions(){
        try {
            Launcher.changeScene(FXMLAddresses.FACTION_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCards(MouseEvent mouseEvent){
        try {
            Launcher.changeScene(FXMLAddresses.CARDS_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDeck(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.DECK_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLeaders(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene(FXMLAddresses.LEADER_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mainMenu(MouseEvent mouseEvent) {
        MainMenuController.lunchMainMenu();
    }
}