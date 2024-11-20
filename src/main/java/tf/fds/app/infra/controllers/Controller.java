package tf.fds.app.infra.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import tf.fds.app.application.dtos.ClientDTO;
import tf.fds.app.application.useCases.GetAllClientsUC;

@RestController
public class Controller {
    private GetAllClientsUC getAllClients;

    public Controller (GetAllClientsUC getAllClients){
        this.getAllClients = getAllClients;
    }

    @GetMapping("getAllClients")
    @CrossOrigin(origins = "*")
    public List<ClientDTO> getAllClients(){
        return getAllClients.run();
    }  

}
