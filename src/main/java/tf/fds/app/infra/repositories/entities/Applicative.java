package tf.fds.app.infra.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class Applicative {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private String name;
    private double monthlyCost;

    @OneToMany(mappedBy = "applicative")
    private List<Signature> signatures;

    public Applicative() {}

    public Applicative(String name, double monthlyCost) {
        this.name = name;
        this.monthlyCost = monthlyCost;
    }

    public Long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public double getMonthlyCost() {
        return monthlyCost;
    }

    public List<Signature> getSubscriptions() {
        return signatures;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMonthlyCost(double monthlyCost) {
        this.monthlyCost = monthlyCost;
    }

    public void setSubscriptions(List<Signature> subscriptions) {
        this.signatures = subscriptions;
    }

}
