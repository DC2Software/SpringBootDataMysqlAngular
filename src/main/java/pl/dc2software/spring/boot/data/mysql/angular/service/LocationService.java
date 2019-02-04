package pl.dc2software.spring.boot.data.mysql.angular.service;

import pl.dc2software.spring.boot.data.mysql.angular.dto.location.LocationDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;

import java.util.List;

public interface LocationService {

    LocationDto save(final LocationDto locationDto);

    void delete(final Long locationId) throws ServiceException;

    LocationDto findById(final Long id, final boolean returnNull) throws ServiceException;

    List<LocationDto> findAll();

    List<LocationDto> findUnmanagedLocations();
}
