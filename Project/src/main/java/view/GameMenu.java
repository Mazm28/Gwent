package view;

import controller.ActionController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.App;
import model.CardCollection;
import model.Game;
import model.PreGame;
import model.card.Card;
import model.card.RegularCard;
import model.card.SpecialCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private final HashMap<ImageView, Card> imageViewOnBoard = new HashMap<>();
    private Card selectedCard;
    private ImageView selectedCardImage;
    private final ArrayList<HBox> positions = new ArrayList<>();

    public void initialize() {
        game = App.getGame();
        prepareLabels();
        prepareTable();
    }

    private void addPositions() {
        positions.addAll(List.of(new HBox[]{eCloseHBox, eRangedHBox, eSiegeHBox, tSiegeHBox, tCloseHBox, tRangedHBox}));
        for (HBox hBox : positions) {
            hBox.setSpacing(7);
            hBox.setDisable(true);
            hBox.setOnMouseClicked(moveUnitCardToPosition(hBox));
        }
    }

    private EventHandler<? super MouseEvent> moveUnitCardToPosition(HBox hBox) {
        return (EventHandler<MouseEvent>) event -> {
            Image image = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream(selectedCard.getImageAddress())));
            ImageView imageView = new ImageView(image);
            imageViewOnBoard.put(imageView, selectedCard);
            imageView.setFitHeight(60);
            imageView.setFitWidth(40);
            imageView.getStyleClass().add("image");
            hBox.getChildren().add(imageView);
            removeFilters();
            bigCard.setVisible(false);
            if (selectedCard.getAbility() != null)
                selectedCard.getAbility().run();
            mainTableHBox.getChildren().remove(selectedCardImage);
            changeTurn();
        };
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
            bigCard.setVisible(true);
            removeFilters();
            selectedCard = imageViewCardHashMap.get(imageView);
            selectedCardImage = imageView;
            filterForCard(selectedCard);
            selectedCard = imageViewCardHashMap.get(imageView);
            Image image = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream(selectedCard.getImageAddress())));
            bigCard.setImage(image);
        };
    }

    private void filterForCard(Card card) {
        String type;
        if (CardCollection.isUnit(card)) {
            if (card instanceof RegularCard) type = ((RegularCard) card).getType();
            else type = ((SpecialCard) card).getType();
            if (card.getAbility() != null && card.getAbility().equals(ActionController.Spy())) {
                switch (type) {
                    case "Close" :
                        makeFilterOnHBox(eCloseHBox);
                        break;
                    case "Siege" :
                        makeFilterOnHBox(eSiegeHBox);
                        break;
                    case "Ranged" :
                        makeFilterOnHBox(eRangedHBox);
                        break;
                    case "Agile" :
                        makeFilterOnHBox(eCloseHBox);
                        makeFilterOnHBox(eRangedHBox);
                        break;
                    default :
                        System.out.println("sag");
                }
            } else {
                switch (type) {
                    case "Close" :
                        makeFilterOnHBox(tCloseHBox);
                        break;
                    case "Siege" :
                        makeFilterOnHBox(tSiegeHBox);
                        break;
                    case "Ranged" :
                        makeFilterOnHBox(tRangedHBox);
                        break;
                    case "Agile" :
                        makeFilterOnHBox(tCloseHBox);
                        makeFilterOnHBox(tRangedHBox);
                        break;
                    default : System.out.println("sag");
                }
            }
        }
    }

    private void makeFilterOnHBox(HBox hBox) {
        hBox.setBackground(new Background(new BackgroundFill(Color.CYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        hBox.setOpacity(0.05);
        hBox.setDisable(false);
    }

    private void removeFilters() {
        for (HBox hBox : positions) {
            hBox.setBackground(new Background(new BackgroundFill(Color.TRANSPARENT, CornerRadii.EMPTY, Insets.EMPTY)));
            hBox.setOpacity(1);
            hBox.setDisable(true);
        }
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
        changeTurn();
    }

    private void finishRound() {
    }

    private void changeTurn() {
        if (game.getOpponent().isPassedTheTurn()) return;
        game.changeTurn();
        prepareTable();
        changeHBoxesPosition();
    }

    private void changeHBoxesPosition() {
    }
}
