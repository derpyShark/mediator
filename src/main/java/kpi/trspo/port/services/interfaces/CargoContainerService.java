package kpi.trspo.port.services.interfaces;

import javassist.NotFoundException;
import kpi.trspo.port.services.model.CargoContainer;
import kpi.trspo.port.services.model.CargoType;

import java.util.List;
import java.util.UUID;

public interface CargoContainerService {
    List<CargoContainer> getAll();
    CargoContainer getById(UUID cargoContainerId) throws NotFoundException;
    CargoContainer create(CargoContainer cargoContainerObject);
    CargoContainer update(UUID cargoContainerId, CargoContainer cargoContainerDetails) throws NotFoundException;
    void delete(UUID cargoContainerId) throws NotFoundException;
}
