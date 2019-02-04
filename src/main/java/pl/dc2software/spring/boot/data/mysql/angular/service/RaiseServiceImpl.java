package pl.dc2software.spring.boot.data.mysql.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dc2software.spring.boot.data.mysql.angular.dto.employee.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;

import java.util.ArrayList;
import java.util.List;

@Service
public class RaiseServiceImpl implements RaiseService {

    @Autowired
    private EmployeeService employeeService;

    @Override
    public EmployeeDto giveEmployeeRaise(Long employeeId, Float raiseAmount) throws ServiceException {
        EmployeeDto employeeDto = employeeService.findById(employeeId, false);
        employeeDto.setSalary(employeeDto.getSalary() + raiseAmount);
        return employeeService.save(employeeDto);
    }

    @Override
    public List<EmployeeDto> giveLocationRaise(Long locationId, Float raiseAmount) throws ServiceException {
        List<EmployeeDto> locationEmployees = employeeService.findByLocation(locationId);
        List<EmployeeDto> employeesWithRaise = new ArrayList<>();
        locationEmployees.forEach(employee -> {
            employee.setSalary(employee.getSalary() + raiseAmount);
            employeesWithRaise.add(employeeService.save(employee));
        });
        return employeesWithRaise;
    }
}
