package tf.fds.app.domain.repositories;

import java.util.List;
import tf.fds.app.domain.entities.ApplicativeModel;

/**
 * Interface que representa o repositório de aplicativos.
 */
public interface IApplicativeRepository {
    ApplicativeModel updateMonthlyCost(double newCost, Long id);

    List<ApplicativeModel> getAllApplicatives();

    ApplicativeModel getApplicativeById(long applicativeId);
}
