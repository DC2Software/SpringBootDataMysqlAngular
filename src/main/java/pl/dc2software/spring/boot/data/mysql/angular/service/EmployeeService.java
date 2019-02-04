package pl.dc2software.spring.boot.data.mysql.angular.service;

import pl.dc2software.spring.boot.data.mysql.angular.dto.employee.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(final EmployeeDto employeeDto);

    void delete(final Long employeeId) throws ServiceException;

    EmployeeDto findById(final Long id, final boolean returnNull) throws ServiceException;

    List<EmployeeDto> findByLocation(final Long locationId) throws ServiceException;

    List<EmployeeDto> findAll();
}
