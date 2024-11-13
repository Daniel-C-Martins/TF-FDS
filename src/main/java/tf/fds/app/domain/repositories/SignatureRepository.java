package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entity.SignatureModel;
import tf.fds.app.domain.entity.SignatureModel.SignatureTypes;

public interface SignatureRepository {
    boolean createSignature(SignatureModel signature);
    boolean isActive(long codass);
    List<SignatureModel> getAllSignatures();
    List<SignatureModel> getAllSignaturesByType(SignatureTypes signatureType);
    List<SignatureModel> getAllSignaturesByClient(long codcli);
    List<SignatureModel> getAllSignaturesByApp(long codapp);
}
