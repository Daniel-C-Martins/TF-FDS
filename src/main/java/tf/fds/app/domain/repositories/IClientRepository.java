package tf.fds.app.domain.repositories;

import java.util.List;

import tf.fds.app.domain.entities.ClientModel;

/**
 * Interface que representa o repositório de clientes.
 */
public interface IClientRepository {
    List<ClientModel> getAllClients();

    ClientModel getClientById(long clientId);
}
