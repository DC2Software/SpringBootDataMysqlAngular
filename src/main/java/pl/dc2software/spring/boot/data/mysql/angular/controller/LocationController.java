package pl.dc2software.spring.boot.data.mysql.angular.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import pl.dc2software.spring.boot.data.mysql.angular.dto.location.LocationDto;
import pl.dc2software.spring.boot.data.mysql.angular.exception.ServiceException;
import pl.dc2software.spring.boot.data.mysql.angular.service.LocationService;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class LocationController {

    Logger logger = LoggerFactory.getLogger(LocationController.class);

    @Autowired
    private LocationService locationService;

    @GetMapping("locations")
    public List<LocationDto> findAll() {
        return locationService.findAll();
    }

    @GetMapping("locations/{id}")
    public LocationDto findById(@PathVariable("id") Long id) throws ServiceException {
        return locationService.findById(id, false);
    }

    @PostMapping("locations")
    public LocationDto save(@Valid @RequestBody LocationDto locationDto) {
        return locationService.save(locationDto);
    }

    @DeleteMapping("locations/{id}")
    public void delete(@PathVariable("id") Long id) throws ServiceException {
        locationService.delete(id);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public List<FieldError> processLocationValidationErrors(MethodArgumentNotValidException ex) {
        return ex.getBindingResult().getFieldErrors();
    }

}
