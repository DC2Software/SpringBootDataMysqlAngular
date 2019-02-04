package pl.dc2software.spring.boot.data.mysql.angular.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.dc2software.spring.boot.data.mysql.angular.dto.SelectOptionDto;
import pl.dc2software.spring.boot.data.mysql.angular.service.SelectOptionsService;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class SelectOptionsController {

    Logger logger = LoggerFactory.getLogger(SelectOptionsController.class);

    @Autowired
    private SelectOptionsService selectOptionsService;

    @GetMapping("select/employees")
    public List<SelectOptionDto> findEmployeesOptions() {
        return selectOptionsService.findEmployeesOptions();
    }

    @GetMapping("select/locations")
    public List<SelectOptionDto> findLocationsOptions() {
        return selectOptionsService.findLocationsOptions();
    }

    @GetMapping("select/experience")
    public List<SelectOptionDto> findExperienceOptions() {
        return selectOptionsService.findExperienceOptions();
    }
}
