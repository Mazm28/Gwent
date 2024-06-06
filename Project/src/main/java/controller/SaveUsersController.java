package controller;

import model.User;

import java.io.*;
import java.util.ArrayList;

public class SaveUsersController {
    public static ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();
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

}
