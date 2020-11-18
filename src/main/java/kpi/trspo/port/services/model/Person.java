package kpi.trspo.port.services.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Person {

    private UUID driverId;
    private String name;
    private String surname;
    private Date dateOfBirth;
    private PersonRole role;
}
