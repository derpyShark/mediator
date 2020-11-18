package kpi.trspo.port.services.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.persistence.*;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonRole {
    
    private UUID roleId;
    private String roleName;

}
