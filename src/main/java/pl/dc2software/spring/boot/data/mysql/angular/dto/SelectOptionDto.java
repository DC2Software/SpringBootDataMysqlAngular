package pl.dc2software.spring.boot.data.mysql.angular.dto;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode
@AllArgsConstructor
public class SelectOptionDto {

    private String value;
    private String viewValue;
}
