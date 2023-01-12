package io.voxdevis.springboot_security.service;

import io.voxdevis.springboot_security.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findAll();
}
