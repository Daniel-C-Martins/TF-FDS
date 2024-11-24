package tf.fds.app.domain.entities;

/**
 * Entidade que representa um cliente.
 */
public class ClientModel {
    private long code;
    private String name;
    private String email;

    public ClientModel() {
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
