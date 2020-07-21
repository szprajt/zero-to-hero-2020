package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.model.Job;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Objects;

@Service
public class WorkerValidator implements Validatable {

    @Override
    public boolean isValidatable(Job job) {
        return Job.CASHHIER.equals(job) || Job.COOK.equals(job);
    }

    @Override
    public void validate(Employee employee) {
        if (Objects.isNull(employee.getOperates())) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "For " + employee.getJob() + " equipment is essential");
        }
        if (employee.getWorksAt().getId() == employee.getOperates().getLocatedAt().getId()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Equipment should be on the same location as the working place");
        }
    }
}
