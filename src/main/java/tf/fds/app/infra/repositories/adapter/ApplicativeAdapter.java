package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entities.ApplicativeModel;
import tf.fds.app.infra.repositories.entities.Applicative;

public class ApplicativeAdapter {

    /*
     * Converte ApplicativeModel para Applicative
     * @param aModel
     * @return Applicative
     * Cria um objeto Applicative a partir de um objeto ApplicativeModel
     * Mapeia os objetos de ApplicativeModel para Applicative
     */
    public static Applicative fromApplicativeModel (ApplicativeModel aModel){
        Applicative app = new Applicative();
        app.setCode(aModel.getCode());
        app.setName(aModel.getName());
        app.setMonthlyCost(aModel.getMonthlyCost());
        return app;
    }


    /*
     * Conversor de Applicative para ApplicativeModel
     * @param app
     * @return ApplicativeModel
     * Cria um objeto ApplicativeModel a partir de um objeto Applicative
     * Mapea os objetos de Applicative para ApplicativeModel
     */
    public static ApplicativeModel toApplicativeModel (Applicative app){
        ApplicativeModel aModel = new ApplicativeModel();
        aModel.setCode(app.getCode());
        aModel.setName(app.getName());
        aModel.setMonthlyCost(app.getMonthlyCost());
        return aModel;
    }
}
