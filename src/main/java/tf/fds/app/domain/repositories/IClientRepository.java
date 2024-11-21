package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entities.ClientModel;

public interface IClientRepository {
    List<ClientModel> getAllClients();
}
