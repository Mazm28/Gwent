package controller;

import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import server.User;

public class ShowGameHistoryController {
    public void showBox(VBox box) {
        Timeline timeline = ShowInfoController.startVBox(box);

    }

    public void setLabel(Label label, int index) {
        if(index >= User.getLoggedInUser().getGameRecords().size() || index < 0) return;
        String s = "Game " + index + "\n" + User.getLoggedInUser().getGameRecords().get(index).toString();
        label.setText(s);
    }
}
