package com.firmavp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.firmavp.entity.Role;

@Repository
public interface RolesRepository extends JpaRepository<Role, Integer> {

	Role findRoleById(Integer id);

}
