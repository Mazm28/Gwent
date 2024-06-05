package view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;

public class Launcher extends Application{
    private static Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        primaryStage = stage;
        stage.setResizable(false);
//        TODO: set icon
        URL url = getClass().getResource("/FXML/LoginMenu.fxml");
        assert url != null;
        Parent root = FXMLLoader.load(url);
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
