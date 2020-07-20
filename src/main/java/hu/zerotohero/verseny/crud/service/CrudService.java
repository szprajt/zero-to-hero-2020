package hu.zerotohero.verseny.crud.service;

import hu.zerotohero.verseny.crud.entity.Equipment;
import hu.zerotohero.verseny.crud.entity.Location;
import hu.zerotohero.verseny.crud.repository.EquipmentRepository;
import hu.zerotohero.verseny.crud.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return equipmentRepository.save(equipment);
    }
}
