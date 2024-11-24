package tf.fds.app.infra.repositories.implemRepositories;

import java.util.List;

import tf.fds.app.domain.entities.ClientModel;
import tf.fds.app.domain.repositories.IClientRepository;
import tf.fds.app.infra.repositories.InterfJPA.Client_ItfRep;
import tf.fds.app.infra.repositories.adapter.ClientAdapter;
import org.springframework.stereotype.Repository;

/**
 * Implementação da interface de repositório de clientes.
 */
@Repository
public class ClientJPA implements IClientRepository {

    private Client_ItfRep clientRep;

    /**
     * Constrói um novo ClientJPA com o repositório especificado.
     * 
     * @param clients o repositório de clientes
     */
    public ClientJPA(Client_ItfRep clients) {
        this.clientRep = clients;
    }

    /**
     * Obtém todos os clientes.
     * 
     * @return uma lista de todos os clientes
     */
    @Override
    public List<ClientModel> getAllClients() {
        return clientRep.findAll().stream().map(c -> ClientAdapter.toClientModel(c)).toList();
    }

    /**
     * Obtém um cliente pelo ID.
     * 
     * @param clientId o ID do cliente
     * @return o cliente com o ID especificado
     */
    @Override
    public ClientModel getClientById(long clientId) {
        return ClientAdapter.toClientModel(clientRep.findById(clientId).orElse(null));
    }
}