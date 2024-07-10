package view;

import Enums.FXMLAddresses;
import Enums.ImageAddresses;
import Enums.MusicAddresses;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.App;
import server.User;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Launcher extends Application {
    private static Stage primaryStage;
    private static MediaPlayer mediaPlayer;

    public static void main(String[] args) {
        Media media = new Media(Objects.requireNonNull(Launcher.class.getResource(MusicAddresses.TOSS_A_COIN_TO_YOUR_WITCHER.getAddress())).toExternalForm());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.setOnEndOfMedia(() -> mediaPlayer.seek(Duration.ZERO));
        mediaPlayer.play();
        App.setMediaPlayer(mediaPlayer);
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        App.setStage(stage);
        primaryStage = stage;
        stage.setWidth(App.getWIDTH());
        stage.setHeight(App.getHEIGHT());
        stage.setResizable(false);
        stage.getIcons().add(new Image(Objects.requireNonNull(Launcher.class.getResource(ImageAddresses.ICON.getAddress())).toExternalForm()));
        User user = App.isAnyRemembered();
        URL url;
        if (user != null) {
            User.setLoggedInUser(user);
            url = getClass().getResource(FXMLAddresses.MAIN_MENU.getAddress());
        }
        else url = getClass().getResource(FXMLAddresses.LOGIN_MENU.getAddress());
        assert url != null;
        Parent root = FXMLLoader.load(url);
        App.setRoot(root);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        scene.setFill(Color.TRANSPARENT);
        stage.show();




































    }

    public static void changeScene(String fxml) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(Launcher.class.getResource(fxml)));
        primaryStage.getScene().setRoot(root);
        primaryStage.show();
    }
}
