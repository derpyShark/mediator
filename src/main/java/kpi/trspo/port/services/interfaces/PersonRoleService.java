package kpi.trspo.port.services.interfaces;

import javassist.NotFoundException;
import kpi.trspo.port.services.model.CargoType;
import kpi.trspo.port.services.model.Person;
import kpi.trspo.port.services.model.PersonRole;

import java.util.List;
import java.util.UUID;

public interface PersonRoleService {
    List<PersonRole> getAll();
    PersonRole getById(UUID roleId) throws NotFoundException;
    PersonRole create(PersonRole personRoleObject);
    PersonRole update(UUID roleId, PersonRole personRoleDetails) throws NotFoundException;
    void delete(UUID roleId) throws NotFoundException;
}
