package Enums;

import java.io.Serializable;

public enum SelectQuestionTexts implements Serializable {
    QUESTION1("Your favorite football player?"),
    QUESTION2("Your favorite video game?"),
    QUESTION3("Your favorite movie?");

    private final String text;

    SelectQuestionTexts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
