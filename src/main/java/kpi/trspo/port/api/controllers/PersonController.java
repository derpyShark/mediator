package kpi.trspo.port.api.controllers;


import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.PersonRoleService;
import kpi.trspo.port.services.interfaces.PersonService;
import kpi.trspo.port.services.model.Person;
import kpi.trspo.port.services.model.PersonRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/persons")
public class PersonController {
    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService){
        this.personService = personService;
    }

    @GetMapping
    public List<Person> getPerson(){ return personService.getAll();}

    @GetMapping(path = "{id}")
    public Person getPersonById(@PathVariable("id") UUID id) throws NotFoundException
    {
        return personService.getById(id);
    }

    @PostMapping
    public Person addPerson(@RequestBody Person addedPerson)
    {
        return personService.create(addedPerson);
    }

    @PutMapping(path = "{id}")
    public void changePerson(@PathVariable("id") UUID id, @RequestBody Person personDetails)
            throws NotFoundException
    {
        personService.update(id, personDetails);
    }

    @DeleteMapping(path = "{id}")
    public void deletePersonById(@PathVariable("id") UUID id) throws NotFoundException
    {
        personService.delete(id);
    }
}
