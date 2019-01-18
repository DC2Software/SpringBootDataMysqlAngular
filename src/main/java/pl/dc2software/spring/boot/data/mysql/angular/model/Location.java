package pl.dc2software.spring.boot.data.mysql.angular.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Getter
@Setter
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false)
    @NotEmpty
    private String name;

    @Column(nullable = false)
    @NotEmpty
    @Pattern(regexp = "^[A-Z]{3}$", message = "Location code must consist of 3 capital letters.")
    private String code;

    @OneToMany(mappedBy = "location")
    private Set<Employee> employees;

    @Column(length = 150)
    @Length(max = 150)
    private String description;
}
