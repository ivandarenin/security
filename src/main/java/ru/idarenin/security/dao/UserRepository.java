package ru.idarenin.security.dao;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;
import ru.idarenin.security.domain.Role;
import ru.idarenin.security.domain.User;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Component
public class UserRepository {

    private final List<User> userList = Arrays.asList(
            new User("admin", new BCryptPasswordEncoder().encode("admin"), Collections.singletonList(Role.USER)),
            new User("test",  new BCryptPasswordEncoder().encode("pass"), Collections.singletonList(Role.USER))
    );

    public User findByName(String login) {
        return userList.stream()
                .filter(user -> user.getUsername().equals(login))
                .findFirst()
                .get();
    }
}