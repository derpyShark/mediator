package kpi.trspo.port.services.interfaces;

import javassist.NotFoundException;
import kpi.trspo.port.services.model.Person;
import kpi.trspo.port.services.model.PersonRole;

import java.util.List;
import java.util.UUID;

public interface PersonService {
    List<Person> getAll();
    Person getById(UUID personId) throws NotFoundException;
    Person create(Person personObject);
    Person update(UUID personId, Person personDetails) throws NotFoundException;
    void delete(UUID personId) throws NotFoundException;
}
