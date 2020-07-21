package hu.zerotohero.verseny.crud.entity;

import hu.zerotohero.verseny.crud.model.Job;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @NotBlank(message = "Name is required")
    private String name;
    @NotNull(message = "job is required")
    private Job job;
    @ManyToOne
    @JoinColumn(name = "location_id")
    @NotNull(message = "worksAt is required")
    private Location worksAt;
    @OneToOne
    @JoinColumn(name = "equipment_id", referencedColumnName = "id")
    private Equipment operates;

    public Long getId() {
        return id;
    }

    public Employee setId(Long id) {
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
