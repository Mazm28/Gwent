package view;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import model.App;
import model.Game;
import model.card.Card;

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

    private Game game;
    private HashMap<ImageView, Card> imageViewCardHashMap;

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
            imageView.setFitHeight(60);
            imageView.setFitWidth(40);
            imageView.getStyleClass().add("button-image");
            mainTableHBox.getChildren().add(imageView);
        }
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                game.getCurrentPlayer().getLeader().getImageAddress())));
        tLeaderImageView.setImage(image);
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                game.getOpponent().getLeader().getImageAddress())));
        eLeaderImageView.setImage(image);
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
}
