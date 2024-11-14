package tf.fds.app.application.dtos;

import tf.fds.app.domain.entity.UserModel;

public class UserDTO {
    private String userName;
    private String password;

    public UserDTO(UserModel userModel) {
        this.userName = userModel.getUserName();
        this.password = userModel.getPassword();
    }

    public String getuserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO fromModel(UserModel userModel) {
        return new UserDTO(userModel);
    }

    public String toString(){
        return "userName: " + userName + ", password: " + password;
    }
}
