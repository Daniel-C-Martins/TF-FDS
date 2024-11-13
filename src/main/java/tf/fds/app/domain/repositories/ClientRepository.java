package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entity.ClientModel;

public interface ClientRepository {
    List<ClientModel> getAllClients();

}
