package tf.fds.app.application.dtos;

import tf.fds.app.domain.entity.UserModel;

public class UserDTO {
    private String name;
    private String password;

    public UserDTO(UserModel userModel) {
        this.name = userModel.getName();
        this.password = userModel.getPassword();
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO fromModel(UserModel userModel) {
        return new UserDTO(userModel);
    }

    public String toString(){
        return "name: " + name + ", password: " + password;
    }
}
