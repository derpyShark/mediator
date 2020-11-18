package kpi.trspo.port;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class PortApplication {

    public static void main(String[] args) {
        SpringApplication.run(PortApplication.class, args);
    }

}
