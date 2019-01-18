package pl.dc2software.spring.boot.data.mysql.angular.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("SWD")
@Getter
@Setter
public class SoftwareDeveloper extends Employee {

    @NotEmpty
    private String technology;

    @NotNull
    @Enumerated(EnumType.STRING)
    private ExperienceLevel experienceLevel;
}
