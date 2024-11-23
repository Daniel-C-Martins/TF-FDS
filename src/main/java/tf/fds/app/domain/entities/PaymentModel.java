package tf.fds.app.domain.entities;

import java.time.LocalDate;

public class PaymentModel {
    public enum PaymentStatus {
        OK,
        INCORRECT_VALUE
    }

    private long code;
    private double payedValue;
    private LocalDate paymentDate;
    private String sale;
    private SignatureModel signature;

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
}
