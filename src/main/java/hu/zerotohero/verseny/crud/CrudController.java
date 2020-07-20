package hu.zerotohero.verseny.crud;

import hu.zerotohero.verseny.crud.model.LocationRequest;
import hu.zerotohero.verseny.crud.model.LocationResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class CrudController {

    //TODO implement endpoints

    @PostMapping
    @RequestMapping(value = "/api/location/", consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public LocationResponse persistLocation(@RequestBody final LocationRequest locationRequest) {
        return new LocationResponse().setAddress(locationRequest.getAddress()).setName(locationRequest.getName());
    }
}
