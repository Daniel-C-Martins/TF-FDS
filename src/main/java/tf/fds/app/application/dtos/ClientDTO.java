package tf.fds.app.application.dtos;

import java.util.LinkedList;
import java.util.List;

import tf.fds.app.domain.entity.ClientModel;

public class ClientDTO {
    private long code;
    private String name;
    private String email;
    private List<SignatureDTO> signatures;

    public ClientDTO(ClientModel clientModel) {
        this.code = clientModel.getCode();
        this.name = clientModel.getName();
        this.email = clientModel.getEmail();
        this.signatures = new LinkedList<SignatureDTO>();

        clientModel.getSignatures().stream().forEach(sModel -> {
            this.signatures.add(new SignatureDTO(sModel));
        });
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

    public List<SignatureDTO> getSignatures() {
        return signatures;
    }

    public void setCode(long code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSignatures(List<SignatureDTO> signatures) {
        this.signatures = signatures;
    }

    @Override
    public String toString() {
        return "ClientDTO: code = " + code + ", name = " + name + ", email = " + email + ", signatures = " + signatures;
    }
}
