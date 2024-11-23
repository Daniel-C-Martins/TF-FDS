package tf.fds.app.application.dtos;

import java.time.LocalDate;

import tf.fds.app.domain.entities.PaymentModel;

public class PaymentDTO {
    private long code;
    private double payedValue;
    private LocalDate paymentDate;
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

    public LocalDate getPaymentDate() {
        return paymentDate;
    }

    public String getSale() {
        return sale;
    }

    public SignatureDTO getSignature() {
        return signature;
    }

    @Override
    public String toString() {
        return "PaymentDTO: code = " + code + ", payedValue = " + payedValue + ", paymentDate = " + paymentDate + ", sale = "
                + sale + ", signature = " + signature;
    }
}
