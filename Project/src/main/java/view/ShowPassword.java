package view;

import Enums.FXMLAddresses;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import server.User;

import java.io.IOException;

public class ShowPassword {
    @FXML
    private Label label;
    public void initialize() {
        label.setText("Your password is: " + User.getTempUser().getPassword());
    }

    public void mainMenu() throws IOException {
        User.setLoggedInUser(User.getTempUser());
        Launcher.changeScene(FXMLAddresses.MAIN_MENU.getAddress());
    }

    public void login(MouseEvent mouseEvent) throws IOException {
        Launcher.changeScene(FXMLAddresses.LOGIN_MENU.getAddress());
    }
}
