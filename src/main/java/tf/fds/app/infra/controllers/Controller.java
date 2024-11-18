package tf.fds.app.infra.controllers;

import tf.fds.app.application.useCases.GetAllClientsUC;

public class Controller {
    private GetAllClientsUC getAllClients;

    public controller (GetAllClientsUC getAllClients){
        this.getAllClients = getAllClients;
    }

    @GetMapping("getAllClients")
    @CrossOrigin(origins = "*")
    public List<ClientDTO> getAllClients(){
        return getAllClients.run();
    }  

}
