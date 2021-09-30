package joydeep.springframework.spring.framework.pet.clinic.repositories;

import joydeep.springframework.spring.framework.pet.clinic.models.Owner;
import org.springframework.data.repository.CrudRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.Optional;


public interface OwnerRepository extends CrudRepository<Owner,Long> {

    Optional<Owner> findByLastName(String lastName);

}
