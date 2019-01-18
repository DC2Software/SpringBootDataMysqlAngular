package pl.dc2software.spring.boot.data.mysql.angular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dc2software.spring.boot.data.mysql.angular.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
