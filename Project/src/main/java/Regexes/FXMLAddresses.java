package Regexes;

import view.MainMenu;
import view.RegisterMenu;
import view.SelectQuestion;

public enum FXMLAddresses {
    LOGINMENU("/FXML/LoginMenu.fxml"),
    ANSWERQUESTION("/FXML/AnswerQuestion.fxml"),
    MAINMENU("/FXML/MainMenu.fxml"),
    REGISTERMENU("/FXML/RegisterMenu.fxml"),
    SELECTQUESTION("/FXML/SelectQuestion.fxml"),
    CHANGE_INFO("/FXML/ChangeInformation.fxml"),
    SHOW_INFO("/FXML/ShowInformation.fxml"),
    PROFILE_MENU("/FXML/ProfileMenu.fxml"),
    GAME_HISTORY("/FXML/GameHistory.fxml"),
    ;
    String address;

    FXMLAddresses(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
