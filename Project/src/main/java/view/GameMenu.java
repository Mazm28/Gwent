package view;

import controller.ActionController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import model.App;
import model.CardCollection;
import model.Game;
import model.card.Card;
import model.card.RegularCard;
import model.card.SpecialCard;
import model.card.SpecialCardInformation;

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

    private Label siegePowerLabel;
    private Label rangedPowerLabel;
    private Label closePowerLabel;
    private Label siegePowerLabel1;
    private Label rangedPowerLabel1;
    private Label closePowerLabel1;

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

    private HBox siegePlayHBox;
    private HBox rangedPlayHBox;
    private HBox closePlayHBox;
    private HBox siegePlayHBox2;
    private HBox rangedPlayHBox2;
    private HBox closePlayHBox2;

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
    private final HashMap<HBox, Label> positionToLabel = new HashMap<>();
    private Card selectedCard;
    private ImageView selectedCardImage;
    private final ArrayList<HBox> positions = new ArrayList<>();

    public void initialize() {
        game = App.getGame();
        addPositions();
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
        siegePlayHBox = tSiegeHBox;
        rangedPlayHBox = tRangedHBox;
        closePlayHBox = tCloseHBox;
        siegePlayHBox2 = eSiegeHBox;
        rangedPlayHBox2 = eRangedHBox;
        closePlayHBox2 = eCloseHBox;

        siegePowerLabel = tSiegePowerLabel;
        rangedPowerLabel = tRangedPowerLabel;
        closePowerLabel = tClosePowerLabel;
        siegePowerLabel1 = eSiegePowerLabel;
        rangedPowerLabel1 = eRangedPowerLabel;
        closePowerLabel1 = eClosePowerLabel;

        positionToLabel.put(siegePlayHBox, siegePowerLabel);
        positionToLabel.put(rangedPlayHBox, rangedPowerLabel);
        positionToLabel.put(closePlayHBox, closePowerLabel);
        positionToLabel.put(siegePlayHBox2, siegePowerLabel1);
        positionToLabel.put(rangedPlayHBox2, rangedPowerLabel1);
        positionToLabel.put(closePlayHBox2, closePowerLabel1);
    }

    private EventHandler<? super MouseEvent> moveUnitCardToPosition(HBox hBox) {
        return (EventHandler<MouseEvent>) event -> {
            moveCardToPosition(hBox);
        };
    }

    private void moveCardToPosition(HBox hBox) {
        if(selectedCard.getName().equals(SpecialCardInformation.Decoy.getName())) return;
        Image image = new Image(Objects.requireNonNull(
                getClass().getResourceAsStream(selectedCard.getImageAddress())));
        ImageView imageView = new ImageView(image);
        imageViewOnBoard.put(imageView, selectedCard);
        imageView.setFitHeight(60);
        imageView.setFitWidth(40);
        imageView.getStyleClass().add("button-image");
        imageView.setOnMouseClicked(selectedCardFromBoard(imageView, hBox));
        hBox.getChildren().add(imageView);
        removeFilters();
        bigCard.setVisible(false);
        if (selectedCard.getAbility() != null)
            selectedCard.getAbility().run();
        updateLabel(hBox);
        mainTableHBox.getChildren().remove(selectedCardImage);
        game.getCurrentPlayer().removeFromInGameHand(selectedCard);
        changeTurn();
        updateTotalPower();
    }

    private void updateLabel(HBox hBox) {
        Label label = positionToLabel.get(hBox);
        int newPower;
        if (selectedCard instanceof RegularCard) {
            newPower = Integer.parseInt(label.getText()) + ((RegularCard) selectedCard).getPower();
        } else {
            newPower = Integer.parseInt(label.getText()) + ((SpecialCard) selectedCard).getPower();
        }
        label.setText(String.valueOf(newPower));
    }

    private void updateTotalPower() {
        int power;
        power = Integer.parseInt(tSiegePowerLabel.getText()) +
                Integer.parseInt(tRangedPowerLabel.getText()) +
                Integer.parseInt(tClosePowerLabel.getText());
        tTotalPowerLabel.setText(String.valueOf(power));

        power = Integer.parseInt(eSiegePowerLabel.getText()) +
                Integer.parseInt(eRangedPowerLabel.getText()) +
                Integer.parseInt(eClosePowerLabel.getText());
        eTotalPowerLabel.setText(String.valueOf(power));
    }

    private void prepareTable() {
        mainTableHBox.getChildren().clear();
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
        if (card.getName().equals("Decoy")) {
            filterForDecoy();
        } else if (CardCollection.isUnit(card)) {
            if (card instanceof RegularCard) type = ((RegularCard) card).getType();
            else type = ((SpecialCard) card).getType();
            if (card.getAbility() != null && card.getAbility().equals(ActionController.Spy())) {
                switch (type) {
                    case "Close" :
                        makeFilterOnHBox(closePlayHBox2);
                        break;
                    case "Siege" :
                        makeFilterOnHBox(siegePlayHBox2);
                        break;
                    case "Ranged" :
                        makeFilterOnHBox(rangedPlayHBox2);
                        break;
                    case "Agile" :
                        makeFilterOnHBox(closePlayHBox2);
                        makeFilterOnHBox(rangedPlayHBox2);
                        break;
                    default :
                        System.out.println("sag");
                }
            } else {
                switch (type) {
                    case "Close" :
                        makeFilterOnHBox(closePlayHBox);
                        break;
                    case "Siege" :
                        makeFilterOnHBox(siegePlayHBox);
                        break;
                    case "Ranged" :
                        makeFilterOnHBox(rangedPlayHBox);
                        break;
                    case "Agile" :
                        makeFilterOnHBox(closePlayHBox);
                        makeFilterOnHBox(rangedPlayHBox);
                        break;
                    default : System.out.println("sag");
                }
            }
        }
    }

    private void filterForDecoy() {
        for(HBox hBox : positions) {
            for (Node node : hBox.getChildren()) {
                ImageView imageView = (ImageView) node;
                imageView.setDisable(false);
            }
        }
    }

    private EventHandler<? super MouseEvent> selectedCardFromBoard(ImageView imageView, HBox hBox) {
        return (EventHandler<MouseEvent>) event -> {
            if(!bigCard.isVisible()) return;
            if(selectedCard.getName().equals(SpecialCardInformation.Decoy.getName())) {
                System.out.println("sag");
                hBox.getChildren().remove(imageView);
                updateLabel(hBox);
                moveCardToPosition(hBox);
                removeFilters();
            }
        };
    }

    private void makeFilterOnHBox(HBox hBox) {
        hBox.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null , BorderStroke.THICK)));
        hBox.setDisable(false);
    }

    private void removeFilters() {
        for (HBox hBox : positions) {
            hBox.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, null , null)));
//            hBox.setDisable(true);
        }
//        for(HBox hBox : positions) {
//            for (Node node : hBox.getChildren()) {
//                ImageView imageView = (ImageView) node;
////                imageView.getStyleClass().add("image");
////                imageView.setDisable(true);
//            }
//        }
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
        bigCard.setVisible(false);
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
        double temp;

        temp = eCloseHBox.getLayoutY();
        eCloseHBox.setLayoutY(tCloseHBox.getLayoutY());
        tCloseHBox.setLayoutY(temp);
        temp = eRangedHBox.getLayoutY();
        eRangedHBox.setLayoutY(tRangedHBox.getLayoutY());
        tRangedHBox.setLayoutY(temp);
        temp = eSiegeHBox.getLayoutY();
        eSiegeHBox.setLayoutY(tSiegeHBox.getLayoutY());
        tSiegeHBox.setLayoutY(temp);

        if (siegePlayHBox.equals(tSiegeHBox)) {
            siegePlayHBox = eSiegeHBox;
            siegePlayHBox2 = tSiegeHBox;
        } else {
            siegePlayHBox = tSiegeHBox;
            siegePlayHBox2 = eSiegeHBox;
        }
        if (rangedPlayHBox.equals(tRangedHBox)) {
            rangedPlayHBox = eRangedHBox;
            rangedPlayHBox2 = tRangedHBox;
        } else {
            rangedPlayHBox = tRangedHBox;
            rangedPlayHBox2 = eRangedHBox;
        }
        if (closePlayHBox.equals(tCloseHBox)) {
            closePlayHBox = eCloseHBox;
            closePlayHBox2 = tCloseHBox;
        } else {
            closePlayHBox = tCloseHBox;
            closePlayHBox2 = eCloseHBox;
        }

        temp = eClosePowerLabel.getLayoutY();
        eClosePowerLabel.setLayoutY(tClosePowerLabel.getLayoutY());
        tClosePowerLabel.setLayoutY(temp);
        temp = eRangedPowerLabel.getLayoutY();
        eRangedPowerLabel.setLayoutY(tRangedPowerLabel.getLayoutY());
        tRangedPowerLabel.setLayoutY(temp);
        temp = eSiegePowerLabel.getLayoutY();
        eSiegePowerLabel.setLayoutY(tSiegePowerLabel.getLayoutY());
        tSiegePowerLabel.setLayoutY(temp);

        if (siegePowerLabel.equals(tSiegePowerLabel)) {
            siegePowerLabel = eSiegePowerLabel;
            siegePowerLabel1 = tSiegePowerLabel;
        } else {
            siegePowerLabel = tSiegePowerLabel;
            siegePowerLabel1 = eSiegePowerLabel;
        }
        if (rangedPowerLabel.equals(tRangedPowerLabel)) {
            rangedPowerLabel = eRangedPowerLabel;
            rangedPowerLabel1 = tRangedPowerLabel;
        } else {
            rangedPowerLabel = tRangedPowerLabel;
            rangedPowerLabel1 = eRangedPowerLabel;
        }
        if (closePowerLabel.equals(tClosePowerLabel)) {
            closePowerLabel = eClosePowerLabel;
            closePowerLabel1 = tClosePowerLabel;
        } else {
            closePowerLabel = tClosePowerLabel;
            closePowerLabel1 = eClosePowerLabel;
        }

        temp = eTotalPowerLabel.getLayoutY();
        eTotalPowerLabel.setLayoutY(tTotalPowerLabel.getLayoutY());
        tTotalPowerLabel.setLayoutY(temp);
    }
}
