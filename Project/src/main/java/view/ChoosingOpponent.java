package view;

import Enums.FXMLAddresses;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import model.Player;
import model.PreGame;
import server.User;

import java.io.IOException;

public class ChoosingOpponent {

    public Button confirmButton;
    public Button profileMenuButton;
    public TextField username;
    public Label error;

    public void confirm(){
        if(User.getUserByUsername(username.getText()) == null)
            error.setText("No such user!");
        else if(username.getText().equals(User.getLoggedInUser().getUsername()))
            error.setText("You cannot play with yourself!");
        else{
            User user = User.getLoggedInUser();
            User opponent = User.getUserByUsername(username.getText());
            Player player1 = new Player(user);
            player1.makeAllCards();
            PreGame.setPlayer1(player1);
            PreGame.setUser1(user);
            PreGame.setUser2(opponent);
            PreGame.setUserTurn(user);
            PreGame.setTurn(player1);
            Player player2 = new Player(opponent);
            player2.makeAllCards();
            PreGame.setPlayer2(player2);
            try {
                Launcher.changeScene(FXMLAddresses.PRE_GAME_MENU.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    public void mainMenu(MouseEvent mouseEvent){
        try {
            Launcher.changeScene(FXMLAddresses.MAIN_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void confirm2(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) confirm();
    }
}
