package hu.zerotohero.verseny.crud.entity;

import javax.persistence.*;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String type;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id")
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
}
