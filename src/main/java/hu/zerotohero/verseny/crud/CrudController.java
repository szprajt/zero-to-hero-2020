package hu.zerotohero.verseny.crud;

import hu.zerotohero.verseny.crud.entity.Location;
import hu.zerotohero.verseny.crud.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class CrudController {

    @Autowired
    private CrudService crudService;

    //TODO implement endpoints

    @PostMapping
    @RequestMapping(value = "/api/location/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public Location persistLocation(@RequestBody final Location locationRequest) {
        return crudService.persistLocation(locationRequest);
    }
}
