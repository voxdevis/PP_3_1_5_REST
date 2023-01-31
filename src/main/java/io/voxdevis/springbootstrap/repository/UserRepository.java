package io.voxdevis.springbootstrap.repository;

import io.voxdevis.springbootstrap.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u join fetch u.roles where u.email = (:email)")
    User findByEmail(@Param("email") String email);
}