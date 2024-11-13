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

    public SignatureModel(long code, Date beginningDate, Date endDate) {
        this.code = code;
        this.beginningDate = beginningDate;
        this.endDate = endDate;
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

    public String toString() {
        return "code: " + code + ", Inicio Vigencia: " + beginningDate + ", Fim Vigencia: " + endDate;
    }
}
