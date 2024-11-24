package tf.fds.app.application.responseDTO;

import java.time.LocalDate;
import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.infra.Enums.SignatureType.SignatureTypes;

/*
 * DTO utilizado para enviar os dados de uma assinatura
 * @param code
 * @param beginningDate
 * @param endDate
 * @param client
 * @param applicative
 * @param type
 */
public class SignatureDTO {
    private long code;
    private LocalDate beginningDate;
    private LocalDate endDate;
    private ClientDTO client;
    private ApplicativeDTO applicative;
    private SignatureTypes type;

    public SignatureDTO(SignatureModel signatureModel) {
        this.code = signatureModel.getCode();
        this.beginningDate = signatureModel.getBeginningDate();
        this.endDate = signatureModel.getEndDate();
        this.client = new ClientDTO(signatureModel.getClient());
        this.applicative = new ApplicativeDTO(signatureModel.getApplicative());
        this.type = signatureModel.getType();
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

    public ClientDTO getClient() {
        return client;
    }

    public ApplicativeDTO getApplicative() {
        return applicative;
    }

    @Override
    public String toString() {
        return "SignatureDTO: code = " + code + ", beginningDate = " + beginningDate + ", endDate = " + endDate + ", client = "
                + client + ", applicative = " + applicative + ", type = " + type;
    }
}
