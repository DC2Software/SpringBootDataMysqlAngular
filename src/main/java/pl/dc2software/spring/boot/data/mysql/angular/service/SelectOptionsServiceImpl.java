package pl.dc2software.spring.boot.data.mysql.angular.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dc2software.spring.boot.data.mysql.angular.dao.EmployeeRepository;
import pl.dc2software.spring.boot.data.mysql.angular.dao.LocationRepository;
import pl.dc2software.spring.boot.data.mysql.angular.dto.SelectOptionDto;
import pl.dc2software.spring.boot.data.mysql.angular.model.ExperienceLevel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class SelectOptionsServiceImpl implements SelectOptionsService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private LocationRepository locationRepository;

    @Override
    public List<SelectOptionDto> findEmployeesOptions() {
        return employeeRepository.findAllSelectOptions();
    }

    @Override
    public List<SelectOptionDto> findLocationsOptions() {
        return locationRepository.findAllSelectOptions();
    }

    @Override
    public List<SelectOptionDto> findExperienceOptions() {
        return Arrays.stream(ExperienceLevel.values())
                .map((experienceLevel) -> new SelectOptionDto(String.valueOf(experienceLevel.ordinal()), experienceLevel.name()))
                .collect(Collectors.toList());
    }
}
