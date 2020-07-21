package hu.zerotohero.verseny.crud.entity;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location_id")
    private Location location;

    public Long getId() {
        return id;
    }

    public Equipment setId(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Equipment setName(String name) {
        this.name = name;
        return this;
    }

    public String getType() {
        return type;
    }

    public Equipment setType(String type) {
        this.type = type;
        return this;
    }

    public Location getLocation() {
        return location;
    }

    public Equipment setLocation(Location location) {
        this.location = location;
        return this;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", location=" + location +
                '}';
    }
}
