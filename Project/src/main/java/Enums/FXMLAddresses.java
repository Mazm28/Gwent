package Enums;

public enum FXMLAddresses {
    LOGIN_MENU("/FXML/LoginMenu.fxml"),
    ANSWER_QUESTION("/FXML/AnswerQuestion.fxml"),
    MAIN_MENU("/FXML/MainMenu.fxml"),
    REGISTER_MENU("/FXML/RegisterMenu.fxml"),
    SELECT_QUESTION("/FXML/SelectQuestion.fxml"),
    CHANGE_INFO("/FXML/ChangeInformation.fxml"),
    SHOW_INFO("/FXML/ShowInformation.fxml"),
    PROFILE_MENU("/FXML/ProfileMenu.fxml"),
    SHOW_GAME_HISTORY("/FXML/ShowGameHistory.fxml"),
    CARDS_MENU("/FXML/CardsMenu.fxml"),
    CHOOSE_OPPONENT("/FXML/ChoosingOpponent.fxml"),
    DECK_MENU("/FXML/DeckMenu.fxml"),
    FACTION_MENU("/FXML/FactionsMenu.fxml"),
    LEADER_MENU("/FXML/LeadersMenu.fxml"),
    PRE_GAME_MENU("/FXML/PreGameMenu.fxml"),
    STARTING_GAME_MENU("/FXML/StartingGameMenu.fxml"),
    SHOW_PASSWORD("/FXML/ShowPassword.fxml"),
    GAME_MENU("FXML/GameMenu.fxml"),
    ;
    private final String address;

    FXMLAddresses(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }
}
