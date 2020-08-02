package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.entity.Equipment;
import hu.zerotohero.verseny.crud.entity.Location;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.web.server.ResponseStatusException;


public class WorkerValidatorTest {

    private WorkerValidator underTest = new WorkerValidator();

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testEquipmentAndEmployeeIsNotInSameLocation() {
        //GIVEN
        exceptionRule.expect(ResponseStatusException.class);
        exceptionRule.expectMessage("Equipment should be on the same location as the working place");
        Employee employee = new Employee()
                .setOperates(new Equipment().setLocatedAt(new Location().setId(1l)))
                .setWorksAt(new Location().setId(2l));
        //WHEN
        underTest.validate(employee);
    }
}