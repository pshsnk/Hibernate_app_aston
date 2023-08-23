package org.example.hibernate_app_aston.mappers;

import org.example.hibernate_app_aston.dto.RoleDTO;
import org.example.hibernate_app_aston.models.Employee;
import org.example.hibernate_app_aston.models.Role;

import java.util.List;

public class RoleMapper {

    public static RoleDTO toRoleDTO(Role role){
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setName(role.getName());
        List<Employee> employees = role.getEmployees();
        for (Employee employee : employees){
            roleDTO.getEmployees().add(employee.getName());
        }
        return roleDTO;
    }

}
