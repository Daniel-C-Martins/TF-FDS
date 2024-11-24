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
import tf.fds.app.domain.Enums.PaymentStatus.PaymentStatuses;

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

    @Column(name = "returned_value", nullable = false)
    private double returnedValue;

    @Column(name = "status", nullable = false)
    private PaymentStatuses status;

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

    public PaymentStatuses getStatus() {
        return status;
    }

    public double getReturnedValue() {
        return returnedValue;
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

    public void setStatus(PaymentStatuses status) {
        this.status = status;
    }

    public void setReturnedValue(double returnedValue) {
        this.returnedValue = returnedValue;
    }
}
