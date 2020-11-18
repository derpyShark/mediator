package kpi.trspo.port.api.controllers;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.MachineryTypeService;
import kpi.trspo.port.services.interfaces.PersonRoleService;
import kpi.trspo.port.services.model.MachineryType;
import kpi.trspo.port.services.model.Person;
import kpi.trspo.port.services.model.PersonRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RestController
@RequestMapping("api/personRoles")
public class PersonRoleController {
    private final PersonRoleService personRoleService;

    @Autowired
    public PersonRoleController(PersonRoleService personRoleService){
        this.personRoleService = personRoleService;
    }

    @GetMapping
    public List<PersonRole> getPersonRole(){ return personRoleService.getAll();}

    @GetMapping(path = "{id}")
    public PersonRole getPersonRoleById(@PathVariable("id") UUID id) throws NotFoundException
    {
        return personRoleService.getById(id);
    }

    @PostMapping
    public PersonRole addPersonRole(@RequestBody PersonRole addedPersonRole)
    {
        return personRoleService.create(addedPersonRole);
    }

    @PutMapping(path = "{id}")
    public void changePersonRole(@PathVariable("id") UUID id, @RequestBody PersonRole personRoleDetails)
            throws NotFoundException
    {
        personRoleService.update(id, personRoleDetails);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonRoleById(@PathVariable("id") UUID id) throws NotFoundException
    {
        personRoleService.delete(id);
    }
}
