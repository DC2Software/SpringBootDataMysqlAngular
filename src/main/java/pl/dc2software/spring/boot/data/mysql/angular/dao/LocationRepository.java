package pl.dc2software.spring.boot.data.mysql.angular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dc2software.spring.boot.data.mysql.angular.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
}
