package kpi.trspo.port.services.interfaces;

import javassist.NotFoundException;
import kpi.trspo.port.services.model.Machinery;
import kpi.trspo.port.services.model.MachineryType;

import java.util.List;
import java.util.UUID;

public interface MachineryService {
    List<Machinery> getAll();
    Machinery getById(UUID machineryId) throws NotFoundException;
    Machinery create(Machinery machineryObject);
    Machinery update(UUID machineryId, Machinery machineryDetails) throws NotFoundException;
    void delete(UUID machineryId) throws NotFoundException;
}
