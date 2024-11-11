package tf.fds.app.domain.InterfRepository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import tf.fds.app.domain.entity.UserModel;

public interface UserModel_ItfRep extends CrudRepository<UserModel,Long>{
    List<UserModel> findAll();
    Optional<UserModel> findByCode(long code);
}
