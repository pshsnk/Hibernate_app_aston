package org.example.hibernate_app_aston.services;

import org.example.hibernate_app_aston.dao.RoleDAO;
import org.example.hibernate_app_aston.dto.RoleDTO;
import org.example.hibernate_app_aston.mappers.RoleMapper;
import org.example.hibernate_app_aston.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class RoleService {

    private final RoleDAO roleDAO;
    @Autowired
    public RoleService(RoleDAO roleDAO) {
        this.roleDAO = roleDAO;
    }

    @Transactional
    public RoleDTO getRoleById(Long id){
        return RoleMapper.toRoleDTO(roleDAO.show(id));
    }

    @Transactional
    public RoleDTO createRole(RoleDTO roleDTO){
        Role role = new Role();
        role.setName(roleDTO.getName());
        roleDAO.save(role);
        return roleDTO;
    }

    @Transactional
    public List<RoleDTO> getAllRoles(){
        List<Role> roles = roleDAO.index();
        List<RoleDTO> roleDTOS = new ArrayList<>();
        for ( Role role : roles) {
            roleDTOS.add(RoleMapper.toRoleDTO(role));
        }
        return roleDTOS;
    }

    public void deleteRole(Long id){
       roleDAO.delete(id);
    }
}
