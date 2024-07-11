package view;

import Enums.FXMLAddresses;
import Enums.Faction;
import controller.ActionController;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import model.*;
import model.card.Card;
import model.card.RegularCard;
import model.card.SpecialCard;
import model.card.SpecialCardInformation;

import javax.net.ssl.HostnameVerifier;
import java.io.IOException;
import java.util.*;

public class GameMenu {
    private final HashMap<ImageView, Card> imageViewCardHashMap = new HashMap<>();
    private static final HashMap<ImageView, Card> imageViewOnBoard = new HashMap<>();
    private final ArrayList<HBox> positions = new ArrayList<>();
    private final ArrayList<HBox> specialPositions = new ArrayList<>();
    private final ArrayList<Label> labels = new ArrayList<>();
    private final HashMap<Card, ImageView> cardsHashMap = new HashMap<>();

    public static HashMap<ImageView, Card> getImageViewOnBoardHashMap() {
        return imageViewOnBoard;
    }

    @FXML
    public Label eSiegePowerLabel;
    @FXML
    public Label eRangedPowerLabel;
    @FXML
    public Label tSiegePowerLabel;
    @FXML
    public Label tRangedPowerLabel;
    @FXML
    public Label eClosePowerLabel;
    @FXML
    public Label tClosePowerLabel;
    @FXML
    public Label eTotalPowerLabel;
    @FXML
    public Label tTotalPowerLabel;
    @FXML
    public ImageView eLeaderImageView;
    @FXML
    public ImageView tLeaderImageView;
    @FXML
    public HBox mainTableHBox;
    @FXML
    public HBox tSiegeHBox;
    @FXML
    public HBox tRangedHBox;
    @FXML
    public HBox tCloseHBox;
    @FXML
    public HBox eSiegeHBox;
    @FXML
    public HBox eRangedHBox;
    @FXML
    public HBox eCloseHBox;
    @FXML
    public HBox specialCardHBox;
    @FXML
    public ImageView eRemainCardsImageView;
    @FXML
    public ImageView tRemainCardsImageView;
    @FXML
    public ImageView eDeadCardImageView;
    @FXML
    public ImageView tDeadCardImageView;
    @FXML
    public ImageView eLeaderUsedIcon;
    @FXML
    public ImageView tLeaderUsedIcon;
    @FXML
    public ImageView bigCard;
    @FXML
    public HBox specialHBox0;
    @FXML
    public HBox specialHBox1;
    @FXML
    public HBox specialHBox2;
    @FXML
    public HBox specialHBox3;
    @FXML
    public HBox specialHBox4;
    @FXML
    public HBox specialHBox5;
    @FXML
    public HBox weatherHBox;
    private Game game;
    private Card selectedCard;
    private ImageView selectedCardImage;

    public void initialize() {
        game = App.getGame();
        addPositions();
        prepareTable();
        showLeadersImage();
    }

    private void showLeadersImage() {
        Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                game.getCurrentPlayer().getLeader().getImageAddress())));
        tLeaderImageView.setImage(image);
        image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(
                game.getOpponent().getLeader().getImageAddress())));
        eLeaderImageView.setImage(image);
    }

    private void addPositions() {
        for(Row row: game.getRows()){
            row.getCards().clear();
        }
        positions.addAll(List.of(new HBox[]{tSiegeHBox, tRangedHBox, tCloseHBox,
                eCloseHBox, eRangedHBox, eSiegeHBox}));
        for (HBox hBox : positions) {
            hBox.setSpacing(7);
            hBox.setDisable(true);
            hBox.setOnMouseClicked(moveUnitCardToPosition(hBox));
        }

        specialPositions.addAll(List.of(new HBox[]{specialHBox0, specialHBox1, specialHBox2,
                specialHBox3, specialHBox4, specialHBox5}));
        for (HBox hBox : specialPositions) {
            hBox.setSpacing(7);
            hBox.setDisable(true);
            hBox.setOnMouseClicked(moveUnitCardToPosition(hBox));
        }

        weatherHBox.setOnMouseClicked(moveUnitCardToPosition(weatherHBox));

        labels.addAll(List.of(new Label[]{tSiegePowerLabel, tRangedPowerLabel, tClosePowerLabel,
                eClosePowerLabel, eRangedPowerLabel, eSiegePowerLabel}));
        for (Label label : labels) {
            label.setText("0");
        }
    }

    private EventHandler<? super MouseEvent> moveUnitCardToPosition(HBox hBox) {
        return (EventHandler<MouseEvent>) event -> {
            moveCardToPosition(hBox);
        };
    }


    private void moveCardToPosition(HBox hBox) {
        ArrayList<HBox> hboxArrayList = null;
        if (positions.contains(hBox)) {
            hboxArrayList = positions;
        } else if (specialPositions.contains(hBox)) {
            hboxArrayList = specialPositions;
        }
        Image image = new Image(Objects.requireNonNull(
                getClass().getResourceAsStream(selectedCard.getImageAddress())));
        ImageView imageView = new ImageView(image);
        imageViewOnBoard.put(imageView, selectedCard);
        imageView.setFitHeight(60);
        imageView.setFitWidth(40);
        imageView.getStyleClass().add("button-image");
        imageView.setOnMouseClicked(selectedCardFromBoard(imageView, hBox));
        hBox.getChildren().add(imageView);
        game.getCurrentPlayer().removeFromInGameHand(selectedCard);
        bigCard.setImage(null);
        if (selectedCard.getAbility() != null) {
            game.setActionNode(imageView);
            game.setAction(selectedCard);
            selectedCard.getAbility().run();
        }
        removeFilters();
        mainTableHBox.getChildren().remove(selectedCardImage);
        if (positions.contains(hBox)) {
            game.getRows()[hboxArrayList.indexOf(hBox)].addCardToCards(selectedCard);
            if (hboxArrayList.indexOf(hBox) > 2) {
                game.getPlayer2().getRows()[hboxArrayList.indexOf(hBox) - 3].addCardToCards(selectedCard);
            } else {
                game.getPlayer1().getRows()[hboxArrayList.indexOf(hBox)].addCardToCards(selectedCard);
            }
        } else if (specialPositions.contains(hBox)) {
            game.getRows()[hboxArrayList.indexOf(hBox)].setImproveCard(selectedCard);
            if (hboxArrayList.indexOf(hBox) > 2) {
                game.getPlayer2().getRows()[hboxArrayList.indexOf(hBox) - 3].setImproveCard(selectedCard);
            } else {
                game.getPlayer1().getRows()[hboxArrayList.indexOf(hBox)].setImproveCard(selectedCard);
            }
        } else {
            try {
                if (((SpecialCard) selectedCard).getType().equals("Weather")) {
                    game.addToWeathersCards(selectedCard);
                }
            } catch (Exception ignored) {

            }
        }
        for (Card card : game.getWeathersCards()) {
            if (card.getAbility() != null) card.getAbility().run();
        }
        updateLabels();
        changeTurn();
        updateTotalPower();
    }

    private void updateTotalPower() {
        int power;
        power = Integer.parseInt(tSiegePowerLabel.getText()) +
                Integer.parseInt(tRangedPowerLabel.getText()) +
                Integer.parseInt(tClosePowerLabel.getText());
        tTotalPowerLabel.setText(String.valueOf(power));
        game.getPlayer1().setPoints(game.getRoundNumber(), power);
        power = Integer.parseInt(eSiegePowerLabel.getText()) +
                Integer.parseInt(eRangedPowerLabel.getText()) +
                Integer.parseInt(eClosePowerLabel.getText());
        eTotalPowerLabel.setText(String.valueOf(power));
        game.getPlayer2().setPoints(game.getRoundNumber(), power);
    }

    private void prepareTable() {
        mainTableHBox.getChildren().clear();
        for (Card card : game.getCurrentPlayer().getInGameHand()) {
            mainTableHBox.setSpacing(3);
            Image image = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            imageViewCardHashMap.put(imageView, card);
            cardsHashMap.put(card, imageView);
            imageView.setFitHeight(60);
            imageView.setFitWidth(40);
            imageView.getStyleClass().add("button-image");
            imageView.setOnMouseClicked(selectCard(imageView));
            mainTableHBox.getChildren().add(imageView);
        }
        weatherHBox.getChildren().clear();
        for (Card card : game.getWeathersCards()) {
            Image image = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            cardsHashMap.put(card, imageView);
            imageView.setFitHeight(60);
            imageView.setFitWidth(40);
            weatherHBox.getChildren().add(imageView);
        }
    }

    public EventHandler<? super MouseEvent> selectCard(ImageView imageView) {
        return (EventHandler<MouseEvent>) event -> {
            removeFilters();
            selectedCard = imageViewCardHashMap.get(imageView);
            selectedCardImage = imageView;
            selectedCard = imageViewCardHashMap.get(imageView);
            Image image = new Image(Objects.requireNonNull(
                    getClass().getResourceAsStream(selectedCard.getImageAddress())));
            bigCard.setImage(image);
            bigCard.setVisible(true);
            filterForCard(selectedCard);
        };
    }

    private void filterForCard(Card card) {
        int turn = game.getTurn();
        boolean x = (turn % 2 == 1);
        String type;
        if (card.getName().equals("Decoy")) {
            filterForDecoy();
        } else if (CardCollection.isUnit(card)) {
            if (card instanceof RegularCard) type = ((RegularCard) card).getType();
            else type = ((SpecialCard) card).getType();
            if (card.getAbility() != null && card.getAbility().equals(ActionController.Spy())) {
                switch (type) {
                    case "Close":
                        if (x) makeFilterOnHBox(eCloseHBox);
                        else makeFilterOnHBox(tCloseHBox);
                        break;
                    case "Siege":
                        if (x) makeFilterOnHBox(eSiegeHBox);
                        else makeFilterOnHBox(tSiegeHBox);
                        break;
                    case "Ranged":
                        if (x) makeFilterOnHBox(eRangedHBox);
                        else makeFilterOnHBox(tRangedHBox);
                        break;
                    case "Agile":
                        if (x) {
                            makeFilterOnHBox(eCloseHBox);
                            makeFilterOnHBox(eRangedHBox);
                        } else {
                            makeFilterOnHBox(tCloseHBox);
                            makeFilterOnHBox(tRangedHBox);
                        }
                        break;
                    default:
                        System.out.println("sag");
                }
            } else {
                switch (type) {
                    case "Close":
                        if (!x) makeFilterOnHBox(eCloseHBox);
                        else makeFilterOnHBox(tCloseHBox);
                        break;
                    case "Siege":
                        if (!x) makeFilterOnHBox(eSiegeHBox);
                        else makeFilterOnHBox(tSiegeHBox);
                        break;
                    case "Ranged":
                        if (!x) makeFilterOnHBox(eRangedHBox);
                        else makeFilterOnHBox(tRangedHBox);
                        break;
                    case "Agile":
                        if (!x) {
                            makeFilterOnHBox(eCloseHBox);
                            makeFilterOnHBox(eRangedHBox);
                        } else {
                            makeFilterOnHBox(tCloseHBox);
                            makeFilterOnHBox(tRangedHBox);
                        }
                        break;
                    default:
                        System.out.println("sag");
                }
            }
        } else if (card.getName().equals("Commander_Horn") || card.getName().equals("Mardoeme")) {
            if (x) {
                makeFilterOnHBox(specialHBox0);
                makeFilterOnHBox(specialHBox1);
                makeFilterOnHBox(specialHBox2);
            } else {
                makeFilterOnHBox(specialHBox3);
                makeFilterOnHBox(specialHBox4);
                makeFilterOnHBox(specialHBox5);
            }
        } else if (card instanceof SpecialCard) {
            if (((SpecialCard) card).getType().equals("Weather")) {
                makeFilterOnHBox(weatherHBox);
            } else {
                if (!x) {
                    makeFilterOnHBox(eCloseHBox);
                    makeFilterOnHBox(eRangedHBox);
                    makeFilterOnHBox(eSiegeHBox);
                } else {
                    makeFilterOnHBox(tCloseHBox);
                    makeFilterOnHBox(tRangedHBox);
                    makeFilterOnHBox(tSiegeHBox);
                }
            }
        }
    }

    private void filterForDecoy() {
        int turn = game.getTurn();
        if (turn % 2 == 1) {
            for (int i = 0; i < 3; i++) {
                positions.get(i).setDisable(false);
                for (Node node : positions.get(i).getChildren()) {
                    ImageView imageView = (ImageView) node;
                    imageView.setDisable(false);
                }
            }
        } else {
            for (int i = 3; i < 6; i++) {
                positions.get(i).setDisable(false);
                for (Node node : positions.get(i).getChildren()) {
                    ImageView imageView = (ImageView) node;
                    imageView.setDisable(false);
                }
            }
        }
    }

    private EventHandler<? super MouseEvent> selectedCardFromBoard(ImageView imageView, HBox hBox) {
        return (EventHandler<MouseEvent>) event -> {
            if (selectedCard == null) return;
            if (selectedCard.getName().equals("Decoy")) {
                Card card = imageViewOnBoard.get(imageView);
                int x = -1;
                Player player = game.getPlayer1();
                if (hBox.equals(tSiegeHBox)) {
                    x = 0;
                    player = game.getPlayer1();
                } else if (hBox.equals(tRangedHBox)) {
                    x = 1;
                    player = game.getPlayer1();
                } else if (hBox.equals(tCloseHBox)) {
                    x = 2;
                    player = game.getPlayer1();
                } else if (hBox.equals(eCloseHBox)) {
                    x = 3;
                    player = game.getPlayer2();
                } else if (hBox.equals(eRangedHBox)) {
                    x = 4;
                    player = game.getPlayer2();
                } else if (hBox.equals(eSiegeHBox)) {
                    x = 5;
                    player = game.getPlayer2();
                }
                game.getRows()[x].addCardToCards(selectedCard);
                game.getRows()[x].removeCardFromCards(card);

                int y;
                if (x == 0 || x == 5) y = 0;
                else if (x == 1 || x == 4) y = 1;
                else y = 2;
                player.getRows()[y].addCardToCards(selectedCard);
                player.getRows()[y].removeCardFromCards(card);

                hBox.getChildren().remove(imageView);

                mainTableHBox.getChildren().add(imageView);
                game.getCurrentPlayer().addToInGameHand(card);
                updateLabels();
                removeFilters();
            }
        };
    }

    private void makeFilterOnHBox(HBox hBox) {
        hBox.setBorder(new Border(new BorderStroke(Color.CYAN, BorderStrokeStyle.SOLID, null, BorderStroke.THICK)));
        hBox.setDisable(false);
    }

    private void updateLabels() {
        for (HBox hBox : positions) {
            int newPower = 0;
            if (!specialPositions.get(positions.indexOf(hBox)).getChildren().isEmpty()) {
                ImageView imageView = (ImageView) specialPositions.get(positions.indexOf(hBox)).getChildren().get(0);
                if (imageViewOnBoard.get(imageView).getName().equals("Commander_Horn")) {
                    for (Node node : hBox.getChildren()) {
                        Card card1 = imageViewOnBoard.get((ImageView) node);
                        if (!(card1 instanceof RegularCard) || !((RegularCard) card1).isHero())
                            newPower += card1.getPower() * 2;
                    }
                    labels.get(positions.indexOf(hBox)).setText(String.valueOf(newPower));
                    continue;
                }
            }
            for (Node node : hBox.getChildren()) {
                Card card = imageViewOnBoard.get((ImageView) node);
                if (card.getName().equals("Crone: Brewess") || card.getName().equals("Draig Bon-Dhu")) {
                    newPower = 0;
                    for (Node node1 : hBox.getChildren()) {
                        Card card1 = imageViewOnBoard.get((ImageView) node1);
                        if (!(card1 instanceof RegularCard) || !((RegularCard) card1).isHero())
                            newPower += card1.getPower() * 2;
                    }
                    break;
                }
                newPower += imageViewOnBoard.get((ImageView) node).getPower();
            }
            labels.get(positions.indexOf(hBox)).setText(String.valueOf(newPower));
        }
    }

    private void removeFilters() {
        bigCard.setImage(null);
        for (HBox hBox : positions) {
            hBox.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, null, null)));
            hBox.setDisable(true);
        }
        for (HBox hBox : specialPositions) {
            hBox.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, null, null)));
            hBox.setDisable(true);
        }
        for (HBox hBox : positions) {
            for (Node node : hBox.getChildren()) {
                ImageView imageView = (ImageView) node;
                imageView.getStyleClass().add("image");
                imageView.setDisable(true);
            }
        }
        for (HBox hBox : specialPositions) {
            for (Node node : hBox.getChildren()) {
                ImageView imageView = (ImageView) node;
                imageView.getStyleClass().add("image");
                imageView.setDisable(true);
            }
        }

        weatherHBox.setBorder(new Border(new BorderStroke(Color.TRANSPARENT, BorderStrokeStyle.SOLID, null, null)));
        weatherHBox.setDisable(true);
    }

    public void pass() throws IOException {
        removeFilters();
        game.getCurrentPlayer().setPassedTheTurn(true);
        if (game.getOpponent().isPassedTheTurn()) {
            game.getCurrentPlayer().setPassedTheTurn(false);
            game.getOpponent().setPassedTheTurn(false);
            finishRound();
        }
        changeTurn();
    }

    private void finishRound() throws IOException {
        int player1Point = game.getPlayer1().getPoints()[game.getRoundNumber() - 1];
        int player2Point = game.getPlayer2().getPoints()[game.getRoundNumber() - 1];
        Round round = getRound(player1Point, player2Point);
        game.setRound(round);
        if (game.getPlayer1().getFaction().equals(Faction.MONSTERS)) {
            for (HBox hBox : positions) {
                if (!hBox.getChildren().isEmpty()) {
                    game.getPlayer1().addToInGameHand(imageViewOnBoard.get((ImageView) hBox.getChildren().getFirst()));
                }
            }
        }
        if (game.getPlayer2().getFaction().equals(Faction.MONSTERS)) {
            for (HBox hBox : positions) {
                if (!hBox.getChildren().isEmpty()) {
                    game.getPlayer2().addToInGameHand(imageViewOnBoard.get((ImageView) hBox.getChildren().getFirst()));
                }
            }
        }
        if (game.getRoundNumber() == 3) {
            Launcher.changeScene(FXMLAddresses.FINISH_GAME.getAddress());
        } else {
            game.setRoundNumber(game.getRoundNumber() + 1);
            try {
                Launcher.changeScene(FXMLAddresses.FINISH_ROUND.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private Round getRound(int player1Point, int player2Point) {
        Player winner = null;
        if (player1Point > player2Point) winner = game.getPlayer1();
        else if (player1Point < player2Point) winner = game.getPlayer2();
        else if (game.getPlayer1().getFaction().equals(Faction.NILFGAARD) && !game.getPlayer2().getFaction().equals(Faction.NILFGAARD)) {
            winner = game.getPlayer1();
        } else if (game.getPlayer2().getFaction().equals(Faction.NILFGAARD) && !game.getPlayer1().getFaction().equals(Faction.NILFGAARD)) {
            winner = game.getPlayer2();
        }
        if (winner != null && winner.getFaction().equals(Faction.NORTHERN_REALMS) && winner.equals(game.getPlayer1())) {
            game.getPlayer1().addToInGameHand(game.getPlayer1().getRemainCard().get(0));
        }
        if (winner != null && winner.getFaction().equals(Faction.NORTHERN_REALMS) && winner.equals(game.getPlayer2())) {
            game.getPlayer2().addToInGameHand(game.getPlayer1().getRemainCard().get(0));
        }
        return new Round(new int[]{player1Point, player2Point}, winner);
    }

    private void changeTurn() {
        if (game.getOpponent().isPassedTheTurn()) return;
        game.changeTurn();
        prepareTable();
    }
}