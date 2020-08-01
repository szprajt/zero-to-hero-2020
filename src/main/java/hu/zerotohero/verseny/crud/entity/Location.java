package hu.zerotohero.verseny.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;


@Entity
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^(?:\\w+\\W+){0,1}(?:\\w+)$", message = "Name of location is maximum 2 word")
    private String name;
    @NotBlank(message = "Address is required")
    @Pattern(regexp = "^\\d{4}.*$", message = "Address should start with zip code")
    private String address;

    public long getId() {
        return id;
    }

    public Location setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Location setName(String name) {
        this.name = name;
        return this;
    }

    public String getAddress() {
        return address;
    }

    public Location setAddress(String address) {
        this.address = address;
        return this;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
