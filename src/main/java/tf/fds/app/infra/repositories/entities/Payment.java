package tf.fds.app.infra.repositories.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_code", nullable = false)
    private long code;

    @Column(name = "payed_value", nullable = false)
    private double payedValue;

    @Column(name = "payment_date", nullable = false)
    private Date paymentDate;

    @Column(name = "sale", nullable = true)
    private String sale;

    @ManyToOne
    @JoinColumn(name = "signature_id")
    private Signature signature;

    public Payment() {}

    public Payment(double payedValue, Date paymentDate, String sale, Signature signature) {
        this.payedValue = payedValue;
        this.paymentDate = paymentDate;
        this.sale = sale;
        this.signature = signature;
    }

    public long getCode() {
        return code;
    }

    public double getPayedValue() {
        return payedValue;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public String getSale() {
        return sale;
    }

    public Signature getSignature() {
        return signature;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setPayedValue(double payedValue) {
        this.payedValue = payedValue;
    }

    public void setPaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }
}
