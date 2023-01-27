package io.voxdevis.springbootstrap.repository;

import io.voxdevis.springbootstrap.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}