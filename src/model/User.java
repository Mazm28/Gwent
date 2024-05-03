package model;

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
    private HashMap<Integer, String> securityQuestion = new HashMap<>();

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        users.add(this);
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

    public void addToSecurityQuestions(int qNumber, String answer) {
        securityQuestion.put(qNumber, answer);
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

    public HashMap<Integer, String> getSecurityQuestion() {
        return securityQuestion;
    }
}
