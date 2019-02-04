package pl.dc2software.spring.boot.data.mysql.angular.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.modelmapper.ModelMapper;
import org.springframework.test.context.junit4.SpringRunner;
import pl.dc2software.spring.boot.data.mysql.angular.dao.EmployeeRepository;
import pl.dc2software.spring.boot.data.mysql.angular.dto.employee.EmployeeDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;
import pl.dc2software.spring.boot.data.mysql.angular.model.Employee;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class EmployeeServiceTest {

    @Mock
    private EmployeeRepository repoMock;

    @Mock
    private ModelMapper mapperMock;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddEmployee_success() throws Exception {
        when(repoMock.save(any(Employee.class))).thenReturn(new Employee());
        when(mapperMock.map(any(EmployeeDto.class), eq(Employee.class))).thenReturn(new Employee());
        when(mapperMock.map(any(Employee.class), eq(EmployeeDto.class))).thenReturn(new EmployeeDto());

        Assert.assertEquals(new EmployeeDto(), employeeService.save(new EmployeeDto()));
    }

    @Test
    public void testFindById_returnsEmployee() throws Exception {
        when(repoMock.findById(any(Long.class))).thenReturn(Optional.of(new Employee()));
        when(mapperMock.map(any(Employee.class), eq(EmployeeDto.class))).thenReturn(new EmployeeDto());

        Assert.assertEquals(new EmployeeDto(), employeeService.findById(1L, true));
    }

    @Test(expected = ServiceException.class)
    public void testFindById_throwsServiceException() throws Exception {
        when(repoMock.findById(any(Long.class))).thenReturn(Optional.empty());
        when(mapperMock.map(any(Employee.class), eq(EmployeeDto.class))).thenReturn(new EmployeeDto());

        employeeService.findById(0L, false);
    }

    @Test
    public void testFindById_returnNull() throws Exception {
        when(repoMock.findById(any(Long.class))).thenReturn(Optional.empty());
        when(mapperMock.map(any(Employee.class), eq(EmployeeDto.class))).thenReturn(new EmployeeDto());

        employeeService.findById(0L, true);
    }
}
