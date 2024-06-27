package view;

import Enums.FXMLAddresses;
import controller.MainMenuController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.App;
import model.Game;
import model.PreGame;

import java.io.IOException;
import java.util.Optional;

public class PreGameMenu {
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
    private Label turnText = new Label();
    @FXML
    private Button backButton;

    @FXML
    void initialize() {
        if (PreGame.getTurn().equals(PreGame.getPlayer1()))
            turnText.setText(PreGame.getPlayer1().getUsername() + "'s turn\n\n" + PreGame.getPlayer1().getUsername() + " is not ready\n" + PreGame.getPlayer2().getUsername() + " is not ready");
        else
            turnText.setText(PreGame.getPlayer2().getUsername() + "'s turn\n\n" + PreGame.getPlayer1().getUsername() + " is ready\n" + PreGame.getPlayer2().getUsername() + " is not ready");
        if(PreGame.getTurn().getFaction() != null) showLeadersButton.setDisable(false);
//        if(PreGame.getTurn().getLeader() != null)
            showCardsButton.setDisable(false);
        if(PreGame.getTurn().getDeck().getCards().size() == 22) readyButton.setDisable(false);
    }

    public void ready(MouseEvent mouseEvent) {
        if (PreGame.getTurn().equals(PreGame.getPlayer2())) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setContentText("Are you sure you want to start the game?");
            Optional<ButtonType> buttonType = alert.showAndWait();
            if (buttonType.isPresent() && buttonType.get().equals(ButtonType.OK)) {
                try {
                    Game game = new Game(PreGame.getPlayer1(), PreGame.getPlayer2());
                    App.setGame(game);
                    Launcher.changeScene(FXMLAddresses.GAME_MENU.getAddress());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } else {
            PreGame.setTurn(PreGame.getPlayer2());
            turnText.setText(PreGame.getPlayer2().getUsername() + "'s turn\n\n" + PreGame.getPlayer1().getUsername() + " is ready\n" + PreGame.getPlayer2().getUsername() + " is not ready");
        }
    }

    public void showFactions() {
        try {
            Launcher.changeScene(FXMLAddresses.FACTION_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showCards(MouseEvent mouseEvent) {
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