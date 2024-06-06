package view;

import Regexes.SelectQuestionTexts;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;

import java.io.IOException;

public class SelectQuestion {
    @FXML
    private TextField answer;

    public void setQuestion1() {
        setQuestion(SelectQuestionTexts.QUESTION1);
    }

    public void setQuestion2() {
        setQuestion(SelectQuestionTexts.QUESTION2);
    }

    public void setQuestion3() {
        setQuestion(SelectQuestionTexts.QUESTION3);
    }

    private void setQuestion(SelectQuestionTexts selectQuestionTexts) {
        User user = User.getLoggedInUser();
        user.setSelectQuestionTexts(selectQuestionTexts);
        user.setAnswer(answer.getText());
        try {
            Launcher.changeScene("/FXML/MainMenu.fxml");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
