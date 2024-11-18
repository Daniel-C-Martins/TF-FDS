package tf.fds.app.application.dtos;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import tf.fds.app.domain.entities.SignatureModel;

public class SignatureDTO {
    private long code;
    private Date beginningDate;
    private Date endDate;
    private ClientDTO client;
    private ApplicativeDTO applicative;
    private List<PaymentDTO> payments;

    public SignatureDTO(SignatureModel signatureModel) {
        this.code = signatureModel.getCode();
        this.beginningDate = signatureModel.getBeginningDate();
        this.endDate = signatureModel.getEndDate();
        this.client = new ClientDTO(signatureModel.getClient());
        this.applicative = new ApplicativeDTO(signatureModel.getApplicative());
        this.payments = new LinkedList<PaymentDTO>();

        signatureModel.getPayments().forEach(paymentModel -> {
            this.payments.add(new PaymentDTO(paymentModel));
        });
    }

    public long getCode() {
        return code;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public ClientDTO getClient() {
        return client;
    }

    public ApplicativeDTO getApplicative() {
        return applicative;
    }

    public List<PaymentDTO> getPayments() {
        return payments;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setClient(ClientDTO client) {
        this.client = client;
    }

    public void setApplicative(ApplicativeDTO applicative) {
        this.applicative = applicative;
    }

    public void setPayments(List<PaymentDTO> payments) {
        this.payments = payments;
    }

    @Override
    public String toString() {
        return "SignatureDTO: code = " + code + ", beginningDate = " + beginningDate + ", endDate = " + endDate + ", client = "
                + client + ", applicative = " + applicative + ", payments = " + payments;
    }
}
