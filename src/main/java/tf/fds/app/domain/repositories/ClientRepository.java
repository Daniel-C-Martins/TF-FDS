package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.infra.repositories.entities.Client;

public interface ClientRepository {
    List<Client> getAllClients();
    
}
