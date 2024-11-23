package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entities.ClientModel;
import tf.fds.app.infra.repositories.entities.Client;
public class ClientAdapter {

    /*
     * Conversor de ClientModel para Client
     * @param cModel
     * @return Client
     * Cria um objeto Client a partir de um ClientModel
     * Mapea os objetos de ClientModel para Client
    */
    public static Client fromClientModel (ClientModel cModel){
        Client client = new Client();
        client.setCode(cModel.getCode());
        client.setName(cModel.getName());
        client.setEmail(cModel.getEmail());
        return client;
    }

    /*
     * Conversor de Client para ClientModel
     * @param client
     * @return ClientModel
     * Cria um objeto ClientModel a partir de um objeto Client
     * Mapea os objetos de Client para ClientModel
    */
    public static ClientModel toClientModel(Client client){
        ClientModel cModel = new ClientModel();
        cModel.setCode(client.getCode());
        cModel.setName(client.getName());
        cModel.setEmail(client.getEmail());
        return cModel;
    }   
}
