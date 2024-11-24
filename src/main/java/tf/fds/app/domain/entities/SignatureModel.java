package tf.fds.app.domain.entities;

import java.time.LocalDate;

import tf.fds.app.domain.Enums.SignatureType.SignatureTypes;
public class SignatureModel {

    private long code;
    private LocalDate beginningDate;
    private LocalDate endDate;
    private ClientModel client;
    private ApplicativeModel applicative;
    private SignatureTypes type;

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

    public SignatureTypes getType() {
        return type;
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

    public void setType(SignatureTypes type) {
        this.type = type;
    }

}
