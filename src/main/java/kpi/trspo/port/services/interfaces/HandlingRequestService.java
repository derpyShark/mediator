package kpi.trspo.port.services.interfaces;

import javassist.NotFoundException;
import kpi.trspo.port.services.model.CargoType;
import kpi.trspo.port.services.model.HandlingRequest;

import java.util.List;
import java.util.UUID;

public interface HandlingRequestService {
    List<HandlingRequest> getAll();
    HandlingRequest getById(UUID handlingRequestId) throws NotFoundException;
    HandlingRequest create(HandlingRequest handlingRequestObject);
    HandlingRequest update(UUID handlingRequestId, HandlingRequest handlingRequestDetails) throws NotFoundException;
    void delete(UUID handlingRequestId) throws NotFoundException;
}
