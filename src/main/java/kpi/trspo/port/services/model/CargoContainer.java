package kpi.trspo.port.services.model;


import javax.persistence.*;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoContainer {

    private UUID containerId;

    private float cargoWeight;

    private CargoType cargoType;

    private Machinery machineryWithContainer;

}
