package view;

import Enums.FXMLAddresses;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import model.PreGame;
import model.card.Card;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Objects;
import java.util.ResourceBundle;

public class DeckMenu implements Initializable {
    @FXML
    Label error;
    @FXML
    VBox mainBox;
    private ScrollPane scrollPane;
    private HashMap<ImageView, Card> images = new HashMap<>();
    private Card selectedCard;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scrollPane = new ScrollPane();
        VBox vBox = new VBox();
        for (Card card : PreGame.getTurn().getDeck()) {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            imageView.setOnMouseClicked(selectCard(imageView));
            images.put(imageView, card);
            vBox.getChildren().add(imageView);
        }
        scrollPane.setContent(vBox);
        scrollPane.setPrefSize(200, 330);
        mainBox.getChildren().add(scrollPane);
    }

    private EventHandler<? super MouseEvent> selectCard(ImageView imageView) {
        selectedCard = images.get(imageView);
        return null;
    }

    public void preGameMenu() {
        try {
            Launcher.changeScene(FXMLAddresses.PRE_GAME_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeCard() {
        if (selectedCard != null) {
            PreGame.getTurn().getDeck().remove(selectedCard);
        } else error.setText("No card selected!");
    }

    public void loadDeck() {
    }

    public void saveDeck() {
    }
}