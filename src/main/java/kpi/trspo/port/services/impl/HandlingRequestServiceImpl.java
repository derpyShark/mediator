package kpi.trspo.port.services.impl;


import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.HandlingRequestService;
import kpi.trspo.port.services.model.HandlingRequest;
import kpi.trspo.port.services.model.Machinery;
import kpi.trspo.port.services.repository.HandlingRequestRepository;
import kpi.trspo.port.services.repository.MachineryRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;

@Service
@AllArgsConstructor
public class HandlingRequestServiceImpl implements HandlingRequestService {
    RestTemplate restTemplate = new RestTemplate();

    final String URL = "http://localhost:8087/api/handlingRequests";

    public void delete(UUID id)
    {
        String workingURL = URL + "/" + id;
        restTemplate.delete(workingURL);
    }

    public HandlingRequest create(HandlingRequest addedHandlingRequest){
        HttpEntity<HandlingRequest> request = new HttpEntity<>(addedHandlingRequest);
        return restTemplate.postForObject(URL,request,HandlingRequest.class);
    }

    public List<HandlingRequest> getAll(){
        Optional<HandlingRequest[]> handlingRequestsMaybe = Optional.ofNullable(
                restTemplate.getForObject(URL, HandlingRequest[].class));
        List<HandlingRequest> handlingRequests = new ArrayList<>();
        if(handlingRequestsMaybe.isPresent()){
            handlingRequests = Arrays.asList(handlingRequestsMaybe.get());
        }
        return handlingRequests;
    }

    public HandlingRequest getById(UUID handlingRequestId){
        String workingURL = URL + "/" + handlingRequestId;
        return restTemplate.getForObject(workingURL, HandlingRequest.class);
    }


    public HandlingRequest update(UUID handlingRequestId, HandlingRequest handlingRequestObject){
        String workingURL = URL + "/" + handlingRequestId;
        restTemplate.put(workingURL,handlingRequestObject);
        return getById(handlingRequestId);
    }
}
