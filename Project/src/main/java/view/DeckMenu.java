package view;

import Enums.FXMLAddresses;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.App;
import model.Deck;
import model.PreGame;
import model.User;
import model.card.Card;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

public class DeckMenu implements Initializable {
    @FXML
    TextField deckName;
    @FXML
    Label error;
    @FXML
    VBox mainBox;
    VBox vBox;
    private final HashMap<ImageView, Card> images = new HashMap<>();
    private Card selectedCard;
    private ImageView selectedImage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ScrollPane scrollPane = new ScrollPane();
        vBox = new VBox();
        showDeck();
        scrollPane.setContent(vBox);
        scrollPane.setPrefSize(511, 555);
        scrollPane.setOpacity(0.4);
        mainBox.getChildren().add(scrollPane);
    }

    private EventHandler<? super MouseEvent> selectCard(ImageView imageView) {
        selectedCard = images.get(imageView);
        selectedImage = imageView;
        return null;
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
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            imageView.setOnMouseClicked(selectCard(imageView));
            images.put(imageView, card);
            vBox.getChildren().add(imageView);
        }
    }
}