package io.voxdevis.springboot_security.repository;

import io.voxdevis.springboot_security.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
}