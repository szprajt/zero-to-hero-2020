package hu.zerotohero.verseny.crud;

import hu.zerotohero.verseny.crud.entity.Equipment;
import hu.zerotohero.verseny.crud.entity.Location;
import hu.zerotohero.verseny.crud.service.CrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/crud")
public class CrudController {

    private static final Logger LOG = LoggerFactory.getLogger(CrudController.class);

    @Autowired
    private CrudService crudService;

    @PostMapping
    @RequestMapping(value = "/api/location/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Location persistLocation(@Valid @RequestBody final Location locationRequest) {
        LOG.info("New incoming location request: {}", locationRequest);
        return crudService.persistLocation(locationRequest);
    }

    @PostMapping
    @RequestMapping(value = "/api/equipment/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Equipment persistEquipment(@Valid @RequestBody final Equipment equipment) {
        LOG.info("New incoming location request: {}", equipment);
        Equipment equipment1 = crudService.persistEquipment(equipment);
        return equipment1;
    }
}
