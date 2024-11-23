package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entities.ApplicativeModel;
import tf.fds.app.domain.entities.SignatureModel.SignatureTypes;

public interface IApplicativeRepository {
    ApplicativeModel updateMonthlyCost(double newCost, Long id );
    List<SignatureTypes> getAllSignatures(long codapp);
    List<ApplicativeModel> getAllApplicatives();
}
