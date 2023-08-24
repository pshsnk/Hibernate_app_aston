package org.example.hibernate_app_aston.mappers;

import org.example.hibernate_app_aston.dto.ProjectDTO;
import org.example.hibernate_app_aston.models.Employee;
import org.example.hibernate_app_aston.models.Project;

import java.util.List;

public class ProjectMapper {


    public static ProjectDTO toProjectDTO(Project project){
        ProjectDTO projectDTO = new ProjectDTO();
        projectDTO.setName(project.getName());
        List<Employee>employees=project.getEmployees();
        for(Employee employee : employees) {
            projectDTO.getEmployees().add(employee.getName());
        }
        return projectDTO;
    }


}
