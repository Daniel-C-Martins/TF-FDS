package tf.fds.app.domain.entity;

public class ClientModel {
    private long code;
    private String name;
    private String email;

    public ClientModel(long code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "code: " + code + ", name: " + name + ", Email: " + email;
    }
}
