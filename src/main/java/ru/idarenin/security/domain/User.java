package ru.idarenin.security.domain;

import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.List;

@Data
public class User  implements UserDetails {

    private List<Role> authorities;
    private String username;
    private String password;

    public User(String username, String password, List<Role> authorities) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
