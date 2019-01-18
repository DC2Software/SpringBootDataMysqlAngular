package pl.dc2software.spring.boot.data.mysql.angular.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
public class LocationDto {

    private Long id;

    @NotEmpty
    private String name;

    @NotEmpty
    @Pattern(regexp = "^[A-Z]{3}$", message = "Location code must consist of 3 capital letters.")
    private String code;

    private Set<Long> employeeIds;

    @Length(max = 150)
    private String description;
}
