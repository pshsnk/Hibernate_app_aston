package org.example.hibernate_app_aston.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class RoleDTO {
    private String name;
    private List<String> employees  = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getEmployees() {
        return employees;
    }

    public void setEmployees(List<String> employees) {
        this.employees = employees;
    }
}
