package Regexes;

public enum SelectQuestionTexts {
    QUESTION1("Your favorite football player?"),
    QUESTION2("Your favorite video game?"),
    QUESTION3("Your favorite movie?");

    String text;

    SelectQuestionTexts(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
