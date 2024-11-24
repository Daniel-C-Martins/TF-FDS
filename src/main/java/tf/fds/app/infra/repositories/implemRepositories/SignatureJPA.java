package tf.fds.app.infra.repositories.implemRepositories;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.domain.repositories.ISignatureRepository;
import tf.fds.app.infra.repositories.InterfJPA.Signature_ItfRep;
import tf.fds.app.infra.repositories.adapter.SignatureAdapter;
import tf.fds.app.infra.repositories.entities.Signature;

@Repository
public class SignatureJPA implements ISignatureRepository {
    private Signature_ItfRep signatureRep;

    public SignatureJPA(Signature_ItfRep signatureRep) {
        this.signatureRep = signatureRep;
    }

    /*
     * Cria uma assinatura
     * @param signature
     * @return SignatureModel
     * Salva a assinatura no banco de dados
     */
    @Override
    public SignatureModel createSignature(SignatureModel signature) {
        signatureRep.save(SignatureAdapter.fromSignatureModel(signature));
        return signature;
    }

    /*
     * Verifica se a assinatura está ativa
     * @param codass
     * @return boolean
     * Pesquisa a assinatura pelo código e verifica se a data de término é posterior a data atual
     */
    @Override
    public boolean isActive(long codass) {
        Signature sign = signatureRep.findById(codass).orElse(null);

        if (sign.getEndDate().isAfter(LocalDate.now())) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Retorna uma lista de todas as assinaturas
     * @return List<SignatureModel>
     * Pesquisa todas as assinaturas e mapeia para SignatureModel
     */
    @Override
    public List<SignatureModel> getAllSignatures() {
        return signatureRep.findAll().stream().map(s -> SignatureAdapter.toSignatureModel(s)).toList();
    }

    /*
     * Retorna uma lista de assinaturas de um cliente
     * @param codcli
     * @return List<SignatureModel>
     * Pesquisa todas as assinaturas e filtra as que possuem o código do cliente igual a codcli
     */
    @Override
    public List<SignatureModel> getSignaturesByClient(long codcli) {
        List<Signature> sign = signatureRep.findAll().stream().filter(s -> s.getClient().getCode() == codcli).toList();
        return sign.stream().map(s -> SignatureAdapter.toSignatureModel(s)).toList();
    }

    /*
     * Retorna uma lista de assinaturas de um aplicativo
     * @param codapp
     * @return List<SignatureModel>
     * Pesquisa todas as assinaturas e filtra as que possuem o código do aplicativo igual a codapp
     */
    @Override
    public List<SignatureModel> getSignaturesByApp(long codapp) {
        List<Signature> sign = signatureRep.findAll().stream().filter(s -> s.getApplicative().getCode() == codapp).toList();
        return sign.stream().map(s -> SignatureAdapter.toSignatureModel(s)).toList();
    }

    /*
     * Retorna uma assinatura pelo código
     * @param codass
     * @return SignatureModel
     * Pesquisa a assinatura pelo código e mapeia para SignatureModel
     */
    @Override
    public SignatureModel getSignatureById(long codass) {
        return SignatureAdapter.toSignatureModel(signatureRep.findById(codass).orElse(null));
    }

    @Override
    public void updateSignatureStatus() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateSignatureStatus'");
    }
}
