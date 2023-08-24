package org.example.hibernate_app_aston.services;

import org.example.hibernate_app_aston.dao.EmployeeDAO;
import org.example.hibernate_app_aston.dao.ProjectDAO;
import org.example.hibernate_app_aston.dao.RoleDAO;
import org.example.hibernate_app_aston.dto.EmployeeDTO;
import org.example.hibernate_app_aston.mappers.EmployeeMapper;
import org.example.hibernate_app_aston.models.Employee;
import org.example.hibernate_app_aston.models.Project;
import org.example.hibernate_app_aston.models.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    private final EmployeeDAO employeeDAO;
    private final RoleDAO roleDAO;
    private final ProjectDAO projectDAO;

    @Autowired
    public EmployeeService(EmployeeDAO employeeDAO, RoleDAO roleDAO, ProjectDAO projectDAO) {
        this.employeeDAO = employeeDAO;
        this.roleDAO = roleDAO;
        this.projectDAO = projectDAO;
    }


    @Transactional
    public EmployeeDTO getEmployeeById(Long id){

        return EmployeeMapper.toEmployeeDTO(employeeDAO.show(id));
    }

    @Transactional
    public EmployeeDTO getEmployeeByName(String name){
        return EmployeeMapper.toEmployeeDTO(employeeDAO.showByName(name));
    }



    @Transactional
    public List<EmployeeDTO> getAllEmployees(){
        List<Employee> employees = employeeDAO.index();
        List<EmployeeDTO> employeeDTOS = new ArrayList<>();
        for ( Employee employee : employees) {
            employeeDTOS.add(EmployeeMapper.toEmployeeDTO(employee));
        }
        return employeeDTOS;
     }


     @Transactional
     public EmployeeDTO createEmployee(EmployeeDTO employeeDTO){
         Role role = roleDAO.showByName(employeeDTO.getRole());
         if(role!=null) {
             Employee employee = new Employee();
             employee.setName(employeeDTO.getName());
             employee.setRole(role);
             employeeDAO.save(employee);
         }
        return employeeDTO;
     }

    public void deleteEmployee(Long id){
        employeeDAO.delete(id);
     }


    @Transactional
    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO){
        Role role = roleDAO.showByName(employeeDTO.getRole());
        if(role!=null) {

            List<Project> projects = new ArrayList<>();

            for(String projectName: employeeDTO.getProjects()){
               Project project = projectDAO.showByName(projectName);
               if (project.getName()!=null){
                   projects.add(project);
               }
            }
            Employee employee = employeeDAO.show(id);
            employee.setName(employeeDTO.getName());
            employee.setRole(role);
            employee.setProjects(projects);
            employeeDAO.save(employee);
        }
        return employeeDTO;
    }



}
