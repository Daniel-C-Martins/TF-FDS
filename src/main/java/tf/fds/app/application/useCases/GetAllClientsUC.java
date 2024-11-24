package tf.fds.app.application.useCases;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import tf.fds.app.application.responseDTO.ClientDTO;
import tf.fds.app.domain.services.ClientService;

/**
 * Caso de uso para pegar todos os clientes.
 * Esta classe é responsável por obter todos os clientes.
 */
@Component
public class GetAllClientsUC {
    private ClientService clientService;

    /**
     * Constrói um novo GetAllClientsUC com o serviço especificado.
     *
     * @param clientService o serviço para lidar com operações de cliente
     */
    @Autowired
    public GetAllClientsUC(ClientService clientService) {
        this.clientService = clientService;
    }

    /**
     * Executa o caso de uso para obter todos os clientes.
     *
     * @return uma lista de ClientDTO contendo os detalhes de todos os clientes
     */
    public List<ClientDTO> run() {
        List<ClientDTO> clients = clientService.getAllClients().stream().map(c -> new ClientDTO(c)).toList();
        return clients;
    }
}