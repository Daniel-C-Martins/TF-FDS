
import tf.fds.app.domain.entities.ClientModel;
import tf.fds.app.domain.repositories.IClientRepository;
import tf.fds.app.infra.repositories.InterfJPA.Client_ItfRep;
import tf.fds.app.infra.repositories.adapter.ClientAdapter;
import tf.fds.app.infra.repositories.entities.Client;

import java.util.*;


@Repository
@primary
public class ClientJPA implements IClientRepository{

    private Client_ItfRep clients;

    //@Autowired
    public Client_ItfRep(Client_ItfRep clients){
        this.clients = clients;
    }

    @Override
    public List<ClientModel> getAllClients(){
        List<ClientModel> clients = clients.findAll();
        return clients.stream()
                .map(it->ClientAdapter.toClientModel(it))
                .toList();
    }
}