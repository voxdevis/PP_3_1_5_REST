package io.voxdevis.springboot_security.repository;

import io.voxdevis.springboot_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}