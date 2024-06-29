package view;

import Enums.Faction;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import model.PreGame;
import model.card.Card;
import model.card.RegularCard;
import model.card.SpecialCard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class CardMenu {
    @FXML
    private VBox deck;
    @FXML
    private VBox cards;
    private final HashMap<ImageView, Card> images = new HashMap<>();
    VBox cardVBox;
    VBox deckVBox;
    HBox hBox;
    int cardInRow = 0;
    public void initialize() {
        cardVBox = new VBox();
        cardVBox.setSpacing(45);
        cardVBox.setAlignment(Pos.CENTER);
        ScrollPane cardsScrollPane = new ScrollPane(cardVBox);
        cardsScrollPane.getStyleClass().add("scroll-pane");
        cardsScrollPane.setPrefSize(510, 620);
        cardVBox.setPadding(new Insets(0,0,0,90));
        cards.setAlignment(Pos.TOP_CENTER);
        cards.getChildren().add(cardsScrollPane);
        ArrayList<Card> cardsToShow = new ArrayList<>(PreGame.getTurn().getCardByFaction(PreGame.getTurn().getFaction()));
        cardsToShow.addAll(PreGame.getTurn().getSpecialCards());
        showCards(cardVBox, cardsToShow);
        deckVBox = new VBox();
        deckVBox.setAlignment(Pos.CENTER);
        deckVBox.setSpacing(45);
        deckVBox.setPadding(new Insets(0,0,0,90));
        ScrollPane deckScrollPane = new ScrollPane(deckVBox);
        deckScrollPane.getStyleClass().add("scroll-pane");
        deckScrollPane.setPrefSize(510, 620);
        deck.setAlignment(Pos.CENTER);
        deck.getChildren().add(deckScrollPane);
        showCards(deckVBox,PreGame.getTurn().getDeck().getCards());
    }

    public void showCards(VBox vBox, ArrayList<Card> cards) {
        vBox.getChildren().remove(0,vBox.getChildren().size());
        cardInRow = 0;
        for (Card card : cards) {
            try {
                if (cardInRow % 3 == 0) {
                    hBox = new HBox();
                    hBox.setSpacing(15);
                    hBox.setMaxWidth(400);
                }
                cardInRow++;
                Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(150);
                imageView.setFitWidth(70);
                imageView.getStyleClass().add("image");
                imageView.setOnMouseClicked(selectCard(imageView));
                images.put(imageView, card);
                hBox.getChildren().add(imageView);
                if (cardInRow % 3 == 1) vBox.getChildren().add(hBox);
            }
            catch (Exception ignored){
            }

        }
    }
    private EventHandler<? super MouseEvent> selectCard(ImageView imageView) {
        return (EventHandler<MouseEvent>) event -> {
            PreGame.getTurn().getDeck().addToCards(images.get(imageView));
            PreGame.getTurn().removeCard(images.get(imageView));
            ArrayList<Card> cardsToShow = new ArrayList<>(PreGame.getTurn().getCardByFaction(PreGame.getTurn().getFaction()));
            cardsToShow.addAll(PreGame.getTurn().getSpecialCards());
            showCards(cardVBox, cardsToShow);
            showCards(deckVBox,PreGame.getTurn().getDeck().getCards());
        };
    }
}
