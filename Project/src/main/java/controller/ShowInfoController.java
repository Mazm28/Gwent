package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.GameRecord;
import server.User;

public class ShowInfoController {
    public void showBox(VBox box, Label label) {
        Timeline timeline = startVBox(box);
        timeline.setOnFinished(event -> setLabel(label));
    }

    static Timeline startVBox(VBox box) {
        box.setScaleY(0);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(box.scaleYProperty(),1);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
        return timeline;
    }

    public void setLabel(Label label) {
        User.getLoggedInUser().setWinsAndLoses();
        User.getLoggedInUser().makeRank();
        StringBuilder text = new StringBuilder();
        text.append("Username: ");
        text.append(User.getLoggedInUser().getUsername());
        text.append("\nNickname: ");
        text.append(User.getLoggedInUser().getNickname());
        text.append("\nHighest Score: ");
        text.append(User.getLoggedInUser().usersHighestScore());
        text.append("\nRank: ");
        text.append(User.getLoggedInUser().getRank());
        text.append("\nCount Of Games: ");
        text.append(User.getLoggedInUser().getWins() + User.getLoggedInUser().getDraws() + User.getLoggedInUser().getLoses());
        text.append("\nCount Of Wins: ");
        text.append(User.getLoggedInUser().getWins());
        text.append("\nCount Of Loses: ");
        text.append(User.getLoggedInUser().getLoses());
        text.append("\nCount Of Draws: ");
        text.append(User.getLoggedInUser().getDraws());
        label.setText(text.toString());
    }
}
