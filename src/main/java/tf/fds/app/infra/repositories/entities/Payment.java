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
    private LocalDate paymentDate;

    @Column(name = "sale", nullable = true)
    private String sale;

    @ManyToOne
    @JoinColumn(name = "signature_id")
    private Signature signature;

    public Payment() {}

    public long getCode() {
        return code;
    }

    public double getPayedValue() {
        return payedValue;
    }

    public LocalDate getPaymentDate() {
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

    public void setPaymentDate(LocalDate paymentDate) {
        this.paymentDate = paymentDate;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public void setSignature(Signature signature) {
        this.signature = signature;
    }
}
