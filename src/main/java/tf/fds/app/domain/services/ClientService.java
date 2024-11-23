package tf.fds.app.domain.services;

import tf.fds.app.domain.repositories.IClientRepository;
import tf.fds.app.domain.entities.ClientModel;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    private IClientRepository clientRep;

    @Autowired
    public ClientService(IClientRepository clientRep){
        this.clientRep = clientRep;
    }

    public List<ClientModel> getAllClients(){
        return clientRep.getAllClients();
    }

    public ClientModel getClientById(long clientId){
        return clientRep.getClientById(clientId);
    }
}