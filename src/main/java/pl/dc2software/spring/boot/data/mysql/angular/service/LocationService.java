package pl.dc2software.spring.boot.data.mysql.angular.service;

import pl.dc2software.spring.boot.data.mysql.angular.dto.LocationDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;

import java.util.List;

public interface LocationService {

    LocationDto save(final LocationDto locationDto);

    void delete(final LocationDto locationDto);

    LocationDto findById(final Long id, final boolean returnNull) throws ServiceException;

    List<LocationDto> findAll();

    List<LocationDto> findUnmanagedLocations();
}
