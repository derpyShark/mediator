package kpi.trspo.port.services.impl;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.CargoContainerService;
import kpi.trspo.port.services.model.CargoContainer;
import kpi.trspo.port.services.model.CargoType;
import kpi.trspo.port.services.repository.CargoContainerRepository;
import kpi.trspo.port.services.repository.CargoTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class CargoContainerServiceImpl implements CargoContainerService {

    RestTemplate restTemplate = new RestTemplate();

    final private String URL = "http://localhost:8086/api/cargoContainers";


    public void delete(UUID id)
    {
        String workingURL = URL + "/" + id;
        restTemplate.delete(workingURL);
    }

    public CargoContainer create(CargoContainer addedCargoContainer){
        HttpEntity<CargoContainer> request = new HttpEntity<>(addedCargoContainer);
        return restTemplate.postForObject(URL,request,CargoContainer.class);
    }

    public List<CargoContainer> getAll(){
        Optional<CargoContainer[]> cargoContainersMaybe = Optional.ofNullable(
                restTemplate.getForObject(URL, CargoContainer[].class));
        List<CargoContainer> cargoContainers = new ArrayList<>();
        if(cargoContainersMaybe.isPresent()){
            cargoContainers = Arrays.asList(cargoContainersMaybe.get());
        }
        return cargoContainers;
    }

    public CargoContainer getById(UUID cargoContainerId){
        String workingURL = URL + "/" + cargoContainerId;
        return restTemplate.getForObject(workingURL, CargoContainer.class);
    }


    public CargoContainer update(UUID cargoContainerId, CargoContainer cargoContainerObject){
        String workingURL = URL + "/" + cargoContainerId;
        restTemplate.put(workingURL,cargoContainerObject);
        return getById(cargoContainerId);
    }
}
