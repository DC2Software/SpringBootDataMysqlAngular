package pl.dc2software.spring.boot.data.mysql.angular.dto.employee;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
public class ManagerDto extends EmployeeDto {

    @NotNull
    private boolean locationSupervisor;

    private Set<Long> subordinatesIds;
}
