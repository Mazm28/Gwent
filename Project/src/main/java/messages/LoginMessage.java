package messages;

public class LoginMessage extends ClientMessage{
    private final String username;
    private final String password;
    private final boolean stayLoggedIn;

    public LoginMessage(String username, String password, boolean stayLoggedIn) {
        this.type = ClientMessageType.LOGIN;
        this.username = username;
        this.password = password;
        this.stayLoggedIn = stayLoggedIn;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public boolean getStayLoggedIn() {
        return stayLoggedIn;
    }
}
