package model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;

public class User {
    private ArrayList<Game> games = new ArrayList<>();
    private static ArrayList<User> users = new ArrayList<>();
    private String username;
    private String password;
    private String email;
    private String nickname;
    private HashMap <Integer,String> securityQuestion = new HashMap<>();

    public User(String username, String password, String email, String nickname) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.nickname = nickname;
        users.add(this);
    }

    public static User getUserWithUsername(String username){
        return null;
    }
    public void addToSecurityQuestions(int qNumber, String answer){
        securityQuestion.put(qNumber,answer);
    }
    public static ArrayList<User> getUsers() {
        return users;
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
