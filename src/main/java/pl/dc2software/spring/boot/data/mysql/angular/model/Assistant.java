package pl.dc2software.spring.boot.data.mysql.angular.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("assistant")
public class Assistant extends Employee {
}
