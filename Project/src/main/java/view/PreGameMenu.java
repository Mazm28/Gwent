package view;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
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
    public Button readyButton;
    public Button showFactionsButton;
    public Button showCardsButton;
    public Button showDeckButton;
    public Button showLeadersButton;
    public Label turn = new Label();
    public Button backButton;

    @FXML
    void initialize(){
        turn.setText(User.getLoggedInUser().getUsername() + "'s turn");
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
            try {
                Launcher.changeScene("/FXML/GameMenu.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else {
            player1Turn = false;
            turn.setText(player2.getUsername() + "'s turn");
        }

    }

    public void showFactions(MouseEvent mouseEvent){
        try {
            Launcher.changeScene("/FXML/FactionsMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCards(MouseEvent mouseEvent){
        try {
            Launcher.changeScene("/FXML/CardsMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showDeck(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene("/FXML/DeckMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showLeaders(MouseEvent mouseEvent) {
        try {
            Launcher.changeScene("/FXML/LeadersMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void mainMenu(MouseEvent mouseEvent) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setContentText("Are you sure?");
        Optional<ButtonType> buttonType = alert.showAndWait();
        if (buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
            try {
                Launcher.changeScene("/FXML/MainMenu.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}