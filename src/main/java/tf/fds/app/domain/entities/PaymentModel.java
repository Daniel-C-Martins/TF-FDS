package tf.fds.app.domain.entities;

import java.util.Date;

public class PaymentModel {
    public enum PaymentStatus {
        OK,
        INCORRECT_VALUE
    }

    private long code;
    private double payedValue;
    private Date paymentDate;
    private String sale;
    private SignatureModel signature;

    public PaymentModel(long code, double payedValue, Date paymentDate, String sale, SignatureModel signatureModel) {
        this.code = code;
        this.payedValue = payedValue;
        this.paymentDate = paymentDate;
        this.sale = sale;
        this.signature = signatureModel;
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

    public SignatureModel getSignature() {
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

    public void setSignature(SignatureModel signature) {
        this.signature = signature;
    }
}
