package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.infra.repositories.entities.Applicative;
import tf.fds.app.infra.repositories.entities.Client;
import tf.fds.app.infra.repositories.entities.Signature;

public interface ApplicativeRepository {
    List<Client> getAllClients();
    Applicative updateMonthlyCost(float newCost, Long id );
    List<Signature> getAllSignatures(long codapp);
}
