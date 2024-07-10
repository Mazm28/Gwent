package messages;

public class SaveUserMessage extends ClientMessage {
    private final String gsonUser;
    public SaveUserMessage(String gsonUser) {
        this.type = ClientMessageType.SAVE_USER;
        this.gsonUser = gsonUser;
    }

    public String getGsonUser() {
        return gsonUser;
    }
}
