package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.model.Job;

public interface Validatable {

    boolean isValidatable(Job job);
    void validate(Employee employee);
}
