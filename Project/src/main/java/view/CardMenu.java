package view;

import Enums.FXMLAddresses;
import Enums.ImageAddresses;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.CardCollection;
import model.PreGame;
import model.card.Card;
import model.card.RegularCard;
import model.card.SpecialCard;
import model.card.SpecialCardInformation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class CardMenu {
    @FXML
    private Circle heroCardsCircle;
    @FXML
    private Label heroCards;
    @FXML
    private Circle unitCardsCircle;
    @FXML
    private Label unitCards;
    @FXML
    private Label specialCards;
    @FXML
    private Circle specialCardsCircle;
    @FXML
    private Circle unitStrengthCircle;
    @FXML
    private Label unitStrength;
    @FXML
    private Circle cardsInDeckCircle;
    @FXML
    private Label cardsInDeck;
    @FXML
    private VBox deck;
    @FXML
    private VBox cards;
    private final HashMap<Card, Integer> indexes = new HashMap<>();
    VBox cardVBox;
    VBox deckVBox;
    HBox hBox;
    int cardInRow = 0;
    public void initialize() {
        for (Card card: PreGame.getTurn().getDeck().getCards()){
            for(Card card1: PreGame.getTurn().getAllCards()){
                if(card1.getName().equals(card.getName())){
                    PreGame.getTurn().removeCard(card1);
                    break;
                }
            }
        }
        heroCardsCircle.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.HERO.getAddress())))));
        unitCardsCircle.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.UNIT.getAddress())))));
        specialCardsCircle.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.SPECIAL.getAddress())))));
        cardsInDeckCircle.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.COUNT.getAddress())))));
        unitStrengthCircle.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.STRENGTH.getAddress())))));
        setTexts();
        cardVBox = new VBox();
        cardVBox.setAlignment(Pos.CENTER);
        ScrollPane cardsScrollPane = new ScrollPane(cardVBox);
        cardsScrollPane.getStyleClass().add("scroll-pane");
        cardsScrollPane.setPrefSize(510, 620);
        cards.setAlignment(Pos.TOP_CENTER);
        cards.getChildren().add(cardsScrollPane);
        ArrayList<Card> cardsToShow = new ArrayList<>(CardCollection.getCardByFaction(PreGame.getTurn().getFaction(),PreGame.getTurn().getAllCards()));
        System.out.println(CardCollection.getNeutralCards(PreGame.getTurn().getAllCards()).size());
        cardsToShow.addAll(CardCollection.getNeutralCards(PreGame.getTurn().getAllCards()));

        showCards(cardVBox, cardsToShow);
        deckVBox = new VBox();
        deckVBox.setAlignment(Pos.CENTER);
        ScrollPane deckScrollPane = new ScrollPane(deckVBox);
        deckScrollPane.getStyleClass().add("scroll-pane");
        deckScrollPane.setPrefSize(510, 620);
        deck.setAlignment(Pos.CENTER);
        deck.getChildren().add(deckScrollPane);
        showCards(deckVBox,PreGame.getTurn().getDeck().getCards());
    }

    public void showCards(VBox vBox, ArrayList<Card> cards) {
        vBox.getChildren().clear();
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
                imageView.getStyleClass().add("image");
                imageView.setFitHeight(220);
                imageView.setFitWidth(121);
                imageView.setOnMouseClicked(selectCard(card));
                hBox.getChildren().add(imageView);
                if (cardInRow % 3 == 1) vBox.getChildren().add(hBox);
            }
            catch (Exception e) {
                System.out.println(card.getName());
            }
        }
    }

    private EventHandler<? super MouseEvent> selectCard(Card card) {
        return (EventHandler<MouseEvent>) event -> {
            if(PreGame.getTurn().getDeck().getCards().contains(card)){
                PreGame.getTurn().removeCardFromDeck(card);
                PreGame.getTurn().addToAllCards(indexes.get(card),card);
            } else {
                if(!(CardCollection.isSpecial(card) && specialCards.getText().equals("10/10"))) {
                    PreGame.getTurn().getDeck().addToCards(card);
                    indexes.put(card,PreGame.getTurn().getAllCards().indexOf(card));
                    PreGame.getTurn().removeCard(card);
                }
            }
            ArrayList<Card> cardsToShow = new ArrayList<>(CardCollection.getCardByFaction(PreGame.getTurn().getFaction(),PreGame.getTurn().getAllCards()));
            cardsToShow.addAll(CardCollection.getNeutralCards(PreGame.getTurn().getAllCards()));
            showCards(cardVBox, cardsToShow);
            showCards(deckVBox,PreGame.getTurn().getDeck().getCards());
            setTexts();
        };
    }

    private void setTexts() {
        unitStrength.setText(Integer.toString(CardCollection.getCardsTotalStrength(PreGame.getTurn().getDeck().getCards())));
        cardsInDeck.setText(Integer.toString(PreGame.getTurn().getDeck().getCards().size()));
        specialCards.setText(CardCollection.getSpecials(PreGame.getTurn().getDeck().getCards()).size() + "/10");
        unitCards.setText(Integer.toString(CardCollection.getUnitCards(PreGame.getTurn().getDeck().getCards()).size()));
        heroCards.setText(Integer.toString(CardCollection.getHero(PreGame.getTurn().getDeck().getCards()).size()));
    }

    public void BackToPreGame() {
        try {
            Launcher.changeScene(FXMLAddresses.PRE_GAME_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
