package tf.fds.app.domain.entities;

import java.time.LocalDate;

public class SignatureModel {
    public enum SignatureTypes {
        ALL,
        ACTIVE,
        CANCELED
    }

    private long code;
    private LocalDate beginningDate;
    private LocalDate endDate;
    private ClientModel client;
    private ApplicativeModel applicative;

    public SignatureModel() {
    }

    public long getCode() {
        return code;
    }

    public LocalDate getBeginningDate() {
        return beginningDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ClientModel getClient() {
        return client;
    }

    public ApplicativeModel getApplicative() {
        return applicative;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setBeginningDate(LocalDate beginningDate) {
        this.beginningDate = beginningDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setClient(ClientModel client) {
        this.client = client;
    }

    public void setApplicative(ApplicativeModel applicative) {
        this.applicative = applicative;
    }
}
