package kpi.trspo.port.api.controllers;


import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.HandlingRequestService;
import kpi.trspo.port.services.interfaces.MachineryService;
import kpi.trspo.port.services.model.HandlingRequest;
import kpi.trspo.port.services.model.Machinery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("api/handlingRequests")
public class HandlingRequestController {
    private final HandlingRequestService handlingRequestService;

    @Autowired
    public HandlingRequestController(HandlingRequestService handlingRequestService){
        this.handlingRequestService = handlingRequestService;
    }

    @GetMapping
    public List<HandlingRequest> getHandlingRequest(){ return handlingRequestService.getAll();}

    @GetMapping(path = "{id}")
    public HandlingRequest getHandlingRequestById(@PathVariable("id") UUID id) throws NotFoundException
    {
        return handlingRequestService.getById(id);
    }

    @PostMapping
    public HandlingRequest addHandlingRequest(@RequestBody HandlingRequest addedHandlingRequest)
    {
        return handlingRequestService.create(addedHandlingRequest);
    }

    @PutMapping(path = "{id}")
    public void changeHandlingRequest(@PathVariable("id") UUID id, @RequestBody HandlingRequest handlingRequestDetails)
            throws NotFoundException
    {
        handlingRequestService.update(id, handlingRequestDetails);
    }

    @DeleteMapping(path = "{id}")
    public void deleteHandlingRequestById(@PathVariable("id") UUID id) throws NotFoundException
    {
        handlingRequestService.delete(id);
    }
}
