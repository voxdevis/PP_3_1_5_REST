package io.voxdevis.springboot_security.repository;

import io.voxdevis.springboot_security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.roles where u.username = (:username)")
    User findByUsername(@Param("username") String username);
}