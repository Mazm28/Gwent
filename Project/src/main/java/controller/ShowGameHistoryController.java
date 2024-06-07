package controller;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import model.GameRecord;
import model.User;
import view.GameHistory;

public class ShowGameHistoryController {
    public void showBox(VBox box) {
    }

    public void setLabel(Label label, int index) {
        if(index >= User.getLoggedInUser().getGameRecords().size() || index < 0) return;
        String s = "Game " + index + "\n" + User.getLoggedInUser().getGameRecords().get(index).toString();
        label.setText(s);
    }
}
