package tf.fds.app.adapterInterface.repositories.implemRepositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tf.fds.app.domain.entity.ApplicativeModel;

public interface ApplicativeModel_ItfRep extends CrudRepository<ApplicativeModel,Long>{
    List<ApplicativeModel> findAll();
    Optional<ApplicativeModel> findByCode(long code);
}
