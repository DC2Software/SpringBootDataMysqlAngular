package pl.dc2software.spring.boot.data.mysql.angular;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class SpringBootDataMysqlAngularApplication extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SpringBootDataMysqlAngularApplication.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringBootDataMysqlAngularApplication.class, args);
    }
}
