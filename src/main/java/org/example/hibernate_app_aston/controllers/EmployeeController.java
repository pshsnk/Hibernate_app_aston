package org.example.hibernate_app_aston.controllers;


import org.example.hibernate_app_aston.dto.EmployeeDTO;
import org.example.hibernate_app_aston.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable("employeeId") String employeeId) {

        return new ResponseEntity<>(employeeService.getEmployeeById(Long.parseLong(employeeId)), HttpStatus.OK);
    }


    @GetMapping("/name") // тут /name, потому что все url заняты
    public ResponseEntity<EmployeeDTO> getEmployeeByName(@RequestBody EmployeeDTO employeeDTO) {

        return new ResponseEntity<>(employeeService.getEmployeeByName(employeeDTO.getName()), HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {

        return new ResponseEntity<>(employeeService.getAllEmployees(), HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return new ResponseEntity<>(employeeService.createEmployee(employeeDTO), HttpStatus.OK);
    }

    @DeleteMapping("/{employeeId}")
    public ResponseEntity<?> deleteEmployee( @PathVariable("employeeId") String employeeId){
        employeeService.deleteEmployee(Long.parseLong(employeeId));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/{employeeId}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@RequestBody EmployeeDTO employeeDTO,
                                                      @PathVariable("employeeId") String employeeId){
        return new ResponseEntity<>(employeeService.updateEmployee(Long.parseLong(employeeId), employeeDTO), HttpStatus.OK);
    }


}
