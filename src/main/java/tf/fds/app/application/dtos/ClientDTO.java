package tf.fds.app.application.dtos;

import tf.fds.app.domain.entity.ClientModel;

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

    public ClientDTO fromModel(ClientModel clientModel) {
        return new ClientDTO(clientModel);
    }

    @Override
    public String toString() {
        return "code: " + code + ", name: " + name + ", Email: " + email;
    }
}
