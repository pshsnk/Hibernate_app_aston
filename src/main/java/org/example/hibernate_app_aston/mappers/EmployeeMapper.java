package org.example.hibernate_app_aston.mappers;

import org.example.hibernate_app_aston.dto.EmployeeDTO;
import org.example.hibernate_app_aston.models.Employee;
import org.example.hibernate_app_aston.models.Project;

import java.util.ArrayList;
import java.util.List;

public class EmployeeMapper {


    public static EmployeeDTO toEmployeeDTO(Employee employee){
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setName(employee.getName());
        employeeDTO.setRole(employee.getRole().getName());
        List<Project> projects = employee.getProjects();
        for (Project project: projects){
            employeeDTO.getProjects().add(project.getName());
        }
        return employeeDTO;
    }
}
