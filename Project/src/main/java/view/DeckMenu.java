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
    private int cardInRow;

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
        } catch (NullPointerException e) {}
        try {
            Image leaderImage = new Image(Objects.requireNonNull(getClass().getResourceAsStream(PreGame.getTurn().getLeader().getImageAddress())));
            leader.setImage(leaderImage);
        } catch (NullPointerException e) {}
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
            error.setText("Please enter a deck name");
        } else {
            PreGame.getTurn().getDeck().setName(deckNameString);
            PreGame.getTurn().addToDeck(PreGame.getTurn().getDeck());
            App.SaveInfo(PreGame.getTurn());
            error.setText("Deck saved successfully!");
        }
    }

    public void loadDeck() {
        String deckNameString = deckName.getText();
        if (deckNameString.isEmpty()) {
            error.setText("Please enter a deck name");
        } else {
            Deck deck = PreGame.getTurn().getDeckByName(deckNameString);
            if (deck == null) {
                error.setText("There isn't such deck");
            } else {
                PreGame.getTurn().setDeck(deck);
                PreGame.getTurn().setFaction(deck.getFaction());
                PreGame.getTurn().setLeader(deck.getLeaderCard());
                vBox.getChildren().clear();
                showDeck();
            }
        }
    }

    public void showDeck() {
        for (Card card : PreGame.getTurn().getDeck().getCards()) {
            cardInRow++;
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            hBox.getChildren().add(imageView);
            if (cardInRow % 3 == 0) {
                vBox.getChildren().add(hBox);
                hBox = new HBox();
            }
        }
    }
}