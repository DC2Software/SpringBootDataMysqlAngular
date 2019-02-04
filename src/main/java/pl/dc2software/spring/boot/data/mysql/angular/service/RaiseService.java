package pl.dc2software.spring.boot.data.mysql.angular.service;

import pl.dc2software.spring.boot.data.mysql.angular.dto.employee.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;

import java.util.List;

public interface RaiseService {

    EmployeeDto giveEmployeeRaise(Long employeeId, Float raiseAmount) throws ServiceException;

    List<EmployeeDto> giveLocationRaise(Long locationId, Float raiseAmount) throws ServiceException;

}
