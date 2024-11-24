package tf.fds.app.infra.repositories.implemRepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import tf.fds.app.domain.entities.ApplicativeModel;
import tf.fds.app.domain.repositories.IApplicativeRepository;
import tf.fds.app.infra.repositories.InterfJPA.Applicative_ItfRep;
import tf.fds.app.infra.repositories.adapter.ApplicativeAdapter;
import tf.fds.app.infra.repositories.entities.Applicative;

/**
 * Implementação da interface de repositório de aplicativos.
 */
@Repository
public class ApplicativeJPA implements IApplicativeRepository {
    private Applicative_ItfRep applicatives;

    /**
     * Constrói um novo ApplicativeJPA com o repositório especificado.
     * 
     * @param applicatives o repositório de aplicativos
     */
    public ApplicativeJPA(Applicative_ItfRep applicatives) {
        this.applicatives = applicatives;
    }

    /**
     * Atualiza o custo de um aplicativo.
     * 
     * @param code        o código do aplicativo
     * @param name        o nome do aplicativo
     * @param monthlyCost o custo mensal do aplicativo
     * @return o aplicativo criado
     */
    @Override
    public ApplicativeModel updateMonthlyCost(double newCost, Long id) {

        // Verifica se aplicativo existe
        Applicative app = applicatives.findById(id).orElse(null);
        if (app == null) {
            throw new IllegalArgumentException("Aplicativo inexistente");
        }

        // Coloca o novo custo mensal
        app.setMonthlyCost(newCost);

        // Salva o aplicativo
        applicatives.save(app);
        return ApplicativeAdapter.toApplicativeModel(app);
    }

    /**
     * Obtém todos os aplicativos.
     * 
     * @return uma lista de todos os aplicativos
     */
    @Override
    public List<ApplicativeModel> getAllApplicatives() {
        return applicatives.findAll().stream().map(a -> ApplicativeAdapter.toApplicativeModel(a)).toList();
    }

    /**
     * Obtém um aplicativo por ID.
     * 
     * @param applicativeId o ID do aplicativo
     * @return o aplicativo com o ID especificado
     */
    @Override
    public ApplicativeModel getApplicativeById(long applicativeId) {
        return ApplicativeAdapter.toApplicativeModel(applicatives.findById(applicativeId).orElse(null));
    }
}
