package tf.fds.app.adapterInterface.repositories.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.Date;
import java.util.List;

@Entity
public class Signature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long code;
    private Date beginningDate;;
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "applicative_id")
    private Applicative application;

    @OneToMany(mappedBy = "signature")
    private List<Payment> payments;

    public Signature() {}

    public Signature(Date beginningDate, Date endDate, Client client, Applicative application) {
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.client = client;
        this.application = application;
    }

    public Long getCode() {
        return code;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public Client getClient() {
        return client;
    }

    public Applicative getApplication() {
        return application;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setApplication(Applicative application) {
        this.application = application;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }
}

