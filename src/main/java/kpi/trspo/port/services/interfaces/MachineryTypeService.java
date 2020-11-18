package kpi.trspo.port.services.interfaces;

import javassist.NotFoundException;
import kpi.trspo.port.services.model.CargoType;
import kpi.trspo.port.services.model.Machinery;
import kpi.trspo.port.services.model.MachineryType;
import kpi.trspo.port.services.model.PersonRole;

import java.util.List;
import java.util.UUID;

public interface MachineryTypeService {
    List<MachineryType> getAll();
    MachineryType getById(UUID machineryTypeId) throws NotFoundException;
    MachineryType create(MachineryType machineryTypeObject);
    MachineryType update(UUID machineryTypeId, MachineryType machineryTypeDetails) throws NotFoundException;
    void delete(UUID machineryTypeId) throws NotFoundException;
}
