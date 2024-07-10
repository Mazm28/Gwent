package view;

import Enums.FXMLAddresses;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.App;
import model.Deck;
import model.PreGame;
import model.card.Card;
import model.card.LeaderCard;

import java.io.IOException;
import java.util.Objects;

public class DeckMenu {
    @FXML
    private ImageView leader;
    @FXML
    private ImageView faction;
    @FXML
    private TextField deckName;
    @FXML
    private Label error;
    @FXML
    private VBox mainBox;
    private VBox vBox;
    private HBox hBox;

    public void initialize() {
        error.setText("Please enter a deck name");
        vBox = new VBox();
        hBox = new HBox();
        showFactionAndLeader();
        showDeck();
        ScrollPane scrollPane = new ScrollPane(vBox);
        scrollPane.getStyleClass().add("scroll-pane");
        scrollPane.setPrefSize(510, 620);
        mainBox.getChildren().add(scrollPane);
    }

    private void showFactionAndLeader() {
        try {
            Image factionImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(PreGame.getTurn().getFaction().getAddress())));
            faction.setImage(factionImage);
        } catch (NullPointerException e) {
        }
        try {
            Image factionImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(PreGame.getTurn().getDeck().getFaction().getAddress())));
            faction.setImage(factionImage);
        } catch (NullPointerException e) {
        }
        try {
            Image leaderImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(PreGame.getTurn().getLeader().getImageAddress())));
            leader.setImage(leaderImage);
        } catch (NullPointerException e) {
        }
        try {
            Image leaderImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(PreGame.getTurn().getDeck().getLeaderCard().getImageAddress())));
            leader.setImage(leaderImage);
        } catch (NullPointerException e) {
        }
    }

    public void preGameMenu() {
        try {
            Launcher.changeScene(FXMLAddresses.PRE_GAME_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void saveDeck() {
        String deckNameString = deckName.getText();
        if (deckNameString.isEmpty()) {
            error.setText("Please enter a deck name!");
        } else if (PreGame.getTurn().getDeckByName(deckNameString) != null) {
            error.setText("There is a deck with given name!");
        } else {
            PreGame.getTurn().getDeck().setName(deckNameString);
            PreGame.getTurn().getDeck().setLeaderCard((LeaderCard) PreGame.getTurn().getLeader());
            PreGame.getTurn().getDeck().setFaction(PreGame.getTurn().getFaction());
            PreGame.getUserTurn().addToDecks(PreGame.getTurn().getDeck());
            App.SaveInfo(PreGame.getUserTurn());
            error.setText("Deck saved successfully!");
        }
    }

    public void loadDeck() {
        String deckNameString = deckName.getText();
        if (deckNameString.isEmpty()) {
            error.setText("Please enter a deck name");
        } else {
            Deck deck = PreGame.getUserTurn().getDeckByName(deckNameString);
            if (deck == null) {
                error.setText("There isn't such deck");
            } else {
                PreGame.getTurn().setDeck(deck);
                PreGame.getTurn().setFaction(deck.getFaction());
                PreGame.getTurn().setLeader(deck.getLeaderCard());
                vBox.getChildren().clear();
                showFactionAndLeader();
                showDeck();
                error.setText("Deck loaded successfully!");
            }
        }
    }

    public void showDeck() {
        int cardInRow = 0;
        for (Card card : PreGame.getTurn().getDeck().getCards()) {
            if (cardInRow % 3 == 0) {
                hBox = new HBox();
                hBox.setSpacing(15);
                hBox.setMaxWidth(400);
            }
            cardInRow++;
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            imageView.setFitHeight(220);
            imageView.setFitWidth(121);
            imageView.getStyleClass().add("image");
            hBox.getChildren().add(imageView);
            if (cardInRow % 3 == 1) vBox.getChildren().add(hBox);
        }
    }
}