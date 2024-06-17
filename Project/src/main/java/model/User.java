package model;

import Regexes.SelectQuestionTexts;
import controller.SaveUsersController;
import model.card.Card;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable {
    private static User loggedInUser;
    private ArrayList<GameRecord> gameRecords = new ArrayList<>();
    private String username;
    private String password;
    private ArrayList<ArrayList<Card>> decks = new ArrayList<>();
    private String email;
    private String nickname;
    private SelectQuestionTexts selectQuestionTexts;
    private String answer;
    private int id;
    private static User tempUser;
    private boolean remembered = false;
    public void addToDecks(ArrayList<Card> cards){
        decks.add(cards);
    }

    public User(User user) {
        this.username = user.username;
        this.password = user.password;
        this.email = user.email;
        this.nickname = user.nickname;
        this.id = user.id;
    }

    public boolean isRemembered() {
        return remembered;
    }

    public void setRemembered(boolean remembered) {
        this.remembered = remembered;
    }

    public int getHighestScore(){
        int point = 0;
        for(GameRecord gameRecord: gameRecords){
            if(gameRecord.getFinalPoints()[0] > point) point = gameRecord.getFinalPoints()[0];
        }
        return point;
    }

    public static User getTempUser() {
        return tempUser;
    }

    public static void setTempUser(User tempUser) {
        User.tempUser = tempUser;
    }

    public int getId() {
        return id;
    }

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        this.id = SaveUsersController.getUsers().size();
    }

    public static User getUserByUsername(String username) {
        for (User user : SaveUsersController.getUsers()) {
            if (user.username.equals(username)) {
                return user;
            }
        }
        return null;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }

    public static void setLoggedInUser(User loggedInUser) {
        User.loggedInUser = loggedInUser;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public void addToGameRecords(GameRecord gameRecord){
        this.gameRecords.add(gameRecord);
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getAnswer() {
        return answer;
    }

    public void setSelectQuestionTexts(SelectQuestionTexts selectQuestionTexts) {
        this.selectQuestionTexts = selectQuestionTexts;
    }

    public SelectQuestionTexts getSelectQuestionTexts() {
        return selectQuestionTexts;
    }

    public int getRank() {
        return 0;
    }

    public ArrayList<GameRecord> getGameRecords() {
        return gameRecords;
    }
}
