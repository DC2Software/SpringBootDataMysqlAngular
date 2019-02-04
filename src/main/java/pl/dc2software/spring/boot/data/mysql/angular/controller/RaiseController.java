package pl.dc2software.spring.boot.data.mysql.angular.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dc2software.spring.boot.data.mysql.angular.dto.employee.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;
import pl.dc2software.spring.boot.data.mysql.angular.service.RaiseService;

import java.util.List;

@RestController
public class RaiseController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private RaiseService raiseService;

    @PostMapping("employees/{id}/raise/{amount}")
    @CrossOrigin(origins = "http://localhost:4200")
    public EmployeeDto giveEmployeeRaise(@PathVariable("id") Long employeeId, @PathVariable("amount") Float amount)
            throws ServiceException {
        return raiseService.giveEmployeeRaise(employeeId, amount);
    }

    @PostMapping("locations/{id}/raise/{amount}")
    @CrossOrigin(origins = "http://localhost:4200")
    public List<EmployeeDto> giveRaise(@PathVariable("id") Long locationId, @PathVariable("amount") Float amount)
            throws ServiceException {
        return raiseService.giveLocationRaise(locationId, amount);
    }
}
