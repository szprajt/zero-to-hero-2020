package hu.zerotohero.verseny.crud.entity;

import hu.zerotohero.verseny.crud.model.Type;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @NotBlank(message = "Type is required")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "location_id")
    @NotNull(message = "Location is required")
    private Location locatedAt;

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

    public Type getType() {
        return type;
    }

    public Equipment setType(Type type) {
        this.type = type;
        return this;
    }

    public Location getLocatedAt() {
        return locatedAt;
    }

    public Equipment setLocatedAt(Location locatedAt) {
        this.locatedAt = locatedAt;
        return this;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", locatedAt=" + locatedAt +
                '}';
    }
}
