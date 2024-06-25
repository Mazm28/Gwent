package view;

import Regexes.FXMLAddresses;
import javafx.fxml.Initializable;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import model.App;
import model.PreGame;
import model.card.Card;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DeckMenu implements Initializable {
    private ScrollPane scrollPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        scrollPane = new ScrollPane();
        VBox vBox = new VBox();
        for (Card card : PreGame.getTurn().getDeck()) {
            Image image = new Image(Objects.requireNonNull(getClass().getResourceAsStream(card.getImageAddress())));
            ImageView imageView = new ImageView(image);
            vBox.getChildren().add(imageView);
        }
        scrollPane.setContent(vBox);
        scrollPane.setPrefSize(200, 400);
    }

    public void preGameMenu() {
        try {
            Launcher.changeScene(FXMLAddresses.PRE_GAME_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}