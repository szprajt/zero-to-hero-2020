package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.model.Job;
import hu.zerotohero.verseny.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Component
public class ManagerValidator implements Validatable {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValidatable(Job job) {
        return Job.MANAGER.equals(job);
    }

    @Override
    public void validate(Employee employee) {
        List<Employee> employees = employeeRepository.findEmployeesByLocation(employee.getWorksAt().getId());
        if (employees.stream().anyMatch(employee1 -> checkEmployee(employee, employee1))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only one manager should work on one location");
        }
    }

    private boolean checkEmployee(Employee original, Employee checked) {
        return !original.getId().equals(checked.getId()) && Job.MANAGER.equals(checked.getJob());
    }
}


