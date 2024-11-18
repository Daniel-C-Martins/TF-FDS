package tf.fds.app.application.dtos;

import tf.fds.app.domain.entities.UserModel;

public class UserDTO {
    private String userName;
    private String password;

    public UserDTO(UserModel userModel) {
        this.userName = userModel.getUsername();
        this.password = userModel.getPassword();
    }

    public String getUsername() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String toString(){
        return "userName: " + userName + ", password: " + password;
    }
}
