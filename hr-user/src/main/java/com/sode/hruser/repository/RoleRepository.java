package com.sode.hruser.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sode.hruser.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long>  {

}
