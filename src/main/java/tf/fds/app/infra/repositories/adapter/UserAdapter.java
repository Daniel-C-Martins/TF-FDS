package tf.fds.app.infra.repositories.adapter;

import tf.fds.app.domain.entities.UserModel;
import tf.fds.app.infra.repositories.entities.User;


public class UserAdapter {
    /*
     * Conversor de UserModel para User
     * @param usModel
     * @return User
     * Cria um objeto User a partir de um objeto UserModel
     */
    public static User fromUserModel(UserModel usModel){
        return new User(usModel.getCode(), usModel.getUsername(), usModel.getPassword());
    }

    /*
     * Conversor de User para UserModel
     * @param user
     * @return UserModel
     * Cria um objeto UserModel a partir de um objeto User
     */
    public static UserModel toUserModel(User user){
        return new UserModel(user.getCode(), user.getUsername(), user.getPassword());
    }

}
