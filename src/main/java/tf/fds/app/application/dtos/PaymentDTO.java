package tf.fds.app.application.dtos;

import java.util.Date;

import tf.fds.app.domain.entity.PaymentModel;

public class PaymentDTO {
    private long code;
    private double payedValue;
    private Date paymentDate;
    private String sale;
    private SignatureDTO signature;

    public PaymentDTO(PaymentModel paymentModel) {
        this.code = paymentModel.getCode();
        this.payedValue = paymentModel.getPayedValue();
        this.paymentDate = paymentModel.getPaymentDate();
        this.sale = paymentModel.getSale();
        this.signature = new SignatureDTO(paymentModel.getSignature());
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

    public SignatureDTO getSignature() {
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

    public void setSignature(SignatureDTO signature) {
        this.signature = signature;
    }

    @Override
    public String toString() {
        return "PaymentDTO: code = " + code + ", payedValue = " + payedValue + ", paymentDate = " + paymentDate + ", sale = "
                + sale + ", signature = " + signature;
    }
}
