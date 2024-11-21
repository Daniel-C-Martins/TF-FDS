package tf.fds.app.infra.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.LinkedList;
import java.util.List;

@Entity
@Table(name = "client")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "client_code", nullable = false)
    private Long code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "client")
    @Column(name = "signatures", nullable = true)
    private List<Signature> signatures;

    protected Client() {}

    public Client(String name, String email) {
        this.name = name;
        this.email = email;
        this.signatures = new LinkedList<>();
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
}
