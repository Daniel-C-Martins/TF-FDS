package tf.fds.app.domain.entities;

import java.time.LocalDate;

import tf.fds.app.infra.Enums.PaymentStatus.PaymentStatuses;

public class PaymentModel {

    private long code;
    private double payedValue;
    private LocalDate paymentDate;
    private String sale;
    private SignatureModel signature;
    private PaymentStatuses status;

    public PaymentModel() {
    }

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

    public SignatureModel getSignature() {
        return signature;
    }

    public PaymentStatuses getStatus() {
        return status;
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

    public void setSignature(SignatureModel signature) {
        this.signature = signature;
    }

    public void setStatus(PaymentStatuses status) {
        this.status = status;
    }
}
