package controller;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import model.User;

public class ShowGameHistoryController {
    public void showBox(VBox box) {
        box.setScaleY(0);
        Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(box.scaleYProperty(),1);
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(1),keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
    }

    public void setLabel(Label label, int index) {
        if(index >= User.getLoggedInUser().getGameRecords().size() || index < 0) return;
        String s = "Game " + index + "\n" + User.getLoggedInUser().getGameRecords().get(index).toString();
        label.setText(s);
    }
}
