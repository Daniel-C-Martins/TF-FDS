package tf.fds.app.domain.services;

import java.util.List;

import org.springframework.stereotype.Service;
import tf.fds.app.domain.entities.ApplicativeModel;
import tf.fds.app.domain.repositories.IApplicativeRepository;

@Service
public class ApplicativeService {
    private IApplicativeRepository applicativeRep;

    //@Autowired
    public ApplicativeService(IApplicativeRepository applicativeRep){
        this.applicativeRep = applicativeRep;
    }

    public List<ApplicativeModel> getAllApplicatives(){
        return applicativeRep.getAllApplicatives();
    }

    public ApplicativeModel updateMonthlyCost(double newCost, Long id ){
        return applicativeRep.updateMonthlyCost(newCost, id);
    }

    public ApplicativeModel getApplicativeById(long applicativeId){
        return applicativeRep.getApplicativeById(applicativeId);
    }
}
