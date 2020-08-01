package hu.zerotohero.verseny.crud.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import hu.zerotohero.verseny.crud.model.Job;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long id;
    @NotBlank(message = "Name is required")
    @Pattern(regexp = "^(?:\\w+\\W+){1,2}(?:\\w+)$", message = "Employee name at least 2 maximum 3 word")
    private String name;
    @NotNull(message = "job is required")
    private Job job;
    @ManyToOne
    @JoinColumn(name = "location_id")
    @NotNull(message = "worksat is required")
    @JsonProperty("worksat")
    private Location worksAt;
    @OneToOne
    @JoinColumn(name = "equipment_id", referencedColumnName = "id", unique = true)
    private Equipment operates;
    @Min(value = 300, message = "Salary at least 300")
    private Integer salary;

    public long getId() {
        return id;
    }

    public Employee setId(long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public Job getJob() {
        return job;
    }

    public Employee setJob(Job job) {
        this.job = job;
        return this;
    }

    public Location getWorksAt() {
        return worksAt;
    }

    public Employee setWorksAt(Location worksAt) {
        this.worksAt = worksAt;
        return this;
    }

    public Equipment getOperates() {
        return operates;
    }

    public Employee setOperates(Equipment operates) {
        this.operates = operates;
        return this;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job=" + job +
                ", worksAt=" + worksAt +
                ", operates=" + operates +
                '}';
    }
}
