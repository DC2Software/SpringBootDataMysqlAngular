package pl.dc2software.spring.boot.data.mysql.angular.service;

import pl.dc2software.spring.boot.data.mysql.angular.dto.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;

import java.util.List;

public interface EmployeeService {

    EmployeeDto save(final EmployeeDto employeeDto);

    void delete(final EmployeeDto employeeDto);

    EmployeeDto findById(final Long id, final boolean returnNull) throws ServiceException;

    List<EmployeeDto> findAll();
}
