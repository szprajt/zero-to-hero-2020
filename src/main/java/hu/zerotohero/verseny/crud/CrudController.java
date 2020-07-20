package hu.zerotohero.verseny.crud;

import hu.zerotohero.verseny.crud.model.LocationRequest;
import hu.zerotohero.verseny.crud.model.LocationResponse;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/crud")
public class CrudController {

    //TODO implement endpoints

    @PostMapping
    @RequestMapping(value = "/api/location/", headers = "Accept=application/json")
    public @ResponseBody
    LocationResponse persistLocation(@RequestBody final LocationRequest locationRequest) {
        return new LocationResponse().setAddress(locationRequest.getAddress()).setName(locationRequest.getName());
    }
}
