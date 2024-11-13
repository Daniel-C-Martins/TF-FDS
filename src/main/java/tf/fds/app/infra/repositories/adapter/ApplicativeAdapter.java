package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entity.ApplicativeModel;
import tf.fds.app.infra.repositories.entities.Applicative;

public class ApplicativeAdapter {
    
    public static Applicative fromAplicativeModel (ApplicativeModel aModel){
        return new Applicative(aModel.getName(), aModel.getMonthlyCost());
    }

    public static ApplicativeModel fromAplicativeModel (Applicative app){
        return new ApplicativeModel(app.getCode(), app.getName(), app.getMonthlyCost());
    }
}
