package io.voxdevis.rest.service;



import io.voxdevis.rest.entity.User;
import io.voxdevis.rest.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;



import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    UserRepository userRepository;

    @Autowired
    BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<User> showAll() {
        return userRepository.findAll();
    }


    public User show(Long userId) {

        Optional<User> userFromDb = userRepository.findById(userId);
        return userFromDb.orElse(new User());
    }


    public void save(User user) {

        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userRepository.save(user);

    }


    public void update(User updatedUser) {

        updatedUser.setPassword(bCryptPasswordEncoder.encode(updatedUser.getPassword()));
        userRepository.save(updatedUser);

    }


    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        return user;
    }

    @Override
    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

}
