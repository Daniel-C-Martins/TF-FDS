package tf.fds.app.application.dtos;

import java.util.Date;

import tf.fds.app.domain.entity.PaymentModel;

public class PaymentDTO {
    private long code;
    private double payedValue;
    private Date paymentDate;
    private String sale;

    public PaymentDTO(PaymentModel paymentModel) {
        this.code = paymentModel.getCode();
        this.payedValue = paymentModel.getPayedValue();
        this.paymentDate = paymentModel.getPaymentDate();
        this.sale = paymentModel.getSale();
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

    public PaymentDTO fromModel(PaymentModel paymentModel) {
        return new PaymentDTO(paymentModel);
    }

    public String toString(){
        return "code: " + code + ", Valor Pago: " + payedValue + ", Data Pagamento: " + paymentDate + ", sale: " + sale;
    }
}
