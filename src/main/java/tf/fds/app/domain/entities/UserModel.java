package tf.fds.app.domain.entities;

public class UserModel {
    private long code;
    private String username;
    private String password;

    public UserModel(long code, String username, String password) {
        this.code = code;
        this.username = username;
        this.password = password;
    }

    public long getCode() {
        return code;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
