package messages;

public class GetAllUsersMessage extends ClientMessage {
    public GetAllUsersMessage() {
        this.type = ClientMessageType.GET_ALL_USERS;
    }
}
