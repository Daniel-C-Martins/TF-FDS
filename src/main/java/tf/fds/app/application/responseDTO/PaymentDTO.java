package tf.fds.app.application.responseDTO;

import java.time.LocalDate;

import tf.fds.app.domain.entities.PaymentModel;
import tf.fds.app.infra.Enums.PaymentStatus.PaymentStatuses;

public class PaymentDTO {
    private long code;
    private double payedValue;
    private LocalDate paymentDate;
    private String sale;
    private SignatureDTO signature;
    private PaymentStatuses status;

    public PaymentDTO(PaymentModel paymentModel) {
        this.code = paymentModel.getCode();
        this.payedValue = paymentModel.getPayedValue();
        this.paymentDate = paymentModel.getPaymentDate();
        this.sale = paymentModel.getSale();
        this.signature = new SignatureDTO(paymentModel.getSignature());
        this.status = paymentModel.getStatus();
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

    public PaymentStatuses getStatus() {
        return status;
    }

    @Override
    public String toString() {
        return "PaymentDTO: code = " + code + ", payedValue = " + payedValue + ", paymentDate = " + paymentDate
                + ", sale = "
                + sale + ", signature = " + signature + ", status = " + status;
    }
}
