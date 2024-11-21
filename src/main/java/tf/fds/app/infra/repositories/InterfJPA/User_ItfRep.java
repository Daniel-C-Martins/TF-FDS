package tf.fds.app.infra.repositories.InterfJPA;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import tf.fds.app.infra.repositories.entities.User;

public interface User_ItfRep extends CrudRepository<User, Long>{
    List<User> findAll();
    Optional<User> findByCode(long id);
}
