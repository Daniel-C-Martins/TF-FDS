package tf.fds.app.application.responseDTO;

import java.time.LocalDate;

import tf.fds.app.domain.entities.PaymentModel;

public class PaymentDTO {
    private long code;
    private double payedValue;
    private LocalDate paymentDate;
    private String sale;
    private SignatureDTO signature;
    private PaymentModel.PaymentStatus status;
    private double returnedValue;

    public PaymentDTO(PaymentModel paymentModel) {
        this.code = paymentModel.getCode();
        this.payedValue = paymentModel.getPayedValue();
        this.paymentDate = paymentModel.getPaymentDate();
        this.sale = paymentModel.getSale();
        this.signature = new SignatureDTO(paymentModel.getSignature());
        this.status = paymentModel.getStatus();
        this.returnedValue = 0.0;
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

    public PaymentModel.PaymentStatus getStatus() {
        return status;
    }

    public SignatureDTO getSignature() {
        return signature;
    }

    public double getReturnedValue() {
        return returnedValue;
    }

    public void setReturnedValue(double returnedValue) {
        this.returnedValue = returnedValue;
    }

    @Override
    public String toString() {
        return "PaymentDTO: code = " + code + ", payedValue = " + payedValue + ", paymentDate = " + paymentDate + ", sale = "
                + sale + ", signature = " + signature;
    }
}
