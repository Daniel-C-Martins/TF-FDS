package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entity.SignatureModel;
import tf.fds.app.infra.repositories.entities.Signature;

public class SignatureAdapter {
   
    public static Signature froSignatureModel (SignatureModel sModel){
        return new Signature(sModel.getBeginningDate(), sModel.getEndDate(), null, null);
    }
    //Nos últimos dois parametros de Signature, diz que precisa do GetClient() e getAppication()
    //porém não reconhece, então ele pede para completar com null

    public static SignatureModel froSignatureModel (Signature sign){
        return new SignatureModel(sign.getCode(), sign.getBeginningDate(), sign.getEndDate());
    }

}
