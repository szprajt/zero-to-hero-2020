package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.model.Job;
import hu.zerotohero.verseny.crud.model.Type;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class CashierValidator implements Validatable {

    @Override
    public boolean isValidatable(Job job) {
        return Job.CASHIER.equals(job);
    }

    @Override
    public void validate(Employee employee) {
        if (Job.CASHIER.equals(employee.getJob()) && !Type.CASH_REGISTER.equals(employee.getOperates().getType())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Cashier only work with cash register");
        }
    }
}
