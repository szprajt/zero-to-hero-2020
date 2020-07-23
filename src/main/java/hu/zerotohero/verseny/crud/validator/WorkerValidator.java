package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.model.Job;
import hu.zerotohero.verseny.crud.model.Type;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class WorkerValidator implements Validatable {

    @Override
    public boolean isValidatable(Job job) {
        return Job.CASHIER.equals(job) || Job.COOK.equals(job);
    }

    @Override
    public void validate(Employee employee) {
        if (Objects.isNull(employee.getOperates())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "For " + employee.getJob() + " equipment is essential");
        } else {
            if (Objects.nonNull(employee.getOperates().getLocatedAt()) && employee.getWorksAt().getId() != employee.getOperates().getLocatedAt().getId()) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Equipment should be on the same location as the working place");
            }
        }
        if (Job.CASHIER.equals(employee.getJob()) && !Type.CASH_REGISTER.equals(employee.getOperates().getType())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cashier only work with cash register");
        }
        if (Job.COOK.equals(employee.getJob()) && !Type.OVEN.equals(employee.getOperates().getType())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cook only work with oven");
        }
    }
}
