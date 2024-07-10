package messages;

public class ServerMessage {
    private final boolean success;
    private final String additionalInfo;

    public ServerMessage(boolean success, String additionalInfo) {
        this.success = success;
        this.additionalInfo = additionalInfo;
    }

    public boolean wasSuccessful() {
        return this.success;
    }

    public String getAdditionalInfo() {
        return this.additionalInfo;
    }
}
