package pro.aquaone.util;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import pro.aquaone.model.Role;
import pro.aquaone.model.User;
import pro.aquaone.to.UserTo;


public class UserUtil {

    //public static final int DEFAULT_CALORIES_PER_DAY = 2000;

    public static User createNewFromTo(UserTo userTo) {
        return new User(null, userTo.getUsername(), userTo.getSurname(), userTo.getOrganization(), userTo.getEmail().toLowerCase(), userTo.getPassword(),
                userTo.getPhone(), userTo.getAddress(), Role.ROLE_USER);
    }

    public static UserTo asTo(User user) {
        return new UserTo(user.getId(), user.getName(), user.getSurname(), user.getOrganization(), user.getEmail(), user.getPassword(),
                user.getPhone(), user.getAddress());
    }

    public static User updateFromTo(User user, UserTo userTo) {
        user.setName(userTo.getUsername());
        user.setSurname(userTo.getSurname());
        user.setOrganization(userTo.getOrganization());
        user.setEmail(userTo.getEmail().toLowerCase());
        user.setPassword(userTo.getPassword());
        user.setPhone(userTo.getPhone());
        user.setAddress(userTo.getAddress());
        return user;
    }

    public static User prepareToSave(User user, PasswordEncoder passwordEncoder) {
        String password = user.getPassword();
        user.setPassword(StringUtils.hasText(password) ? passwordEncoder.encode(password) : password);
        user.setEmail(user.getEmail().toLowerCase());
        return user;
    }
}