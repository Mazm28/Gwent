package messages;

public class RegisterMessage extends ClientMessage {
    private final String gsonUser;
    public RegisterMessage(String gsonUser) {
        this.type = ClientMessageType.SEND_OBJECT;
        this.gsonUser = gsonUser;
    }

    public String getGsonUser() {
        return gsonUser;
    }
}
