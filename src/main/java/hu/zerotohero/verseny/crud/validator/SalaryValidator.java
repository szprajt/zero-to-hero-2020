package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.model.Job;
import hu.zerotohero.verseny.crud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;

@Service
public class SalaryValidator implements Validatable {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public boolean isValidatable(Job job) {
        return true;
    }

    @Override
    public void validate(Employee employee) {
        List<Employee> employees = employeeRepository.findByWorksAt(employee.getWorksAt());
        Optional<Employee> manager = employees.stream().filter(employee1 -> Job.MANAGER.equals(employee1.getJob())).findFirst();
        if (manager.isPresent() && manager.get().getSalary() < employee.getSalary()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Manager should earn the most");
        }
        OptionalDouble average = employees.stream()
                .filter(employee1 -> employee.getJob().equals(employee1.getJob()))
                .mapToInt(employee1 -> employee1.getSalary())
                .average();
        if (average.isPresent() && salaryIsOutOfBound(average.getAsDouble(), employee.getSalary())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Salary must be in 20% range the average is: " + average.getAsDouble());
        }
    }

    private boolean salaryIsOutOfBound(double average, Integer salary) {
        return (salary > (average * 1.2)) || (salary < (average * 0.8));
    }
}
