package pl.dc2software.spring.boot.data.mysql.angular.dto.employee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import pl.dc2software.spring.boot.data.mysql.angular.model.ExperienceLevel;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class SoftwareDeveloperDto extends EmployeeDto {

    @NotEmpty
    private String technology;

    @NotNull
    private ExperienceLevel experienceLevel;
}
