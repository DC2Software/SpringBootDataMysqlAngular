package pl.dc2software.spring.boot.data.mysql.angular.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dc2software.spring.boot.data.mysql.angular.dao.LocationRepository;
import pl.dc2software.spring.boot.data.mysql.angular.dto.LocationDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;
import pl.dc2software.spring.boot.data.mysql.angular.model.Location;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    private LocationRepository locationRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public LocationDto save(@Valid LocationDto locationDto) {
        return modelMapper.map(locationRepository.save(modelMapper.map(locationDto, Location.class)),
                LocationDto.class);
    }

    @Override
    public void delete(LocationDto locationDto) {
        locationRepository.delete(modelMapper.map(locationDto, Location.class));
    }

    @Override
    public LocationDto findById(Long id, boolean returnNull) throws ServiceException {
        if (returnNull) {
            Location foundLocation = locationRepository.findById(id).orElse(null);
            return foundLocation == null ? null : modelMapper.map(foundLocation, LocationDto.class);
        }
        return modelMapper.map(locationRepository.findById(id)
                .orElseThrow(() -> new ServiceException("No location with ID: " + id + " found.")), LocationDto.class);
    }

    @Override
    public List<LocationDto> findAll() {
        return locationRepository.findAll().stream()
                .map(location -> modelMapper.map(location, LocationDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public List<LocationDto> findUnmanagedLocations() {
        return null;
    }
}
