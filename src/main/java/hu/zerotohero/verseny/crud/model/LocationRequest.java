package hu.zerotohero.verseny.crud.model;

public class LocationRequest {

    private String name;
    private String address;

    public String getName() {
        return name;
    }

    public LocationRequest setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public LocationRequest setAddress(String address) {
        this.address = address;
        return this;
    }
}
