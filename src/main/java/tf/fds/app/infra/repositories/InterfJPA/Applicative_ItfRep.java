package tf.fds.app.infra.repositories.InterfJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tf.fds.app.infra.repositories.entities.Applicative;

/**
 * Interface de repositório de aplicativos que herda de CrudRepository do JPA.
 */
public interface Applicative_ItfRep extends CrudRepository<Applicative, Long> {
    List<Applicative> findAll();

    Optional<Applicative> findByCode(long code);
}
