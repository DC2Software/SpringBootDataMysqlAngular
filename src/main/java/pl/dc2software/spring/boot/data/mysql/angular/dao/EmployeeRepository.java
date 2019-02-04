package pl.dc2software.spring.boot.data.mysql.angular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.dc2software.spring.boot.data.mysql.angular.dto.SelectOptionDto;
import pl.dc2software.spring.boot.data.mysql.angular.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT e FROM Employee e where e.location.id = :locationId")
    List<Employee> findByLocation(@Param("locationId") Long locationId);

    @Query("SELECT new pl.dc2software.spring.boot.data.mysql.angular.dto.SelectOptionDto(cast(e.id as string), e.name) FROM Employee e")
    List<SelectOptionDto> findAllSelectOptions();
}
