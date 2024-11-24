package tf.fds.app.application.responseDTO;

import tf.fds.app.domain.entities.UserModel;

/**
 * DTO utilizado para enviar os dados de um usuário
 * 
 * @param code
 * @param userName
 * @param password
 */
public class UserDTO {
    private long code;
    private String userName;
    private String password;

    public UserDTO(UserModel userModel) {
        this.code = userModel.getCode();
        this.userName = userModel.getUsername();
        this.password = userModel.getPassword();
    }

    public long getCode() {
        return code;
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    @Override
    public String toString() {
        return "UserDTO - Código = " + code + ", Nome de usuário = " + userName + ", Senha = " + password;
    }
}
