package pl.dc2software.spring.boot.data.mysql.angular.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.dc2software.spring.boot.data.mysql.angular.dto.employee.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;
import pl.dc2software.spring.boot.data.mysql.angular.service.EmployeeService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class EmployeeController {

    private Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("employees")
    public List<EmployeeDto> findAll() {
        logger.info("Entering the employee findAll method.");
        return employeeService.findAll();
    }

    @GetMapping("employees/{id}")
    public EmployeeDto find(@PathVariable("id") Long id) throws ServiceException {
        logger.info("Entering the employee findById method with id = " + id);
        return employeeService.findById(id, true);
    }

    @PostMapping("employees")
    public EmployeeDto save(@Valid @RequestBody EmployeeDto employeeDto) {
        logger.info("Entering the employee save method with employeeDto = " + employeeDto.toString());
        return employeeService.save(employeeDto);
    }

    @DeleteMapping("employees/{id}")
    public void delete(@PathVariable("id") Long id) throws ServiceException {
        employeeService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<FieldError> processLocationValidationErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors();
    }
}
