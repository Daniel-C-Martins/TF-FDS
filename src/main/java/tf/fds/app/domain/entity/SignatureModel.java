package tf.fds.app.domain.entity;

import java.util.Date;

public class SignatureModel {
    public enum SignatureTypes {
        ALL,
        ACTIVE,
        CANCELED
    }

    private long code;
    private Date beginningDate;
    private Date endDate;
    private SignatureTypes signatureType;

    public SignatureModel(long code, Date beginningDate, Date endDate, SignatureTypes signatureTypes) {
        this.code = code;
        this.beginningDate = beginningDate;
        this.endDate = endDate;
        this.signatureType = signatureTypes;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public Date getBeginningDate() {
        return beginningDate;
    }

    public void setBeginningDate(Date beginningDate) {
        this.beginningDate = beginningDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public SignatureTypes getSignatureTypes(){
        return signatureType;
    }

    public String toString() {
        return "code: " + code + ", Inicio Vigencia: " + beginningDate + ", Fim Vigencia: " + endDate;
    }
}
