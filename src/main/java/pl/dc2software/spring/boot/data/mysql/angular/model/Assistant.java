package pl.dc2software.spring.boot.data.mysql.angular.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("ASS")
public class Assistant extends Employee {
}
