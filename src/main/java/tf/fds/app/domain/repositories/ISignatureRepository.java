package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.infra.repositories.entities.Signature;

public interface ISignatureRepository {
    SignatureModel createSignature(SignatureModel signature);
    boolean isActive(long codass);
    List<SignatureModel> getAllSignatures();
    List<SignatureModel> getAllSignaturesByClient(long codcli);
    List<SignatureModel> getAllSignaturesByApp(long codapp);
}
