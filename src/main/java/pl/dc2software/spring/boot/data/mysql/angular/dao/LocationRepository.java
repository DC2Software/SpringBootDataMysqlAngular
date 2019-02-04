package pl.dc2software.spring.boot.data.mysql.angular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.dc2software.spring.boot.data.mysql.angular.dto.SelectOptionDto;
import pl.dc2software.spring.boot.data.mysql.angular.model.Location;

import java.util.List;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {

    @Query("SELECT new pl.dc2software.spring.boot.data.mysql.angular.dto.SelectOptionDto(cast(l.id as string), l.name) FROM Location l")
    List<SelectOptionDto> findAllSelectOptions();
}
