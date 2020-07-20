package hu.zerotohero.verseny.crud.model;

public class LocationResponse {
    private long id;
    private String name;
    private String address;

    public long getId() {
        return id;
    }

    public LocationResponse setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public LocationResponse setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public LocationResponse setAddress(String address) {
        this.address = address;
        return this;
    }
}
