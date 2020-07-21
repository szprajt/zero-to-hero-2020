package hu.zerotohero.verseny.crud.service;

import hu.zerotohero.verseny.crud.entity.Equipment;
import hu.zerotohero.verseny.crud.entity.Location;
import hu.zerotohero.verseny.crud.repository.EquipmentRepository;
import hu.zerotohero.verseny.crud.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class CrudService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;

    public Location persistLocation(final Location location) {
        return locationRepository.save(location);
    }

    public Equipment persistEquipment(final Equipment equipment) {
        Optional<Location> location = locationRepository.findById(equipment.getLocation().getId());
        if (location.isPresent()) {
            return equipmentRepository.save(equipment.setLocation(location.get()));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Not existing location was provided for the given request");
        }
    }
}
