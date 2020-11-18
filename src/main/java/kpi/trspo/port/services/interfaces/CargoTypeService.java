package kpi.trspo.port.services.interfaces;

import javassist.NotFoundException;
import kpi.trspo.port.services.model.CargoType;
import kpi.trspo.port.services.model.PersonRole;

import java.util.List;
import java.util.UUID;

public interface CargoTypeService {
    List<CargoType> getAll();
    CargoType getById(UUID cargoTypeId) throws NotFoundException;
    CargoType create(CargoType cargoTypeObject);
    CargoType update(UUID cargoTypeId, CargoType cargoTypeDetails) throws NotFoundException;
    void delete(UUID cargoTypeId) throws NotFoundException;
}
