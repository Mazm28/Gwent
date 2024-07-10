package controller;

import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import server.User;

public class ShowGameHistoryController {
    public void showBox(VBox box) {
        Timeline timeline = ShowInfoController.startVBox(box);
    }
}
