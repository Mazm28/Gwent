package view;

import Enums.FXMLAddresses;
import controller.ShowInfoController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import java.io.IOException;

public class ShowInformation {
    @FXML
    private Label label;
    @FXML
    private VBox box;

    private final ShowInfoController showInfoController = new ShowInfoController();
    public void initialize(){
        showInfoController.showBox(box,label);
    }

    public void profileMenu() {
        try {
            Launcher.changeScene(FXMLAddresses.PROFILE_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
