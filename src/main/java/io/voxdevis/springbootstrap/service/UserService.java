package io.voxdevis.springbootstrap.service;

import io.voxdevis.springbootstrap.entity.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService extends UserDetailsService {

    List<User> showAll();

     User show(Long userId);

     void save(User user);

    void update(User updatedUser);

    void delete(Long id);

    UserDetails loadUserByUsername(String username);
}
