package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entity.SignatureModel.SignatureTypes;
import tf.fds.app.infra.repositories.entities.Signature;

public interface SignatureRepository {
    boolean createSignature(Signature signature);
    boolean isActive(long codass);
    List<Signature> getAllSignatures();
    List<Signature> getAllSignaturesByType(SignatureTypes signatureType);
    List<Signature> getAllSignaturesByClient(long codcli);
    List<Signature> getAllSignaturesByApp(long codapp);
}
