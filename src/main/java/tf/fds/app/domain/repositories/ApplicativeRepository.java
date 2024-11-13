package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entity.ApplicativeModel;
import tf.fds.app.domain.entity.ClientModel;
import tf.fds.app.domain.entity.SignatureModel.SignatureTypes;


public interface ApplicativeRepository {
    List<ClientModel> getAllClients();
    ApplicativeModel updateMonthlyCost(float newCost, Long id );
    List<SignatureTypes> getAllSignatures(long codapp);
}
