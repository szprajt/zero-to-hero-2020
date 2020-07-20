package hu.zerotohero.verseny.crud.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationRepository<Location, Long> extends CrudRepository<Location, Long> {
}
