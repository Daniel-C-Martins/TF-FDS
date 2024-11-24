package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entities.SignatureModel;

public interface ISignatureRepository {
    SignatureModel createSignature(SignatureModel signature);
    boolean isActive(long codass);
    List<SignatureModel> getAllSignatures();
    List<SignatureModel> getSignaturesByClient(long codcli);
    List<SignatureModel> getSignaturesByApp(long codapp);
   SignatureModel getSignatureById(long codass);
}
