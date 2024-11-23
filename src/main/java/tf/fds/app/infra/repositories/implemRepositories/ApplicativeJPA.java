package tf.fds.app.infra.repositories.implemRepositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import tf.fds.app.domain.entities.ApplicativeModel;
import tf.fds.app.domain.repositories.IApplicativeRepository;
import tf.fds.app.infra.repositories.InterfJPA.Applicative_ItfRep;
import tf.fds.app.infra.repositories.adapter.ApplicativeAdapter;
import tf.fds.app.infra.repositories.entities.Applicative;

@Repository
public class ApplicativeJPA implements IApplicativeRepository {
    private Applicative_ItfRep applicatives;

    public ApplicativeJPA(Applicative_ItfRep applicatives) {
        this.applicatives = applicatives;
    }

    @Override
    public ApplicativeModel updateMonthlyCost(double newCost, Long id) {
        Applicative app = applicatives.findById(id).orElse(null);
        if (app == null) {
            throw new IllegalArgumentException("Aplicativo inexistente");
        }
        app.setMonthlyCost(newCost);
        applicatives.save(app);
        return ApplicativeAdapter.toApplicativeModel(app);
    }

    @Override
    public List<ApplicativeModel> getAllApplicatives() {
        return applicatives.findAll().stream().map(a -> ApplicativeAdapter.toApplicativeModel(a)).toList();
    }

    @Override
    public ApplicativeModel getApplicativeById(long applicativeId) {
        return ApplicativeAdapter.toApplicativeModel(applicatives.findById(applicativeId).orElse(null));
    }
}
