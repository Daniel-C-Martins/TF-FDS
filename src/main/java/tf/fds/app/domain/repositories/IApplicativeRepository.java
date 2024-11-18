package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entities.ApplicativeModel;
import tf.fds.app.domain.entities.SignatureModel;


public interface IApplicativeRepository {
    ApplicativeModel updateMonthlyCost(float newCost, Long id );
}
