package kpi.trspo.port.services.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;

import javax.crypto.Mac;
import javax.persistence.*;
import java.util.UUID;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class HandlingRequest {


    private UUID handlingRequestId;

    private CargoContainer containerToHandle;

    private Machinery giverMachinery;

    private Machinery receiverMachinery;




}
