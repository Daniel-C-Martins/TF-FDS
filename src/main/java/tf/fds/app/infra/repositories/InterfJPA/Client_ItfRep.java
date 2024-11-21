package tf.fds.app.infra.repositories.InterfJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tf.fds.app.infra.repositories.entities.Client;

public interface Client_ItfRep extends CrudRepository<Client,Long>{
    List<Client> findAll();
    Optional<Client> findByCode(long code);
}
