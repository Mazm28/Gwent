package view;

import Enums.FXMLAddresses;
import Enums.ImageAddresses;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import model.App;
import model.Game;
import model.PreGame;

import java.io.IOException;
import java.util.Objects;

public class FinishRound {
    @FXML
    private HBox eHBOX;
    @FXML
    private HBox yHBOX;
    @FXML
    private Circle winOrLose;

    public void initialize(){
        Game game = App.getGame();
        if(game.getRounds()[game.getRoundNumber() - 1].winner() == null){
            winOrLose.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.DRAW.getAddress())))));
        } else if(game.getRounds()[game.getRoundNumber() - 1].winner().equals(game.getPlayer1())){
            winOrLose.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.WIN.getAddress())))));
        } else {
            winOrLose.setFill(new ImagePattern(new Image(Objects.requireNonNull(getClass().getResourceAsStream(ImageAddresses.LOSE.getAddress())))));
        }
        for(int i=1;i<game.getRoundNumber();i++){
            ((Label)yHBOX.getChildren().get(i)).setText(String.valueOf(game.getPlayer1().getPoints()[game.getRoundNumber()-1]));
            ((Label)eHBOX.getChildren().get(i)).setText(String.valueOf(game.getPlayer2().getPoints()[game.getRoundNumber()-1]));
        }
    }

    public void nextRound() {
        try {
            Launcher.changeScene(FXMLAddresses.STARTING_GAME_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void backToLobby() {
        try {
            Launcher.changeScene(FXMLAddresses.MAIN_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
