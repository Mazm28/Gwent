package view;

import controller.GameMenuController;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.Game;
import model.Player;
import model.User;

import java.io.IOException;

public class ChoosingOpponent {

    public Button confirmButton;
    public Button profileMenuButton;
    public TextField username;
    public Label error;

    public void confirm(MouseEvent mouseEvent){
        if(User.getUserByUsername(username.getText()) == null)
            error.setText("No such user!");
        else if(User.getUserByUsername(username.getText()) == User.getLoggedInUser())
            error.setText("You cannot play with yourself!");
        else{
            String player1Username = User.getLoggedInUser().getUsername();
            String player1Password = User.getLoggedInUser().getPassword();
            String player1Nickname = User.getLoggedInUser().getNickname();
            String player1Email = User.getLoggedInUser().getEmail();
            String player2Username = User.getUserByUsername(username.getText()).getUsername();
            String player2Password = User.getUserByUsername(username.getText()).getPassword();
            String player2Nickname = User.getUserByUsername(username.getText()).getPassword();
            String player2Email = User.getUserByUsername(username.getText()).getEmail();
            PreGameMenu.setPlayer1(new Player(player1Username, player1Password, player1Email, player1Nickname));
            PreGameMenu.setPlayer2(new Player(player2Username, player2Password, player2Email, player2Nickname));
            try {
                Launcher.changeScene("/FXML/PreGameMenu.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void mainMenu(MouseEvent mouseEvent){
        try {
            Launcher.changeScene("/FXML/MainMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
