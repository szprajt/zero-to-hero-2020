package hu.zerotohero.verseny.crud.repository;

import hu.zerotohero.verseny.crud.entity.Employee;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long> {

    @Query(value = "SELECT * FROM Employee e WHERE e.location_id = :locationId")
    List<Employee> findEmployeesByLocation(@Param("locationId") long locationId);
}
