package tf.fds.app.adapterInterface.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Client {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private String email;

    @OneToMany(mappedBy = "client")
    private List<Signature> signatures;

    public Client() {}

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<Signature> getSignatures() {
        return signatures;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSignatures(List<Signature> signatures) {
        this.signatures = signatures;
    }

    // Getters and Setters
}
