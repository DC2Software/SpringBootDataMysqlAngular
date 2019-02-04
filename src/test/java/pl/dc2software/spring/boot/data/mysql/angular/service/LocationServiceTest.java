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
import pl.dc2software.spring.boot.data.mysql.angular.dao.LocationRepository;
import pl.dc2software.spring.boot.data.mysql.angular.dto.location.LocationDto;
import pl.dc2software.spring.boot.data.mysql.angular.model.Location;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class LocationServiceTest {

    @Mock
    private LocationRepository repoMock;

    @Mock
    private ModelMapper mapperMock;

    @InjectMocks
    private LocationServiceImpl employeeService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddEmployee_success() throws Exception {
        when(repoMock.save(any(Location.class))).thenReturn(new Location());
        when(mapperMock.map(any(LocationDto.class), eq(Location.class))).thenReturn(new Location());
        when(mapperMock.map(any(Location.class), eq(LocationDto.class))).thenReturn(new LocationDto());

        Assert.assertEquals(new LocationDto(), employeeService.save(new LocationDto()));
    }
}
