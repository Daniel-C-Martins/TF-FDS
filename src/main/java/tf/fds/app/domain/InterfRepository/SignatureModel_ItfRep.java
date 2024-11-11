package tf.fds.app.domain.InterfRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tf.fds.app.domain.entity.SignatureModel;

public interface SignatureModel_ItfRep extends CrudRepository<SignatureModel,Long>{
    List<SignatureModel> findAll();
    Optional<SignatureModel> findByCode(long code);
}
