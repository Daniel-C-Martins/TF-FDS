package tf.fds.app.application.responseDTO;

import tf.fds.app.domain.entities.UserModel;

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

    public String toString(){
        return "Code:" + code + "userName: " + userName + ", password: " + password;
    }
}
