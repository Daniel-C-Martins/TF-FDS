package tf.fds.app.application.dtos;

import java.util.Date;

import tf.fds.app.domain.entity.SignatureModel;

public class SignatureDTO {
    private long code;
    private Date beginningDate;
    private Date endDate;

    public SignatureDTO(SignatureModel signatureModel) {
        this.code = signatureModel.getCode();
        this.beginningDate = signatureModel.getBeginningDate();
        this.endDate = signatureModel.getEndDate();
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

    public SignatureDTO fromModel(SignatureModel signatureModel) {
        return new SignatureDTO(signatureModel);
    }

    public String toString() {
        return "code: " + code + ", Inicio Vigencia: " + beginningDate + ", Fim Vigencia: " + endDate;
    }
}
