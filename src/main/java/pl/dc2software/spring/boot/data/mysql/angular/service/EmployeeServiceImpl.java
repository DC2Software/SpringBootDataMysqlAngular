package pl.dc2software.spring.boot.data.mysql.angular.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dc2software.spring.boot.data.mysql.angular.dao.EmployeeRepository;
import pl.dc2software.spring.boot.data.mysql.angular.dto.employee.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;
import pl.dc2software.spring.boot.data.mysql.angular.model.Employee;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public EmployeeDto save(final EmployeeDto employeeDto) {
        return modelMapper.map(employeeRepository.save(modelMapper.map(employeeDto, Employee.class)),
                EmployeeDto.class);
    }

    @Override
    public void delete(final Long employeeId) throws ServiceException {
        employeeRepository.delete(employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ServiceException("No employee with ID: " + employeeId + " found.")));
    }

    @Override
    public EmployeeDto findById(final Long id, final boolean returnNull) throws ServiceException {
        if (returnNull) {
            Employee foundEmployee = employeeRepository.findById(id).orElse(null);
            return foundEmployee == null ? null : modelMapper.map(foundEmployee, EmployeeDto.class);
        }
        return modelMapper.map(employeeRepository.findById(id)
                .orElseThrow(() -> new ServiceException("No employee with ID: " + id + " found.")), EmployeeDto.class);
    }

    @Override
    public List<EmployeeDto> findByLocation(Long locationId) throws ServiceException {
        return employeeRepository.findByLocation(locationId).stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<EmployeeDto> findAll() {
        return employeeRepository.findAll().stream()
                .map(employee -> modelMapper.map(employee, EmployeeDto.class))
                .collect(Collectors.toList());
    }
}
