package pl.dc2software.spring.boot.data.mysql.angular.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Getter
@Setter
@EqualsAndHashCode
public class EmployeeDto {

    private Long id;

    @NotNull
    @Length(min = 1, max = 30)
    private String name;

    @NotNull
    @Range(min = 1, max = 120)
    private Integer age;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date hiringDate;

    @NotNull
    @Email
    private String email;

    @Pattern(regexp = "^\\d{8,12}$", message = "Only 8-12 digits are allowed in a phone number.")
    private String phoneNr;

    @NotNull
    private Float salary;

    @NotNull
    @Length(max = 300)
    private String description;

    @NotNull
    private Long locationId;

    private Long supervisorId;
}
