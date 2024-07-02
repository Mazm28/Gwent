package model;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.module.SimpleModule;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import model.card.Card;
import model.card.LeaderCard;
import model.card.RegularCard;
import model.card.SpecialCard;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class App {
    private static final Random random = new Random();
    private static final double HEIGHT = 700;
    private static final double WIDTH = 1000;
    private static Parent root;
    private static Stage stage;
    private static Game game;
    private static MediaPlayer mediaPlayer;
    private static Group ingredient = new Group();

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        App.mediaPlayer = mediaPlayer;
    }

    public static double getHEIGHT() {
        return HEIGHT;
    }

    public static double getWIDTH() {
        return WIDTH;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        App.stage = stage;
    }

    public static Game getGame() {
        return game;
    }

    public static void setGame(Game game) {
        App.game = game;
    }

    public static Random getRandom() {
        return random;
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addAbstractTypeMapping(Card.class, LeaderCard.class);
        simpleModule.addAbstractTypeMapping(Card.class, RegularCard.class);
        simpleModule.addAbstractTypeMapping(Card.class, SpecialCard.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        File file = new File("Users.json");
        if (file.exists()) {
            try {
                users = objectMapper.readValue(file, new TypeReference<>() {
                });
            } catch (IOException e) {
                System.out.println("Error reading users file");
                e.printStackTrace();
            }
        }
        return users;
    }

    public static User updateUser(User user){
        for(User user1: getUsers()){
            if(user1.getId() == user.getId()) return user1;
        }
        return user;
    }

    public static void SaveUsers(ArrayList<User> users) {
        SimpleModule simpleModule = new SimpleModule();
        simpleModule.addAbstractTypeMapping(Card.class, LeaderCard.class);
        simpleModule.addAbstractTypeMapping(Card.class, RegularCard.class);
        simpleModule.addAbstractTypeMapping(Card.class, SpecialCard.class);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(simpleModule);
        File file = new File("Users.json");
        try {
            objectMapper.writeValue(file, users);
        } catch (IOException e) {
            System.out.println("Error saving user");
            e.printStackTrace();
        }
    }

    public static void SaveInfo(User user) {
        ArrayList<User> users = getUsers();
        for (User user1 : users) {
            if (user1.getId() == user.getId()) {
                users.remove(user1);
                users.add(user);
                SaveUsers(users);
                break;
            }
        }
    }

    public static User isAnyRemembered() {
        for (User user : getUsers()) {
            if (user.isRemembered()) return user;
        }
        return null;
    }

    public static void DeleteAccount(User user) {
        ArrayList<User> users = getUsers();
        for (User user1 : users) {
            if (user1.getId() == user.getId()) {
                users.remove(user1);
                break;
            }
        }
        SaveUsers(users);
    }

    public static Parent getRoot() {
        return root;
    }

    public static void setRoot(Parent root) {
        App.root = root;
    }

    public static Group getIngredient() {
        return ingredient;
    }
}
