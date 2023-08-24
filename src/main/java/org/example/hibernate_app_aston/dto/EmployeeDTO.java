package org.example.hibernate_app_aston.dto;


import java.util.ArrayList;
import java.util.List;

public class EmployeeDTO {

    private String name;
    private String role;
    private List<String> projects = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
