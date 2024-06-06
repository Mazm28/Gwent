package view;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.User;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class AnswerQuestion implements Initializable {
    @FXML
    private Label error;
    @FXML
    private Label question;
    @FXML
    private TextField answer;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        question.setText(User.getLoggedInUser().getSelectQuestionTexts().getText());
    }

    public void checkAnswer() {
        User user = User.getLoggedInUser();
        if (user.getAnswer().equals(answer.getText())) {
            try {
                Launcher.changeScene("/FXML/MainMenu.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else error.setText("wrong answer!");
    }

    public void back() {
        try {
            Launcher.changeScene("/FXML/LoginMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
