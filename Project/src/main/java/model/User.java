package model;

import Regexes.SelectQuestionTexts;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private static User loggedInUser;
    private static ArrayList<User> users = new ArrayList<>();
    private ArrayList<GameRecords> gameRecords = new ArrayList<>();
    private String username;
    private String password;
    private String email;
    private String nickname;
    private SelectQuestionTexts selectQuestionTexts;
    private String answer;

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        users.add(this);
    }

    public static User getUserByUsername(String username) {
        for (User user : users) {
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

    public static User getUserWithUsername(String username) {
        return null;
    }

    public static ArrayList<User> getUsers() {
        return users;
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
