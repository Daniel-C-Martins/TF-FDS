package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.infra.repositories.entities.Signature;
import tf.fds.app.domain.entities.SignatureModel;

public class SignatureAdapter {
    
    /*
     * Conversor de SignatureModel para Signature
     * @param sModel
     * @return Signature
     * Cria um objeto Signature a partir de um objeto SignatureModel
     * Mapea os objetos de SignatureModel para Signature
     */
    public static Signature fromSignatureModel (SignatureModel sModel){
        Signature sign = new Signature();
        sign.setCode(sModel.getCode());
        sign.setBeginningDate(sModel.getBeginningDate());
        sign.setEndDate(sModel.getEndDate());
        sign.setClient(ClientAdapter.fromClientModel(sModel.getClient()));
        sign.setApplicative(ApplicativeAdapter.fromApplicativeModel(sModel.getApplicative()));
        sign.setType(sModel.getType());
        return sign;
    }

    /*
     * Conversor de Signature para SignatureModel
     * @param sign
     * @return SignatureModel
     * Cria um objeto SignatureModel a partir de um objeto Signature
     * Mapea os objetos de Signature para SignatureModel
     */
    public static SignatureModel toSignatureModel (Signature sign){
        SignatureModel sModel = new SignatureModel();
        sModel.setCode(sign.getCode());
        sModel.setBeginningDate(sign.getBeginningDate());
        sModel.setEndDate(sign.getEndDate());
        sModel.setClient(ClientAdapter.toClientModel(sign.getClient()));
        sModel.setApplicative(ApplicativeAdapter.toApplicativeModel(sign.getApplicative()));
        sModel.setType(sign.getType());
        return sModel;
    }
}
