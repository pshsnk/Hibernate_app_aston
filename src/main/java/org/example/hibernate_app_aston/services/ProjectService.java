package org.example.hibernate_app_aston.services;

import org.example.hibernate_app_aston.dao.ProjectDAO;
import org.example.hibernate_app_aston.dto.ProjectDTO;
import org.example.hibernate_app_aston.mappers.ProjectMapper;
import org.example.hibernate_app_aston.models.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectService {

    private final ProjectDAO projectDAO;

    @Autowired
    public ProjectService(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Transactional
    public ProjectDTO getProjectById(Long id){
        return ProjectMapper.toProjectDTO(projectDAO.show(id));
    }

    @Transactional
    public ProjectDTO getProjectByName(String name){
        return ProjectMapper.toProjectDTO(projectDAO.showByName(name));
    }

    @Transactional
    public ProjectDTO createProject(ProjectDTO projectDTO){
        Project project = new Project();
        project.setName(projectDTO.getName());
        projectDAO.save(project);
        return projectDTO;
    }

    @Transactional
    public List<ProjectDTO> getAllProjects(){
        List<Project> projects = projectDAO.index();
        List<ProjectDTO> projectDTOS = new ArrayList<>();
        for ( Project project : projects) {
            projectDTOS.add(ProjectMapper.toProjectDTO(project));
        }
        return projectDTOS;
    }

    public void deleteProject(Long id){
        projectDAO.delete(id);
    }

}
