package joydeep.springframework.spring.framework.pet.clinic.services;

import java.util.Set;

public interface CrudRepository<R, ID> {

    R save(R entity);

    R findByIdentity(ID id);

    Set<R> findAll();

    void delete(R entity);

    void deleteByIdentity(ID id);
}
