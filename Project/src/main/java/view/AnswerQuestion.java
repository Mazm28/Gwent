package view;

import Enums.FXMLAddresses;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import server.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnswerQuestion implements Initializable {
    @FXML
    private TextField username;
    @FXML
    private Label error;
    @FXML
    private Label question;
    @FXML
    private TextField answer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        question.setText(User.getTempUser().getSelectQuestionTexts().getText());
    }

    public void checkAnswer() {
        User user = User.getTempUser();
        if (user.getAnswer().equals(answer.getText())) {
            try {
                User.setTempUser(user);
                Launcher.changeScene(FXMLAddresses.SHOW_PASSWORD.getAddress());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else error.setText("Wrong answer!");
    }

    public void back() {
        try {
            Launcher.changeScene(FXMLAddresses.LOGIN_MENU.getAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void answer(KeyEvent keyEvent) {
        if(keyEvent.getCode().equals(KeyCode.ENTER)) checkAnswer();
    }

    public TextField getAnswer() {
        return answer;
    }
}
