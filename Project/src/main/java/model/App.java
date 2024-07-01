package model;


import javafx.scene.Parent;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import com.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class App {
    private static Parent root;
    private static Stage stage;
    private static Game game;
    private static final Random random = new Random();
    private static MediaPlayer mediaPlayer;
    private static final double HEIGHT = 700;
    private static final double WIDTH = 1000;

    public static void setMediaPlayer(MediaPlayer mediaPlayer) {
        App.mediaPlayer = mediaPlayer;
    }

    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

    public static double getHEIGHT() {
        return HEIGHT;
    }

    public static double getWIDTH() {
        return WIDTH;
    }

    public static void setStage(Stage stage) {
        App.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setGame(Game game) {
        App.game = game;
    }

    public static Game getGame() {
        return game;
    }

    public static Random getRandom() {
        return random;
    }

    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        File file = new File("Users.ser");
        if (file.exists()) {
            try (FileInputStream fileInputStream = new FileInputStream(file);
                 ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream)) {
                while (true) {
                    try {
                        User user = (User) objectInputStream.readObject();
                        users.add(user);
                    } catch (EOFException e) {
                        break;
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.out.println("Error reading users file");
                e.printStackTrace();
            }
        }
        return users;
    }

    public static void SaveUsers(ArrayList<User> users) {
        File file = new File("Users.ser");
        try (FileOutputStream fileOutputStream = new FileOutputStream(file);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream)) {
            for (User user : users) {
                objectOutputStream.writeObject(user);
                objectOutputStream.reset(); // Clear the stream context
            }
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

    public static User isAnyRemembered () {
        for(User user: getUsers()){
            if(user.isRemembered()) return user;
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
}
