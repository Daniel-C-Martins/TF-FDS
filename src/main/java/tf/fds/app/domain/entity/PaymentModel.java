package tf.fds.app.domain.entity;

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

    public PaymentModel(long code, double payedValue, Date paymentDate, String sale) {
        this.code = code;
        this.payedValue = payedValue;
        this.paymentDate = paymentDate;
        this.sale = sale;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public double getPayedValue() {
        return payedValue;
    }

    public void setPayedValue(double payedValue) {
        this.payedValue = payedValue;
    }

    public Date getPaymentDate() {
        return paymentDate;
    }

    public void setPpaymentDate(Date paymentDate) {
        this.paymentDate = paymentDate;
    }

    public String getSale() {
        return sale;
    }

    public void setSale(String sale) {
        this.sale = sale;
    }

    public String toString(){
        return "code: " + code + ", Valor Pago: " + payedValue + ", Data Pagamento: " + paymentDate + ", sale: " + sale;
    }
}
