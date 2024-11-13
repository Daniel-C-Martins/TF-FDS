package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entity.SignatureModel.SignatureTypes;
import tf.fds.app.infra.repositories.entities.Client;
import tf.fds.app.infra.repositories.entities.Signature;

public interface ClientRepository {
    List<Client> getAllClients();
    List<Signature> getAllSignatures();
    List<Signature> getAllSignaturesByType(SignatureTypes signatureType);
    List<Signature> getAllSignaturesByClient(long codcli);
}
