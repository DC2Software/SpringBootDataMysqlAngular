package pl.dc2software.spring.boot.data.mysql.angular.dto.employee;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;
import org.springframework.format.annotation.DateTimeFormat;
import pl.dc2software.spring.boot.data.mysql.angular.util.LocalDateDeserializer;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
@EqualsAndHashCode
public class EmployeeDto {

    private Long id;

    @NotEmpty
    private String role;

    @NotEmpty
    @Length(min = 1, max = 30)
    private String name;

    @NotNull
    @Range(min = 1, max = 120)
    private Integer age;

    @NotNull
    @JsonDeserialize(using = LocalDateDeserializer.class)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate hiringDate;

    @NotEmpty
    @Email
    private String email;

    @Pattern(regexp = "^\\d{8,12}$", message = "Only 8-12 digits are allowed in a phone number.")
    private String phoneNr;

    @NotNull
    private Float salary;

    @NotEmpty
    @Length(max = 300)
    private String description;

    @NotNull
    private Long locationId;

    private Long supervisorId;
}
