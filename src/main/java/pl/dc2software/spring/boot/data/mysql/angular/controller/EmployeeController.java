package pl.dc2software.spring.boot.data.mysql.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dc2software.spring.boot.data.mysql.angular.dto.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.service.EmployeeService;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employee/all")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<EmployeeDto> findAll() {
        return employeeService.findAll();
    }

    @PostMapping("employee/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public EmployeeDto save(EmployeeDto employeeDto) {
        return employeeService.save(employeeDto);
    }
}
