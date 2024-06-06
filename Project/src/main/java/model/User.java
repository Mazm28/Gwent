package model;

import Regexes.SelectQuestionTexts;
import controller.SaveUsersController;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class User implements Serializable {
    private static User loggedInUser;
    private ArrayList<GameRecords> gameRecords = new ArrayList<>();
    private String username;
    private String password;
    private String email;
    private String nickname;
    private SelectQuestionTexts selectQuestionTexts;
    private String answer;
    private int id;
    private static User tempUser;

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

    public void addToGameRecords(GameRecords gameRecords){
        this.gameRecords.add(gameRecords);
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
}
