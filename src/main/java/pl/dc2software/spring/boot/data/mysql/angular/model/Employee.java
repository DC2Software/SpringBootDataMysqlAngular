package pl.dc2software.spring.boot.data.mysql.angular.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import java.util.Date;

@Entity
@DiscriminatorColumn(
        discriminatorType = DiscriminatorType.STRING,
        length = 3
)
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 30)
    @Length(min = 1, max = 30)
    private String name;

    @Column(nullable = false)
    @Range(min = 1, max = 120)
    private Integer age;

    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date hiringDate;

    @Column(nullable = false)
    @Email
    private String email;

    @Column
    @Pattern(regexp = "^\\d{8,12}$", message = "Only 8-12 digits are allowed in a phone number.")
    private String phoneNr;

    @Column(nullable = false)
    private Float salary;

    @Column(length = 300)
    @Length(max = 300)
    private String description;

    @ManyToOne
    @JoinColumn(name = "locationId", referencedColumnName = "id", nullable = false)
    private Location location;

    @ManyToOne
    @JoinColumn(name = "supervisorId", referencedColumnName = "id")
    private Manager supervisor;
}
