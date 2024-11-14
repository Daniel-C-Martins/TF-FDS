package tf.fds.app.infra.repositories.adapter;

import java.util.LinkedList;
import java.util.List;

import tf.fds.app.domain.entity.ApplicativeModel;
import tf.fds.app.domain.entity.SignatureModel;
import tf.fds.app.infra.repositories.entities.Applicative;
import tf.fds.app.infra.repositories.entities.Signature;

public class ApplicativeAdapter {
    
    /*
     * Conversor de ApplicativeModel para Applicative
     * @param aModel
     * @return Applicative
     * Cria um objeto Applicative a partir de um objeto ApplicativeModel
     * Mapea os objetos de ApplicativeModel para Applicative
     * Usa setCode para definir o código do objeto Applicative
     * Cria uma lista de signatures a partir da lista de SignatureModel de ApplicativeModel
     * Usa setSignatures para definir a lista de assinaturas do objeto Applicative
     */
    public static Applicative fromApplicativeModel (ApplicativeModel aModel){
        Applicative app = new Applicative(aModel.getName(), aModel.getMonthlyCost());
        app.setCode(aModel.getCode());
        List<Signature> sign = new LinkedList<Signature>();
        aModel.getSignatures().stream().forEach(s-> sign.add(SignatureAdapter.fromSignatureModel(s)));
        app.setSignatures(sign);
        return app;
    }


    /*
     * Conversor de Applicative para ApplicativeModel
     * @param app
     * @return ApplicativeModel
     * Cria um objeto ApplicativeModel a partir de um objeto Applicative
     * Mapea os objetos de Applicative para ApplicativeModel
     * Usa setCode para definir o código do objeto ApplicativeModel
     * Cria uma lista de signatures a partir da lista de Signature de Applicative
     * Usa setSignatures para definir a lista de assinaturas do objeto ApplicativeModel
     */
    public static ApplicativeModel toApplicativeModel (Applicative app){
        ApplicativeModel aModel = new ApplicativeModel(app.getCode(), app.getName(), app.getMonthlyCost());
        List<SignatureModel> sign = new LinkedList<SignatureModel>();
        app.getSignatures().stream().forEach(s -> sign.add(SignatureAdapter.toSignatureModel(s)));
        aModel.setSignatures(sign);
        return aModel;
    }
}
