package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.GameRecord;
import model.User;
import view.ShowInformation;

import java.util.Timer;

public class ShowInfoController {
    public void showBox(VBox box, Label label) {
        box.setScaleY(0);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(box.scaleYProperty(),1);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        timeline.setOnFinished(event -> setLabel(label));
    }

    public void setLabel(Label label) {
        int wins = 0;
        int loses = 0;
        int draws = 0;
        for (GameRecord gameRecord: User.getLoggedInUser().getGameRecords()){
            if(gameRecord.getWinner().equals(User.getLoggedInUser())) wins++;
            else if(gameRecord.getWinner().equals(gameRecord.getOpponent())) loses++;
            else draws++;
        }
        StringBuilder text = new StringBuilder();
        text.append("Username: ");
        text.append(User.getLoggedInUser().getUsername());
        text.append("\nNickname: ");
        text.append(User.getLoggedInUser().getNickname());
        text.append("\nHighest Score: ");
        text.append(User.getLoggedInUser().getHighestScore());
        text.append("\nRank: ");
        text.append(User.getLoggedInUser().getRank());
        text.append("\nCount Of Games: ");
        text.append(wins + draws + loses);
        text.append("\nCount Of Wins: ");
        text.append(wins);
        text.append("\nCount Of Loses: ");
        text.append(loses);
        text.append("\nCount Of Draws: ");
        text.append(draws);
        label.setText(text.toString());
    }
}
