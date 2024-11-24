package tf.fds.app.infra.repositories.InterfJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tf.fds.app.infra.repositories.entities.Payment;

/**
 * Interface de repositório de pagamentos que herda de CrudRepository do JPA.
 */
public interface Payment_ItfRep extends CrudRepository<Payment, Long> {
    List<Payment> findAll();

    Optional<Payment> findByCode(long code);
}
