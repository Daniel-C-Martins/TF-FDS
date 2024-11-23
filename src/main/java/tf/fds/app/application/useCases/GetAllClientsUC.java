package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.ClientDTO;
import tf.fds.app.domain.services.ClientService;

@Component
public class GetAllClientsUC {
    private ClientService clientService;

    //@Autowired
    public GetAllClientsUC(ClientService clientService){
        this.clientService = clientService;
    }
    
    public List<ClientDTO> run(){
        List<ClientDTO> clients = clientService.getAllClients().stream().map(c -> new ClientDTO(c)).toList();
        return clients;
    }
}