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
        System.out.println(cards.size());
        for (Card card : cards) {
            try {
                Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
                ImageView imageView = new ImageView(image);
                imageView.setFitHeight(300);
                imageView.setFitWidth(210);
                imageView.getStyleClass().add("image");
                imageView.setOnMouseClicked(selectCard(imageView));
                images.put(imageView, card);
                vBox.getChildren().add(imageView);
            }
            catch (Exception ignored){
            }

        }
    }
    private EventHandler<? super MouseEvent> selectCard(ImageView imageView) {
        return (EventHandler<MouseEvent>) event -> {
            if(deckVBox.getChildren().contains(imageView)){
                PreGame.getTurn().removeCardFromDeck(images.get(imageView));
                PreGame.getTurn().addToAllCards(images.get(imageView));
            } else {
                PreGame.getTurn().getDeck().addToCards(images.get(imageView));
                PreGame.getTurn().removeCard(images.get(imageView));
            }
            ArrayList<Card> cardsToShow = new ArrayList<>(PreGame.getTurn().getCardByFaction(PreGame.getTurn().getFaction()));
            cardsToShow.addAll(PreGame.getTurn().getSpecialCards());
            showCards(cardVBox, cardsToShow);
            showCards(deckVBox,PreGame.getTurn().getDeck().getCards());
        };
    }
}
