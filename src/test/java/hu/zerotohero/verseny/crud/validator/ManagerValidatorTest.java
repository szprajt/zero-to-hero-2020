package hu.zerotohero.verseny.crud.validator;

import hu.zerotohero.verseny.crud.entity.Employee;
import hu.zerotohero.verseny.crud.entity.Location;
import hu.zerotohero.verseny.crud.repository.EmployeeRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ManagerValidatorTest {

    @Mock
    private EmployeeRepository employeeRepository;
    @InjectMocks
    private ManagerValidator underTest;

    @Rule
    public ExpectedException exceptionRule = ExpectedException.none();

    @Test
    public void testShouldThrowErrorIfNotManagerHasTheHighestSalary() {
        //GIVEN
        exceptionRule.expect(ResponseStatusException.class);
        exceptionRule.expectMessage("Manager should earn the most");
        Employee employee = new Employee().setSalary(450).setWorksAt(new Location());
        when(employeeRepository.findByWorksAt(any(Location.class))).thenReturn(mockList());
        //WHEN
        underTest.validate(employee);
        //THEN
    }

    private List<Employee> mockList(){
        return Arrays.asList(new Employee().setSalary(200),new Employee().setSalary(400),new Employee().setSalary(500));
    }

}