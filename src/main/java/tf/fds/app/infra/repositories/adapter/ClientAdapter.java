package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entity.ClientModel;
import tf.fds.app.infra.repositories.entities.Client;

public class ClientAdapter {

    public static Client fromClientModel (ClientModel cModel){
        cModel.getSignatures().forEach(s -> SignatureAdapter.fromSignatureModel(s));
        return new Client(cModel.getName(), cModel.getEmail());
    }

    public static ClientModel toClientModel (Client client){
        return new ClientModel(client.getCode(), client.getName(), client.getEmail());
    }

}