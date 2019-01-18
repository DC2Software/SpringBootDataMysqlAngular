package pl.dc2software.spring.boot.data.mysql.angular.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.Set;

@Entity
@DiscriminatorValue("MNG")
@Getter
@Setter
public class Manager extends Employee {

    @Column(nullable = false, columnDefinition = "bit(1) default 0")
    private boolean locationSupervisor;

    @OneToMany(mappedBy = "supervisor")
    private Set<Employee> subordinates;
}
