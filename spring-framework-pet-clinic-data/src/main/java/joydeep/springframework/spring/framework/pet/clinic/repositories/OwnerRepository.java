package joydeep.springframework.spring.framework.pet.clinic.repositories;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import joydeep.springframework.spring.framework.pet.clinic.services.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Optional<Owner> findByLastName(String lastName);

}
