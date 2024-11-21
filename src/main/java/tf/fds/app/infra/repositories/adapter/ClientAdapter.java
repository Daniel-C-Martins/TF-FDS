package tf.fds.app.infra.repositories.adapter;

import java.util.LinkedList;
import java.util.List;

import tf.fds.app.domain.entities.ClientModel;
import tf.fds.app.domain.entities.SignatureModel;
import tf.fds.app.infra.repositories.entities.Client;
import tf.fds.app.infra.repositories.entities.Signature;

public class ClientAdapter {

    /*
     * Conversor de Client para ClientModel
     * @param cModel
     * @return Client
     * Cria um objeto Client a partir de um ClientModel
     * Mapea os objetos de ClientModel para Client
    */
    public static Client fromClientModel (ClientModel cModel){
        Client client = new Client(cModel.getName(), cModel.getEmail());
        client.setCode(cModel.getCode());

        List<Signature> sign = new LinkedList<>();
        cModel.getSignatures().forEach(s -> sign.add(SignatureAdapter.fromSignatureModel(s)));
        client.setSignatures(sign);
        return client;
    }

    /*
     * Conversor de ClientModel para Client
     * @param client
     * @return ClientModel
     * Cria um objeto ClientModel a partir de um objeto Client
     * Mapea os objetos de Client para ClientModel
    */
    public static ClientModel toClientModel (Client client){
        ClientModel cModel = new ClientModel(client.getCode(), client.getName(), client.getEmail());

        List<SignatureModel> sign = new LinkedList<>();
        client.getSignatures().forEach(s -> sign.add(SignatureAdapter.toSignatureModel(s)));
        cModel.setSignatures(sign);
        return cModel;
    }

}
