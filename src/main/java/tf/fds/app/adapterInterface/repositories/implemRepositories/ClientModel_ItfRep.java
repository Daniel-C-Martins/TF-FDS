package tf.fds.app.adapterInterface.repositories.implemRepositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tf.fds.app.domain.entity.ClientModel;

public interface ClientModel_ItfRep extends CrudRepository<ClientModel,Long>{
    List<ClientModel> findAll();
    Optional<ClientModel> findByCode(long code);
}
