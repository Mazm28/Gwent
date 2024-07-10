package messages;

public class RegisterCheckMessage extends ClientMessage {
    private final String username;
    private final String password;
    private final String passwordConfirm;
    private final String email;
    private final String nickname;

    public RegisterCheckMessage(
            String username,
            String password,
            String passwordConfirm,
            String email,
            String nickname
    ) {
        this.type = ClientMessageType.REGISTER_CHECK;
        this.username = username;
        this.password = password;
        this.passwordConfirm = passwordConfirm;
        this.email = email;
        this.nickname = nickname;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getPasswordConfirm() {
        return passwordConfirm;
    }

    public String getEmail() {
        return email;
    }

    public String getNickname() {
        return nickname;
    }
}
