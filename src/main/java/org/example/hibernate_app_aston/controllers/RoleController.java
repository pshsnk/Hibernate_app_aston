package org.example.hibernate_app_aston.controllers;

import org.example.hibernate_app_aston.dto.RoleDTO;
import org.example.hibernate_app_aston.services.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/role")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable("roleId") String roleId) {

        return new ResponseEntity<>(roleService.getRoleById(Long.parseLong(roleId)), HttpStatus.OK);
    }


    @GetMapping("/")
    public ResponseEntity<List<RoleDTO>> getAllRoles() {

        return new ResponseEntity<>(roleService.getAllRoles(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<RoleDTO> createRole( @RequestBody RoleDTO roleDTO){
        return new ResponseEntity<>(roleService.createRole(roleDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<?> deleteRole( @PathVariable("roleId") String roleId){
        roleService.deleteRole(Long.parseLong(roleId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
