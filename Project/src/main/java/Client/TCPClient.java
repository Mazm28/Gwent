package Client;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import messages.*;
import model.App;
import server.User;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

public class TCPClient {
    private Socket socket;
    private DataInputStream receiveBuffer;
    private DataOutputStream sendBuffer;
    private final String serverIP;
    private final int serverPort;

    private final Gson gsonAgent;

    private String token;

    private ServerMessage lastServerMessage;

    public TCPClient(String serverIP, int serverPort) {
        GsonBuilder builder = new GsonBuilder();
        this.gsonAgent = builder.create();
        this.serverIP = serverIP;
        this.serverPort = serverPort;
    }

    private void establishConnection() {
        try {
            socket = new Socket(serverIP, serverPort);
            sendBuffer = new DataOutputStream(
                    socket.getOutputStream()
            );
            receiveBuffer = new DataInputStream(
                    socket.getInputStream()
            );
        } catch (Exception e) {
            System.err.println("error in initializing the socket: " + e.getMessage());
        }
    }

    private void endConnection() {
        if(socket == null) return;
        try {
            socket.close();
            receiveBuffer.close();
            sendBuffer.close();
        } catch (IOException e) {
            System.out.println("error in ending connection: " + e.getMessage());
        }
    }

    private void sendMessage(String message) {
        try {
            sendBuffer.writeUTF(message);
        } catch (Exception e) {
            System.out.println("error in sending message from client to server: " + e.getMessage());
        }
    }

    private String receiveResponse() {
        try {
            return receiveBuffer.readUTF();
        } catch (IOException e) {
            return null;
        }
    }

    public ServerMessage getLastServerMessage() {
        return lastServerMessage;
    }

    public Result login(String username, String password, boolean stayLoggedIn) {
        LoginMessage loginMessage = new LoginMessage(username, password, stayLoggedIn);
        try {
            establishConnection();
            sendMessage(gsonAgent.toJson(loginMessage));
            lastServerMessage = gsonAgent.fromJson(receiveResponse(), ServerMessage.class);
            endConnection();
            boolean success = lastServerMessage.wasSuccessful();
            if (success) {
                User.setLoggedInUser(gsonAgent.fromJson(lastServerMessage.getAdditionalInfo(), User.class));
                this.token = User.getLoggedInUser().getToken();
                return new Result(true, "");
            }
            return new Result(false, lastServerMessage.getAdditionalInfo());
        }
        catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    public Result registerCheck(
            String username,
            String password,
            String passwordConfirm,
            String email,
            String nickname
    ) {
        RegisterCheckMessage registerCheckMessage = new RegisterCheckMessage(
                username,
                password,
                passwordConfirm,
                email,
                nickname
        );
        try {
            establishConnection();
            sendMessage(gsonAgent.toJson(registerCheckMessage));
            lastServerMessage = gsonAgent.fromJson(receiveResponse(), ServerMessage.class);
            endConnection();
            boolean success = lastServerMessage.wasSuccessful();
            return new Result(success, lastServerMessage.getAdditionalInfo());
        }
        catch (Exception e) {
            return new Result(false, e.getMessage());
        }
    }

    public void register() {
        RegisterMessage registerMessage = new RegisterMessage(
                gsonAgent.toJson(User.getLoggedInUser())
        );
        try {
            establishConnection();
            sendMessage(gsonAgent.toJson(registerMessage));
            lastServerMessage = gsonAgent.fromJson(receiveResponse(), ServerMessage.class);
            endConnection();
            boolean success = lastServerMessage.wasSuccessful();
            if (success) {
                User.setLoggedInUser(
                        gsonAgent.fromJson(lastServerMessage.getAdditionalInfo(),
                                User.class));
                token = User.getLoggedInUser().getToken();
            }
        }
        catch (Exception e) {
            System.out.println("error in registration: " + e.getMessage());
        }
    }

    public void saveUser(User user) {
        SaveUserMessage saveUserMessage = new SaveUserMessage(gsonAgent.toJson(user));
        try {
            establishConnection();
            sendMessage(gsonAgent.toJson(saveUserMessage));
            lastServerMessage = gsonAgent.fromJson(receiveResponse(), ServerMessage.class);
            endConnection();
        } catch (Exception e) {
            System.out.println("error in registration: " + e.getMessage());
        }
    }

    public void logout() {
        LogoutMessage logoutMessage = new LogoutMessage();
        logoutMessage.setToken(token);

        establishConnection();
        sendMessage(gsonAgent.toJson(logoutMessage));
        endConnection();
    }


//    this method should be checked
    public void getAllUsers() {
        GetAllUsersMessage message = new GetAllUsersMessage();
        establishConnection();
        sendMessage(gsonAgent.toJson(message));
        lastServerMessage = gsonAgent.fromJson(receiveResponse(), ServerMessage.class);
        endConnection();
        String userData = lastServerMessage.getAdditionalInfo();
        if (!userData.isEmpty()) {
            try (FileWriter file = new FileWriter("Users.json")) {
                file.write(userData);
                file.flush();
                System.out.println("JSON data written to Users.json");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
