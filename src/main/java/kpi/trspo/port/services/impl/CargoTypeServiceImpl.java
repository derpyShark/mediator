package kpi.trspo.port.services.impl;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.CargoTypeService;
import kpi.trspo.port.services.model.CargoType;
import kpi.trspo.port.services.model.MachineryType;
import kpi.trspo.port.services.repository.CargoTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;


@Service
@AllArgsConstructor
public class CargoTypeServiceImpl implements CargoTypeService {

    RestTemplate restTemplate = new RestTemplate();

    final String URL = "http://localhost:8081/api/cargoTypes";

    public void delete(UUID id)
    {
        String workingURL = URL + "/" + id;
        restTemplate.delete(workingURL);
    }

    public CargoType create(CargoType addedCargoType){
        HttpEntity<CargoType> request = new HttpEntity<>(addedCargoType);
        return restTemplate.postForObject(URL,request,CargoType.class);
    }

    public List<CargoType> getAll(){
        Optional<CargoType[]> cargoTypesMaybe = Optional.ofNullable(
                restTemplate.getForObject(URL, CargoType[].class));
        List<CargoType> cargoTypes = new ArrayList<>();
        if(cargoTypesMaybe.isPresent()){
            cargoTypes = Arrays.asList(cargoTypesMaybe.get());
        }
        return cargoTypes;
    }

    public CargoType getById(UUID cargoTypeId){
        String workingURL = URL + "/" + cargoTypeId;
        return restTemplate.getForObject(workingURL, CargoType.class);
    }


    public CargoType update(UUID cargoTypeId, CargoType cargoTypeObject){
        String workingURL = URL + "/" + cargoTypeId;
        restTemplate.put(workingURL,cargoTypeObject);
        return getById(cargoTypeId);
    }

}
