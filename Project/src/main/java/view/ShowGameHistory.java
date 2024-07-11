package view;

import Enums.FXMLAddresses;
import controller.ShowGameHistoryController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.VBox;
import server.User;

import java.io.IOException;

public class ShowGameHistory {
    private final ShowGameHistoryController showGameHistoryController = new ShowGameHistoryController();
    @FXML
    private Label label;
    @FXML
    private TextField number;
    @FXML
    private VBox box;

    public Label getLabel() {
        return label;
    }

    public void initialize() {
        showGameHistoryController.showBox(box);
    }

    public void show(KeyEvent keyEvent) {
        if (keyEvent.getCode().equals(KeyCode.ENTER)) {
            show2();
        }
    }

    public void profileMenu() {
        try {
            Launcher.changeScene(FXMLAddresses.PROFILE_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void show2() {
        int index = Integer.parseInt(number.getText()) - 1;
        if (index >= User.getLoggedInUser().getGameRecords().size() || index < 0) {
            System.out.println("dwawdadawdawdaw");
            return;
        }
        String s = "Game " + (index + 1) + "\n" + User.getLoggedInUser().getGameRecords().get(index).toString();
        label.setText(s);
    }
}
