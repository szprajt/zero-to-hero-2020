package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.model.Job;
import hu.zerotohero.verseny.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.OptionalInt;

@Service
public class ManagerValidator implements Validatable {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public boolean isValidatable(Job job) {
        return Job.MANAGER.equals(job);
    }

    @Override
    public void validate(Employee employee) {
        List<Employee> employees = employeeRepository.findByWorksAt(employee.getWorksAt());
        if (employees.stream().anyMatch(employee1 -> checkEmployee(employee, employee1))) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Only one manager should work on one location");
        }
        OptionalInt max = employees.stream().mapToInt(Employee::getSalary).max();
        if (max.isPresent() && max.getAsInt() > employee.getSalary()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Manager should earn the most");
        }
    }

    private boolean checkEmployee(Employee original, Employee checked) {
        return (checked.getId() != original.getId()) && Job.MANAGER.equals(checked.getJob());
    }
}


