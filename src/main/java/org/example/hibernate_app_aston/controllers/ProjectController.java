package org.example.hibernate_app_aston.controllers;

import org.example.hibernate_app_aston.dto.ProjectDTO;
import org.example.hibernate_app_aston.services.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/project")
public class ProjectController {

    private final ProjectService projectService;

    @Autowired
    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<ProjectDTO> getProjectById(@PathVariable("projectId") String projectId) {

        return new ResponseEntity<>(projectService.getProjectById(Long.parseLong(projectId)), HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<ProjectDTO>> getAllProjects() {

        return new ResponseEntity<>(projectService.getAllProjects(), HttpStatus.OK);
    }

    @GetMapping("/name") // тут /name, потому что все url заняты
    public ResponseEntity<ProjectDTO> getProjectByName(@RequestBody ProjectDTO projectDTO) {

        return new ResponseEntity<>(projectService.getProjectByName(projectDTO.getName()), HttpStatus.OK);
    }
    @PostMapping("/")
    public ResponseEntity<ProjectDTO> createProject( @RequestBody ProjectDTO projectDTO){
        return new ResponseEntity<>(projectService.createProject(projectDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<?> deleteProject( @PathVariable("projectId") String projectId){
        projectService.deleteProject(Long.parseLong(projectId));
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
