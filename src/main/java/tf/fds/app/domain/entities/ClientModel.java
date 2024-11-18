package tf.fds.app.domain.entities;

import java.util.LinkedList;
import java.util.List;

public class ClientModel {
    private long code;
    private String name;
    private String email;
    private List<SignatureModel> signatures;

    public ClientModel(long code, String name, String email) {
        this.code = code;
        this.name = name;
        this.email = email;
        this.signatures = new LinkedList<SignatureModel>();
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

    public List<SignatureModel> getSignatures() {
        return signatures;
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

    public void setSignatures(List<SignatureModel> signatures) {
        this.signatures = signatures;
    }
}
