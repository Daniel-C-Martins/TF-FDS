package tf.fds.app.infra.repositories.InterfJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tf.fds.app.infra.repositories.entities.Signature;

public interface Signature_ItfRep extends CrudRepository<Signature, Long>{
    List<Signature> findAll();
    Optional<Signature> findById(long code);
}
