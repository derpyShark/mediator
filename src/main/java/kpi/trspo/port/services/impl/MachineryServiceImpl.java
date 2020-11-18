package kpi.trspo.port.services.impl;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.MachineryService;
import kpi.trspo.port.services.model.Machinery;
import kpi.trspo.port.services.model.MachineryType;
import kpi.trspo.port.services.repository.MachineryRepository;
import kpi.trspo.port.services.repository.MachineryTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class MachineryServiceImpl implements MachineryService {
    RestTemplate restTemplate = new RestTemplate();

    final String URL = "http://localhost:8085/api/machinery";

    public void delete(UUID id)
    {
        String workingURL = URL + "/" + id;
        restTemplate.delete(workingURL);
    }

    public Machinery create(Machinery addedMachinery){
        HttpEntity<Machinery> request = new HttpEntity<>(addedMachinery);
        return restTemplate.postForObject(URL,request,Machinery.class);
    }

    public List<Machinery> getAll(){
        Optional<Machinery[]> machineryMaybe = Optional.ofNullable(
                restTemplate.getForObject(URL, Machinery[].class));
        List<Machinery> machinery = new ArrayList<>();
        if(machineryMaybe.isPresent()){
            machinery = Arrays.asList(machineryMaybe.get());
        }
        return machinery;
    }

    public Machinery getById(UUID machineryId){
        String workingURL = URL + "/" + machineryId;
        return restTemplate.getForObject(workingURL, Machinery.class);
    }


    public Machinery update(UUID machineryId, Machinery machineryObject){
        String workingURL = URL + "/" + machineryId;
        restTemplate.put(workingURL,machineryObject);
        return getById(machineryId);
    }
}
