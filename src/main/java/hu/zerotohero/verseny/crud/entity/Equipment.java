package hu.zerotohero.verseny.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import hu.zerotohero.verseny.crud.model.Type;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Equipment {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    private String name;
    @NotNull(message = "type is required")
    private Type type;
    @ManyToOne
    @JoinColumn(name = "location_id")
    @NotNull(message = "locatedat is required")
    @JsonProperty("locatedat")
    private Location locatedAt;

    public long getId() {
        return id;
    }

    public Equipment setId(long id) {
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
