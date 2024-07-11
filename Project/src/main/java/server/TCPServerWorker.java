package server;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import messages.*;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Random;

public class TCPServerWorker extends Thread {
    private static ServerSocket server;
    private DataInputStream recieveBuffer;
    private DataOutputStream sendBuffer;

    private static Gson gsonAgent;

    private static ArrayList<Socket> connections;

    public static int WORKERS;

    private static boolean setupServer(int portNumber, int workerNum) {
        try {
            server = new ServerSocket(portNumber);
            connections = new ArrayList<>();
            WORKERS = workerNum;
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public TCPServerWorker() {
        GsonBuilder builder = new GsonBuilder();
        gsonAgent = builder.create();
    }

    public void listen() throws IOException {
        Socket socket;
        while (true) {
            socket = server.accept();
            synchronized (connections) {
                connections.add(socket);
                connections.notify();
            }
        }
    }

    @Override
    public void run() {
        Socket socket;
        while (true) {
            socket = null;
            synchronized (connections) {
                while (connections.isEmpty()) {
                    try {
                        connections.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                socket = connections.get(0);
                connections.remove(0);
            }
            if (socket != null) {
                handleConnection(socket);
            }
        }
    }

    private void handleConnection(Socket socket) {
    }

    private String generateNewToken() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 256; i++)
            sb.append((char) (random.nextInt(128)));
        return sb.toString();
    }

    private ClientMessage extractClientMessage(String clientStr) {
        try {
            ClientMessage clientMessage = gsonAgent.fromJson(clientStr, ClientMessage.class);
            return switch (clientMessage.getType()) {
                case LOGIN -> gsonAgent.fromJson(clientStr, LoginMessage.class);
                case LOGOUT -> gsonAgent.fromJson(clientStr, LogoutMessage.class);
                case SAVE_USER -> gsonAgent.fromJson(clientStr, SaveUserMessage.class);
                case GET_ALL_USERS -> gsonAgent.fromJson(clientStr, GetAllUsersMessage.class);
                default -> null;
            };
        } catch (Exception e) {
            return null;
        }
    }

    private synchronized void sendMessage(boolean success, String problem) {
        ServerMessage failureMessage = new ServerMessage(success, problem);
        String failureString = gsonAgent.toJson(failureMessage);
        try {
            sendBuffer.writeUTF(failureString);
        } catch (Exception e) {
            System.out.println("error: " + e.getMessage());
        }
    }

    private synchronized void sendFailure(String problem) {
        sendMessage(false, problem);
    }

    private synchronized void sendSuccess(String info) {
        sendMessage(true, info);
    }

    public static void main(String[] args) {
        try {
            TCPServerWorker.setupServer(5001, 10);
            for (int i = 0; i < WORKERS; i++) {
                new TCPServerWorker().start();
            }
            new TCPServerWorker().listen();
        } catch (Exception e) {
            System.out.println("Server encountered a problem!");
            e.printStackTrace();
        }
    }
}
