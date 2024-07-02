package view;

import Enums.FXMLAddresses;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import model.App;
import model.Game;
import model.Player;
import model.card.Card;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class StartingGameMenu {
    @FXML
    public ImageView middleImageView;
    @FXML
    public ImageView rightImageView;
    @FXML
    public ImageView leftImageView;
    @FXML
    public Button finishBtn;
    private int iterator = 0;
    private Game game;
    private int changedCards = 0;

    public void initialize() {
        game = App.getGame();
        game.getCurrentPlayer().setRemainCard(game.getCurrentPlayer().getDeck().getCards());
        choosingDeck();
    }

    private void choosingDeck() {
        makeHand(game.getCurrentPlayer());
        loadImages();
    }

    private void makeHand(Player currentPlayer) {
        ArrayList<Card> cards = currentPlayer.getRemainCard();
        Collections.shuffle(cards);
        for (int i = 0; i < 10; i++) {
            if (i < cards.size()) {
                currentPlayer.addToInGameHand(cards.get(i));
            }
        }
        for (Card card : currentPlayer.getInGameHand()) {
            currentPlayer.removeFromRemainCard(card);
        }
    }

    public void finishChoosingDeck() {
        game.changeTurn();
        if (game.getCurrentPlayer().isChoosedHand()) {
            try {
                Launcher.changeScene(FXMLAddresses.GAME_MENU.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            game.getOpponent().setChoosedHand(true);
            game.getCurrentPlayer().setRemainCard(game.getCurrentPlayer().getDeck().getCards());
            choosingDeck();
            iterator = 0;
            loadImages();
        }
    }

    public void chooseCard() {
        game.getCurrentPlayer().addToRemainCard(game.getCurrentPlayer().getInGameHand().get(iterator));
        game.getCurrentPlayer().removeFromInGameHand(game.getCurrentPlayer().getInGameHand().get(iterator));
        ArrayList<Card> cards = game.getCurrentPlayer().getRemainCard();
        Collections.shuffle(cards);
        game.getCurrentPlayer().addToInGameHand(game.getCurrentPlayer().getRemainCard().getFirst());
        changedCards++;
        if (changedCards == 2) finishChoosingDeck();
        else {
            loadImages();
        }
    }

    public void moveLeft() {
        iterator--;
        loadImages();
    }

    public void moveRight() {
        iterator++;
        loadImages();
    }

    public void loadImages() {
        Image middleImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                game.getCurrentPlayer().getInGameHand().get(iterator).getImageAddress())));
        middleImageView.setImage(middleImage);
        middleImageView.getStyleClass().add("image");

        if (iterator + 1 < game.getCurrentPlayer().getInGameHand().size()) {
            rightImageView.setDisable(false);
            rightImageView.setVisible(true);
            Image rightImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                    game.getCurrentPlayer().getInGameHand().get(iterator + 1).getImageAddress())));
            rightImageView.setImage(rightImage);
            rightImageView.getStyleClass().add("image");
        } else {
            rightImageView.setDisable(true);
            rightImageView.setVisible(false);
        }
        if (iterator - 1 >= 0) {
            leftImageView.setDisable(false);
            leftImageView.setVisible(true);
            Image leftImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                    game.getCurrentPlayer().getInGameHand().get(iterator - 1).getImageAddress())));
            leftImageView.setImage(leftImage);
            leftImageView.getStyleClass().add("image");
        } else {
            leftImageView.setDisable(true);
            leftImageView.setVisible(false);
        }
    }
}