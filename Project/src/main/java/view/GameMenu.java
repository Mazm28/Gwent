package view;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.App;
import model.Game;
import model.Player;
import model.card.Card;

import java.util.ArrayList;
import java.util.Collections;

public class GameMenu {
    @FXML public Label eSiegePowerLabel;
    @FXML public Label eRangedPowerLabel;
    @FXML public Label tSiegePowerLabel;
    @FXML public Label tRangedPowerLabel;
    @FXML public Label eClosePowerLabel;
    @FXML public Label tClosePowerLabel;
    @FXML public Label eTotalPowerLabel;
    @FXML public Label tTotalPowerLabel;
    @FXML public ImageView eLeaderImageView;
    @FXML public ImageView tLeaderImageView;
    @FXML public HBox mainTableHBox;
    @FXML public HBox tSiegeHBox;
    @FXML public HBox tRangedHBox;
    @FXML public HBox tCloseHBox;
    @FXML public HBox eSiegeHBox;
    @FXML public HBox eRangedHBox;
    @FXML public HBox eCloseHBox;
    @FXML public HBox specialCardHBox;
    @FXML public ImageView eRemainDeckImageView;
    @FXML public ImageView tRemainDeckImageView;
    @FXML public ImageView eDeadCardImageView;
    @FXML public ImageView tDeadCardImageView;
    @FXML public ImageView eLeaderUsedIcon;
    @FXML public ImageView tLeaderUsedIcon;
    @FXML public ImageView middleImageView;
    @FXML public ImageView rightImageView;
    @FXML public ImageView leftImageView;
    @FXML public Button finishBtn;
    private int iterator = 0;
    private Game game;
    private int changedCards = 0;

    public void initialize() {
        game = App.getGame();
        choosingDeck();
    }

    private void choosingDeck() {
        makeHand(game.getCurrentPlayer());
        replaceDeck(game.getCurrentPlayer());
    }

    private void makeHand(Player currentPlayer) {
        ArrayList<Card> cards = currentPlayer.getRemainCard();
        Collections.shuffle(cards);
        for (int i = 0; i < 10; i++) {
            if (i < cards.size()) {
                currentPlayer.addToRemainCard(cards.get(i));
            }
        }
        for (Card card : cards) {
            currentPlayer.removeFromRemainCard(card);
        }
    }

    private void replaceDeck(Player currentPlayer) {
        leftImageView.setVisible(false);
        middleImageView.setImage(new Image(currentPlayer.getInGameHand().get(iterator).getImageAddress()));
        rightImageView.setImage(new Image(currentPlayer.getInGameHand().get(iterator + 1).getImageAddress()));
    }

    public void finishChoosingDeck() {
        game.changeTurn();
        if (game.getCurrentPlayer().isChoosedHand()) {
            App.getIngredient().getChildren().removeAll(middleImageView, rightImageView, leftImageView);
        } else {
            game.getOpponent().setChoosedHand(true);
            makeHand(game.getCurrentPlayer());
            replaceDeck(game.getCurrentPlayer());
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
    }

    public void moveRight() {
        iterator++;
        //you were here
    }
}