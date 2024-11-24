package tf.fds.app.infra.repositories.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import tf.fds.app.infra.Enums.SignatureType.SignatureTypes;

@Entity
@Table(name = "signature")
public class Signature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "signature_code", nullable = false)
    private Long code;

    @Column(name = "beginning_Date", nullable = false)
    private LocalDate beginningDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "type", nullable = true)
    private SignatureTypes type;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "applicative_id")
    private Applicative applicative;

    public Signature() {}

    public Long getCode() {
        return code;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Client getClient() {
        return client;
    }

    public Applicative getApplicative() {
        return applicative;
    }

    public SignatureTypes getType() {
        return type;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setApplicative(Applicative applicative) {
        this.applicative = applicative;
    }

    public void setType(SignatureTypes type) {
        this.type = type;
    }
}
