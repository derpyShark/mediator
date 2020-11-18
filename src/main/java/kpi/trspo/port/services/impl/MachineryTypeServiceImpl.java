package kpi.trspo.port.services.impl;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.MachineryTypeService;
import kpi.trspo.port.services.model.CargoType;
import kpi.trspo.port.services.model.MachineryType;
import kpi.trspo.port.services.model.PersonRole;
import kpi.trspo.port.services.repository.CargoTypeRepository;
import kpi.trspo.port.services.repository.MachineryTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class MachineryTypeServiceImpl implements MachineryTypeService {
    RestTemplate restTemplate = new RestTemplate();

    final String URL = "http://localhost:8083/api/machineryTypes";

    public void delete(UUID id)
    {
        String workingURL = URL + "/" + id;
        restTemplate.delete(workingURL);
    }

    public MachineryType create(MachineryType addedMachineryType){
        HttpEntity<MachineryType> request = new HttpEntity<>(addedMachineryType);
        return restTemplate.postForObject(URL,request,MachineryType.class);
    }

    public List<MachineryType> getAll(){
        Optional<MachineryType[]> machineryTypesMaybe = Optional.ofNullable(
                restTemplate.getForObject(URL, MachineryType[].class));
        List<MachineryType> machineryTypes = new ArrayList<>();
        if(machineryTypesMaybe.isPresent()){
            machineryTypes = Arrays.asList(machineryTypesMaybe.get());
        }
        return machineryTypes;
    }

    public MachineryType getById(UUID machineryTypeId){
        String workingURL = URL + "/" + machineryTypeId;
        return restTemplate.getForObject(workingURL, MachineryType.class);
    }

    public MachineryType update(UUID machineryTypeId, MachineryType machineryTypeObject){
        String workingURL = URL + "/" + machineryTypeId;
        restTemplate.put(workingURL,machineryTypeObject);
        return getById(machineryTypeId);
    }

}
