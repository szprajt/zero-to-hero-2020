package hu.zerotohero.verseny.crud;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.entity.Equipment;
import hu.zerotohero.verseny.crud.entity.Location;
import hu.zerotohero.verseny.crud.service.PersisterService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/crud")
public class CrudController {

    private static final Logger LOG = LoggerFactory.getLogger(CrudController.class);

    @Autowired
    private PersisterService persisterService;

    @PostMapping
    @RequestMapping(value = "/api/location/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Location persistLocation(@Valid @RequestBody final Location locationRequest) {
        LOG.info("New incoming location request: {}", locationRequest);
        return persisterService.persistLocation(locationRequest);
    }

    @PostMapping
    @RequestMapping(value = "/api/equipment/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Equipment persistEquipment(@Valid @RequestBody final Equipment equipment) {
        LOG.info("New incoming location request: {}", equipment);
        return persisterService.persistEquipment(equipment);
    }

    @PostMapping
    @RequestMapping(value = "/api/employee/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee persistEmployee(@Valid @RequestBody final Employee employee) {
        LOG.info("New incoming employee request: {}", employee);
        return persisterService.persistEmployee(employee);
    }

    @DeleteMapping
    @RequestMapping(value = "/api/location/{id}/")
    public ResponseEntity deleteLocation(@PathVariable("id") Long id) {
        LOG.info("New incoming location delete request: {}", id);
        persisterService.deleteLocation(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @RequestMapping(value = "/api/employee/{id}/")
    public ResponseEntity deleteEmployee(@PathVariable("id") Long id) {
        LOG.info("New incoming employee delete request: {}", id);
        persisterService.deleteEmployee(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    @RequestMapping(value = "/api/equipment/{id}/")
    public ResponseEntity deleteEquipment(@PathVariable("id") Long id) {
        LOG.info("New incoming equipment delete request: {}", id);
        persisterService.deleteEquipment(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping
    @RequestMapping(value = "/api/location/{id}/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Location updateLocation(@PathVariable("id") Long id, @Valid @RequestBody final Location location) {
        LOG.info("New incoming location update request: {}", id, location);
        return persisterService.updateLocation(id, location);
    }

    @PutMapping
    @RequestMapping(value = "/api/employee/{id}/",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Employee updateEmployee(@PathVariable("id") Long id, @Valid @RequestBody final Employee employee) {
        LOG.info("New incoming employee update request: {}", id , employee);
        return persisterService.updateEmployee(id, employee);
    }

    @PutMapping
    @RequestMapping(value = "/api/equipment/{id}/",consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Equipment updateEquipment(@PathVariable("id") Long id, @Valid @RequestBody final Equipment equipment) {
        LOG.info("New incoming equipment delete request: {}", id, equipment);
        return persisterService.updateEquipment(id, equipment);
    }

}
