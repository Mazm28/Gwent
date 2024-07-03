package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import model.App;
import model.CardCollection;
import model.Game;
import model.PreGame;
import model.card.Card;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

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

    @FXML public ImageView eRemainCardsImageView;
    @FXML public ImageView tRemainCardsImageView;
    @FXML public ImageView eDeadCardImageView;
    @FXML public ImageView tDeadCardImageView;
    @FXML public ImageView eLeaderUsedIcon;
    @FXML public ImageView tLeaderUsedIcon;
    @FXML public ImageView bigCard;

    private Game game;
    private final HashMap<ImageView, Card> imageViewCardHashMap = new HashMap<>();
    private Card selectedCard;

    public void initialize() {
        game = App.getGame();
        prepareLabels();
        prepareTable();
    }

    private void prepareTable() {
        for (Card card : game.getCurrentPlayer().getInGameHand()) {
            mainTableHBox.setSpacing(3);
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            imageViewCardHashMap.put(imageView, card);
            imageView.setFitHeight(60);
            imageView.setFitWidth(40);
            imageView.getStyleClass().add("button-image");
            imageView.setOnMouseClicked(selectCard(imageView));
            mainTableHBox.getChildren().add(imageView);
        }
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                game.getCurrentPlayer().getLeader().getImageAddress())));
        tLeaderImageView.setImage(image);
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                game.getOpponent().getLeader().getImageAddress())));
        eLeaderImageView.setImage(image);
    }

    private EventHandler<? super MouseEvent> selectCard(ImageView imageView) {
        return (EventHandler<MouseEvent>) event -> {
            selectedCard = imageViewCardHashMap.get(imageView);
            Image image = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream(selectedCard.getImageAddress())));
            bigCard.setImage(image);
        };
    }

    private void prepareLabels() {
        eSiegePowerLabel.setText("0");
        eRangedPowerLabel.setText("0");
        tSiegePowerLabel.setText("0");
        tRangedPowerLabel.setText("0");
        eClosePowerLabel.setText("0");
        tClosePowerLabel.setText("0");
        eTotalPowerLabel.setText("0");
        tTotalPowerLabel.setText("0");
    }

    public void pass() {
        game.getCurrentPlayer().setPassedTheTurn(true);
        if (game.getOpponent().isPassedTheTurn()) {
            game.getCurrentPlayer().setPassedTheTurn(false);
            game.getOpponent().setPassedTheTurn(false);
            finishRound();
        }
    }

    private void finishRound() {
    }
}
