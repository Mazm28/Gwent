package view;

import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.PreGame;
import model.card.Card;
import model.card.RegularCard;
import model.card.SpecialCard;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

public class CardMenu {
    @FXML
    private VBox deck;
    @FXML
    private VBox cards;
    VBox cardVBox;
    VBox deckVBox;
    private final HashMap<ImageView, Card> images = new HashMap<>();
    private Card selectedCard;
    private ImageView selectedImage;
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cardVBox = new VBox();
        showCards(cardVBox,RegularCard.getCardsFromFaction(PreGame.getTurn().getFaction()));
        showCards(cardVBox, SpecialCard.getAllCards());
        ScrollPane cardsScrollPane = new ScrollPane(cardVBox);
        cardsScrollPane.getStyleClass().add("scroll-pane");
        cardsScrollPane.setPrefSize(510, 620);
        cards.getChildren().add(cardsScrollPane);
//        deckVBox = new VBox();
//        showCards();
//        ScrollPane deckScrollPane = new ScrollPane(deckVBox);
//        deckScrollPane.getStyleClass().add("scroll-pane");
//        deckScrollPane.setPrefSize(510, 620);
//        deck.getChildren().add(deckScrollPane);
    }

    public void showCards(VBox vBox, ArrayList<Card> cards) {
        for (Card card : cards) {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            imageView.setOnMouseClicked(selectCard(imageView));
            images.put(imageView, card);
            vBox.getChildren().add(imageView);
        }
    }
    private EventHandler<? super MouseEvent> selectCard(ImageView imageView) {
        selectedCard = images.get(imageView);
        selectedImage = imageView;
        return null;
    }
}
