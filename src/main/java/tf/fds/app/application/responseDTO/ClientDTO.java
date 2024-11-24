package tf.fds.app.application.responseDTO;

import tf.fds.app.domain.entities.ClientModel;

/*
 * DTO utilizado para enviar os dados de um cliente
 * @param code
 * @param name
 * @param email
 */
public class ClientDTO {
    private long code;
    private String name;
    private String email;


    public ClientDTO(ClientModel clientModel) {
        this.code = clientModel.getCode();
        this.name = clientModel.getName();
        this.email = clientModel.getEmail();
    }

    public long getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ClientDTO: code = " + code + ", name = " + name + ", email = " + email;
    }
}
