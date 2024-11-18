package tf.fds.app.domain.services;

import tf.fds.app.domain.repositories.IClientRepository;
import java.util.*;
import tf.fds.app.domain.entities.ClientModel;

@Service
public class ClientService {
    private IClientRepository clients;

    //@Autowired
    public ClientService(IClientRepository clients){
        this.clients = clients;
    }

    public List<ClientModel> getAllClients(){
        return clients.getAllClients();
    }
}