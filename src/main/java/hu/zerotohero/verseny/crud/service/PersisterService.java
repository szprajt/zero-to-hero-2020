package hu.zerotohero.verseny.crud.service;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.entity.Equipment;
import hu.zerotohero.verseny.crud.entity.Location;
import hu.zerotohero.verseny.crud.repository.EmployeeRepository;
import hu.zerotohero.verseny.crud.repository.EquipmentRepository;
import hu.zerotohero.verseny.crud.repository.LocationRepository;
import hu.zerotohero.verseny.crud.validator.Validatable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class PersisterService {

    @Autowired
    private LocationRepository locationRepository;
    @Autowired
    private EquipmentRepository equipmentRepository;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private List<Validatable> validators;

    public Location persistLocation(final Location location) {
        return locationRepository.save(location);
    }

    public Equipment persistEquipment(final Equipment equipment) {
        Optional<Location> location = locationRepository.findById(equipment.getLocatedAt().getId());
        if (location.isPresent()) {
            return equipmentRepository.save(equipment.setLocatedAt(location.get()));
        } else {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location not found based on the request");
        }
    }

    public Employee persistEmployee(final Employee employee) {
        Optional<Location> location = locationRepository.findById(employee.getWorksAt().getId());
        Optional<Equipment> equipment = Optional.ofNullable(employee.getOperates())
                .map(equipment1 -> equipmentRepository.findById(equipment1.getId()))
                .orElse(Optional.empty());
        if (!location.isPresent()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location not found based on the request");
        }
        employee.setWorksAt(location.get());
        if (equipment.isPresent()) {
            employee.setOperates(equipment.get());
        }
        validators.stream()
                .filter(validatable -> validatable.isValidatable(employee.getJob()))
                .forEach(validatable -> validatable.validate(employee));
        return employeeRepository.save(employee);
    }

    public void deleteLocation(final long id) {
        if (!locationRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Location not found");
        }
        locationRepository.deleteById(id);
    }

    public void deleteEquipment(final long id) {
        if (!equipmentRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Equipment not found");
        }
        equipmentRepository.deleteById(id);
    }

    public void deleteEmployee(final long id) {
        if (!employeeRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Employee not found");
        }
        employeeRepository.deleteById(id);
    }
}
