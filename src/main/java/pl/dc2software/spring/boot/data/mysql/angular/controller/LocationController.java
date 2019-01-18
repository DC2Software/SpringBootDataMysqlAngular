package pl.dc2software.spring.boot.data.mysql.angular.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import pl.dc2software.spring.boot.data.mysql.angular.dto.LocationDto;
import pl.dc2software.spring.boot.data.mysql.angular.service.LocationService;

import javax.validation.Valid;
import java.util.List;

@RestController
public class LocationController {

    @Autowired
    private LocationService locationService;

    @PostMapping("location/save")
    @CrossOrigin(origins = "http://localhost:4200")
    public LocationDto save(@Valid LocationDto locationDto) {
        return locationService.save(locationDto);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public List<FieldError> processLocationValidationErrors(BindException ex) {
        BindingResult result = ex.getBindingResult();
        return result.getFieldErrors();
    }

}
