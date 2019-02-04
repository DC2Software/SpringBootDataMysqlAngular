package pl.dc2software.spring.boot.data.mysql.angular.service;

import pl.dc2software.spring.boot.data.mysql.angular.dto.SelectOptionDto;

import java.util.List;

public interface SelectOptionsService {

    List<SelectOptionDto> findEmployeesOptions();

    List<SelectOptionDto> findLocationsOptions();

    List<SelectOptionDto> findExperienceOptions();
}
