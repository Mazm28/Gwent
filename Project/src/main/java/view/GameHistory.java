package view;

import Regexes.FXMLAddresses;
import controller.ShowGameHistoryController;
import controller.ShowInfoController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class GameHistory {
    @FXML
    private Label label;
    @FXML
    private TextField number;
    @FXML
    private VBox box;
    private final ShowGameHistoryController showGameHistoryController = new ShowGameHistoryController();
    public void initialize(){
        showGameHistoryController.showBox(box);
    }
    public void show(KeyEvent keyEvent){
        if(keyEvent.getCode().equals(KeyCode.ENTER)) {
            showGameHistoryController.setLabel(label, Integer.parseInt(number.getText())-1);
        }
    }
    public void profileMenu() {
        try {
            Launcher.changeScene(FXMLAddresses.PROFILE_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
