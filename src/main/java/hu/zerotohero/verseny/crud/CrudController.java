package hu.zerotohero.verseny.crud;

import hu.zerotohero.verseny.crud.model.LocationRequest;
import hu.zerotohero.verseny.crud.model.LocationResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crud")
public class CrudController {

    //TODO implement endpoints

    @PostMapping
    @RequestMapping(value = "/api/location/", headers = "Accept=application/json")
    public LocationResponse persistLocation(final LocationRequest locationRequest) {
        return new LocationResponse().setAddress(locationRequest.getAddress()).setName(locationRequest.getName());
    }
}
