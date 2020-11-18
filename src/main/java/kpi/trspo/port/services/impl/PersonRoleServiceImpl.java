package kpi.trspo.port.services.impl;

import javassist.NotFoundException;
import kpi.trspo.port.services.interfaces.PersonRoleService;
import kpi.trspo.port.services.model.MachineryType;
import kpi.trspo.port.services.model.PersonRole;
import kpi.trspo.port.services.repository.MachineryTypeRepository;
import kpi.trspo.port.services.repository.PersonRoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;



@Service
@AllArgsConstructor
public class PersonRoleServiceImpl implements PersonRoleService {

    @Autowired
    private PersonRoleRepository personRoleRepository;

    @Override
    public List<PersonRole> getAll() {
        return personRoleRepository.findAll();
    }

    @Override
    public PersonRole getById(UUID personRoleId) throws NotFoundException {
        Optional<PersonRole> cargoTypeMaybe = personRoleRepository.findById(personRoleId);
        if(cargoTypeMaybe.isPresent()){
            return cargoTypeMaybe.get();
        }
        else
            throw new NotFoundException("No personRole with such an Id: " + personRoleId);
    }

    @Override
    public PersonRole create(PersonRole machineryTypeObject) {
        return personRoleRepository.save(machineryTypeObject);
    }

    @Override
    public PersonRole update(UUID roleId, PersonRole personRoleDetails) throws NotFoundException {
        PersonRole oldRole = getById(roleId);
        oldRole.setRoleName(personRoleDetails.getRoleName());
        return personRoleRepository.save(oldRole);
    }

    @Override
    public void delete(UUID machineryTypeId) throws NotFoundException{
        personRoleRepository.delete(getById(machineryTypeId));
    }
}
