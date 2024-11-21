package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entities.ApplicativeModel;
import tf.fds.app.domain.entities.ClientModel;
import tf.fds.app.domain.entities.SignatureModel.SignatureTypes;


public interface IApplicativeRepository {
    List<ClientModel> getAllClients();
    ApplicativeModel updateMonthlyCost(float newCost, Long id );
    List<SignatureTypes> getAllSignatures(long codapp);
}
