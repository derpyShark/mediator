package kpi.trspo.port.services.impl;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.PersonService;
import kpi.trspo.port.services.model.Person;
import kpi.trspo.port.services.model.PersonRole;
import kpi.trspo.port.services.repository.PersonRepository;
import kpi.trspo.port.services.repository.PersonRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService {
    RestTemplate restTemplate = new RestTemplate();

    final String URL = "http://localhost:8084/api/persons";

    public void delete(UUID id)
    {
        String workingURL = URL + "/" + id;
        restTemplate.delete(workingURL);
    }

    public Person create(Person addedPerson){
        HttpEntity<Person> request = new HttpEntity<>(addedPerson);
        return restTemplate.postForObject(URL,request,Person.class);
    }

    public List<Person> getAll(){
        Optional<Person[]> personsMaybe = Optional.ofNullable(
                restTemplate.getForObject(URL, Person[].class));
        List<Person> persons = new ArrayList<>();
        if(personsMaybe.isPresent()){
            persons = Arrays.asList(personsMaybe.get());
        }
        return persons;
    }

    public Person getById(UUID personId){
        String workingURL = URL + "/" + personId;
        return restTemplate.getForObject(workingURL, Person.class);
    }

    public Person update(UUID personId, Person personObject){
        String workingURL = URL + "/" + personId;
        restTemplate.put(workingURL,personObject);
        return getById(personId);
    }
}
