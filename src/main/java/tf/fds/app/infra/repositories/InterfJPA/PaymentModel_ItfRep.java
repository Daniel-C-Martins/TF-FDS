package tf.fds.app.infra.repositories.InterfJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tf.fds.app.domain.entity.PaymentModel;

public interface PaymentModel_ItfRep extends CrudRepository<PaymentModel,Long>{
    List<PaymentModel> findAll();
    Optional<PaymentModel> findByCode(long code);
}
