package tf.fds.app.application.useCases;

import tf.fds.app.application.dtos.ClientDTO;
import tf.fds.app.domain.entities.ClientModel;
import tf.fds.app.domain.services.ClientService;

@Component
public class GetAllClientsUC {
    private ClientService clientService;

    //@Autowired
    public GetAllClientsUC(ClientService clientService){
        this.clientService = clientService;
    }
    
    public ClientDTO run(){
        ClientModel clients = clientService.getAllClients();
        return clients;
    }
}