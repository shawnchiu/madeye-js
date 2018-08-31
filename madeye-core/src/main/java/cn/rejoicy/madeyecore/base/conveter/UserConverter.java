package cn.rejoicy.madeyecore.base.conveter;

import cn.rejoicy.madeyecore.domain.user.entity.User;
import cn.rejoicy.madeyecore.viewmodel.UserDTO;
import org.springframework.core.convert.converter.Converter;

/**
 * @author shawnchiu
 * @date 2018/8/31
 */
public class UserConverter {


    public static Converter<User, UserDTO> getUserConverter() {
        return user -> {
            UserDTO userDTO = new UserDTO();
            userDTO.setEmail(user.getEmail());
            userDTO.setPhone(user.getPhone());
            userDTO.setUserCode(user.getUserCode());
            userDTO.setUserName(user.getUserName());
            return userDTO;
        };
    }

    public static Converter<UserDTO, User> getUserDTOConverter() {
        return userDTO -> {
            User user = new User();
            user.setEmail(userDTO.getEmail());
            user.setPhone(userDTO.getPhone());
            user.setUserCode(userDTO.getUserCode());
            user.setUserName(userDTO.getUserName());
            return user;
        };
    }
}
