package messages;

public class LogoutMessage extends ClientMessage{
    public LogoutMessage () {
        this.type = ClientMessageType.LOGOUT;
    }
}
