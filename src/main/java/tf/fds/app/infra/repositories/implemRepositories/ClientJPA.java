package tf.fds.app.infra.repositories.implemRepositories;

import java.util.List;

import tf.fds.app.domain.entities.ClientModel;
import tf.fds.app.domain.repositories.IClientRepository;
import tf.fds.app.infra.repositories.InterfJPA.Client_ItfRep;
import tf.fds.app.infra.repositories.adapter.ClientAdapter;
import org.springframework.stereotype.Repository;

@Repository
public class ClientJPA implements IClientRepository {

    private Client_ItfRep clientRep;

    // @Autowired
    public ClientJPA(Client_ItfRep clients) {
        this.clientRep = clients;
    }

    @Override
    public List<ClientModel> getAllClients() {
        return clientRep.findAll().stream().map(c -> ClientAdapter.toClientModel(c)).toList();
    }
}