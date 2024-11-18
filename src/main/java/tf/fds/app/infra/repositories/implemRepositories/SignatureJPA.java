package tf.fds.app.infra.repositories.implemRepositories;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.domain.repositories.ISignatureRepository;
import tf.fds.app.infra.repositories.InterfJPA.Signature_ItfRep;
import tf.fds.app.infra.repositories.adapter.SignatureAdapter;
import tf.fds.app.infra.repositories.entities.Signature;

public class SignatureJPA implements ISignatureRepository {
    private Signature_ItfRep signatureRep;

    public SignatureJPA(Signature_ItfRep signatureRep) {
        this.signatureRep = signatureRep;
    }

    @Override
    public SignatureModel createSignature(SignatureModel signature) {
        signatureRep.save(SignatureAdapter.fromSignatureModel(signature));
        return signature;
    }

    @Override
    public boolean isActive(long codass) {
        Signature sign = signatureRep.findById(codass).orElse(null);

        if (sign.getEndDate().isBefore(LocalDate.now())) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<SignatureModel> getAllSignatures() {
        List<Signature> sign = signatureRep.findAll();
        return sign.stream().map(s -> SignatureAdapter.toSignatureModel(s)).toList();
    }

    @Override
    public List<SignatureModel> getAllSignaturesByClient(long codcli) {
        List<Signature> sign = signatureRep.findAll();
        sign = sign.stream().filter(s -> s.getClient().getCode() == codcli).toList();
        return sign.stream().map(s -> SignatureAdapter.toSignatureModel(s)).toList();
    }

    @Override
    public List<SignatureModel> getAllSignaturesByApp(long codapp) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllSignaturesByApp'");
    }
}
